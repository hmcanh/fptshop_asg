package edu.poly.spring.fptshopasg.services;

import edu.poly.spring.fptshopasg.models.Depart;
import edu.poly.spring.fptshopasg.repositories.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository departRepository;


    public Depart save(Depart entity) {
        return departRepository.save(entity);
    }

    public List<Depart> saveAll(List<Depart> entities) {
        return (List<Depart>) departRepository.saveAll(entities);
    }


    public Optional<Depart> findById(Integer integer) {
        return departRepository.findById(integer);
    }


    public boolean existsById(Integer integer) {
        return departRepository.existsById(integer);
    }


    public Iterable<Depart> findAll() {
        return departRepository.findAll();
    }


    public List<Depart> findAllById(List<Integer> ids) {
        return (List<Depart>) departRepository.findAllById(ids);
    }

    @Override
    public List<Depart> findByNameLikeOrderByName(String name) {
        return departRepository.findByNameLikeOrderByName("%"+name+"%");
    }

    public long count() {
        return departRepository.count();
    }


    public void deleteById(Integer id) {
        departRepository.deleteById(id);
    }


    public void delete(Depart depart) {
        departRepository.delete(depart);
    }


    public void deleteAll(List<Depart> entities) {
        departRepository.deleteAll(entities);
    }


    public void deleteAll() {
        departRepository.deleteAll();
    }
}
