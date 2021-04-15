package edu.poly.spring.fptshopasg.repositories;

import edu.poly.spring.fptshopasg.models.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {

}
