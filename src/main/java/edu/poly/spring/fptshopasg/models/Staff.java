package edu.poly.spring.fptshopasg.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;
    @Column(length = 100)
    private String photo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyyy")
    private  Date birthday;
    @ManyToOne
    @JoinColumn(name ="departId")
    private Depart depart;

//public  class Staff {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public Long id;
//    @Column(length= 50 )
//    private String name;
//    @Column(length= 100)
//    private String photo;
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "dd/mm/yyyy")
//    private  Date birthday;
//    @ManyToOne
//    @JoinColumn(name ="departId")
//    private Depart depart;

    public Staff(Long id, String name, String photo, Date birthday, Depart depart) {
       super();
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.birthday = birthday;
        this.depart = depart;
    }


    public Staff() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }
}

