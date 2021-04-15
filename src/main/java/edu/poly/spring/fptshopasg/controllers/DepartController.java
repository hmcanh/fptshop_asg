package edu.poly.spring.fptshopasg.controllers;

import edu.poly.spring.fptshopasg.models.Depart;
import edu.poly.spring.fptshopasg.services.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/departs")
public class DepartController {
    @Autowired
     private DepartService departService;

    @GetMapping("/add")

    public String add(Model model) {
        model.addAttribute("depart", new Depart());
        return "departs/addOrEdit";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(Model model, Depart depart) {
        String message="New depart inserted!";
        if (depart.getId()!=null && depart.getId() > 0){
            message="the depart updated";
        }
        departService.save(depart);
        model.addAttribute(depart);
        model.addAttribute("message",message);
        return "departs/addOrEdit";
    }

    @GetMapping("/edit/{id}")
    public String edit( Model model ,@PathVariable(name ="id") Integer id) {
         Optional<Depart> optDepart = departService.findById(id);
         if (optDepart.isPresent()){
             model.addAttribute("depart",optDepart.get());
         }else{
             return list(model);
         }
        return "departs/addOrEdit";
    }

    @GetMapping("/delete/{id}")
    public String delete( Model model,@PathVariable(name ="id") Integer id) {
        departService.deleteById(id);
        return list(model);
    }

    @RequestMapping("/list")
    public String list( Model model) {
        List<Depart> list = (List<Depart>) departService.findAll();
        model.addAttribute("departs",list);
        return "departs/list";
    }

    @RequestMapping("/find")
    public String find( Model model,@RequestParam(defaultValue = "") String name) {
       List<Depart> list = departService.findByNameLikeOrderByName(name);
       model.addAttribute("departs",list);
        return "departs/find";
    }

}
