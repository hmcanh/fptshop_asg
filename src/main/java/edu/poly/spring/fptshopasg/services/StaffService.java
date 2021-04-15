package edu.poly.spring.fptshopasg.services;

import edu.poly.spring.fptshopasg.models.Depart;
import edu.poly.spring.fptshopasg.models.Staff;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface StaffService   {


    List<Depart> findAllDeparts();

    Staff save(Staff entity);

    List<Staff> saveAll(Iterable<Staff> iterable);

    Optional<Staff> findById(Long aLong);

    boolean existsById(Long aLong);

    Iterable<Staff> findAll();

    Iterable<Staff> findAllById(Iterable<Long> iterable);

    long count();

    void deleteById(Long aLong);

    void delete(Staff staff);

    void deleteAll(List<Staff> entity);

    void deleteAll();
}
