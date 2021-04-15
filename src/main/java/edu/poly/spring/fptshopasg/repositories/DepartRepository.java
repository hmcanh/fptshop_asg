package edu.poly.spring.fptshopasg.repositories;

import edu.poly.spring.fptshopasg.models.Depart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartRepository extends CrudRepository<Depart,Integer> {
 List<Depart>findByNameLikeOrderByName(String name);

}
