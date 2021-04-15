package edu.poly.spring.fptshopasg.services;

import edu.poly.spring.fptshopasg.models.Depart;
import edu.poly.spring.fptshopasg.repositories.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartService {

    Depart save(Depart entity);

    List<Depart> saveAll(List<Depart> entities);

    Optional<Depart> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Depart> findAll();

    List<Depart> findAllById(List<Integer> iterable);

    List<Depart> findByNameLikeOrderByName(String name);


    long count();

    void deleteById(Integer id);

    void delete(Depart depart);

    void deleteAll(List<Depart> entities);

    void deleteAll();

}
