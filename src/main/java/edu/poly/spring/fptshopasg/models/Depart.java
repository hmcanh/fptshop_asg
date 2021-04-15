package edu.poly.spring.fptshopasg.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Component
@Data
@Entity
@Table(name="departs")
public class Depart  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(length = 100)
    private String name;
    @OneToMany(mappedBy="depart" , cascade = CascadeType.ALL)
    //Định nghĩa quan hệ
    // Từ 1 depart ta có thế lấy 1 danh sách staffs thuộc về departs này
          private Set<Staff> staffs;

    public Depart(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Depart() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }
}
