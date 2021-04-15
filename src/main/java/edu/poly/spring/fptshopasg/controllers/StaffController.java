package edu.poly.spring.fptshopasg.controllers;


import edu.poly.spring.fptshopasg.dtos.StaffDto;
import edu.poly.spring.fptshopasg.models.Depart;
import edu.poly.spring.fptshopasg.models.Staff;
import edu.poly.spring.fptshopasg.services.DepartService;
import edu.poly.spring.fptshopasg.services.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("staffs", staffService.findAll());
        return "staffs/list";
    }
    // Cho phép nhập mới staff
    @GetMapping("/add")
    public String add(Model model) {
        StaffDto staff = new StaffDto();

        model.addAttribute("staffDto", staff);
        return "staffs/addOrEdit";

    }
// Nhận  và lưu vào CSDL
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(Model model,
                               @Validated StaffDto staffDto,
                               BindingResult result
) {
        if (result.hasErrors()){
            model.addAttribute("message"," Please input all required fields!!");
            model.addAttribute(" staffDto",staffDto);
            return "staffs/addOrEdit";
        }
        if (staffDto.getId() != null && staffDto.getId() > 0) {
            model.addAttribute("message", "The staffDto updated");
        } else {
            model.addAttribute("message", " new Staff inserted");
        }
        Path path = Paths.get("images/");
        try ( InputStream inputStream = staffDto.getImage().getInputStream()){
        Files.copy(inputStream,path.resolve(staffDto.getImage().getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING);
        String filename=staffDto.getImage().getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message","Error : "+e.getMessage());
        }
        Staff staff = new Staff();
        staff.setBirthday(staffDto.getBirthday());
        staff.setPhoto(staffDto.getImage().getOriginalFilename());
        Depart depart= new Depart();
        depart.setId(staffDto.getDepartId());
        staff.setDepart(depart);
        staffService.save(staff);
        model.addAttribute("staffDto",staffDto);
        return "staffs/addOrEdit";
    }

    @ModelAttribute(name = "departs")
    public List<Depart> getDeparts() {
        return staffService.findAllDeparts();
    }
}
