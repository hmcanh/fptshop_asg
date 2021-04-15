package edu.poly.spring.fptshopasg.services;

import edu.poly.spring.fptshopasg.models.Depart;
import edu.poly.spring.fptshopasg.models.Staff;
import edu.poly.spring.fptshopasg.repositories.DepartRepository;
import edu.poly.spring.fptshopasg.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private DepartRepository departRepository;

    @Override
    public List<Depart> findAllDeparts() {
        return (List<Depart>) departRepository.findAll();
    }

    @Override
    public Staff save(Staff entity) {
        return staffRepository.save(entity);
    }

    @Override
    public List<Staff> saveAll(Iterable<Staff> entities) {
        return (List<Staff>) staffRepository.saveAll(entities);
    }

    @Override
    public Optional<Staff> findById(Long aLong) {
        return staffRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return staffRepository.existsById(aLong);
    }

    @Override
    public List<Staff> findAll() {
        return (List<Staff>) staffRepository.findAll();
    }

    @Override
    public Iterable<Staff> findAllById(Iterable<Long> iterable) {
        return staffRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return staffRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        staffRepository.deleteById(aLong);
    }

    @Override
    public void delete(Staff entity) {
        staffRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<Staff> entites) {
        staffRepository.deleteAll(entites);
    }

    @Override
    public void deleteAll() {
        staffRepository.deleteAll();
    }
}