package com.hospital_vm.cl.hopital_vm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hopital_vm.Model.Atencion;
import com.hospital_vm.cl.hopital_vm.Repository.AtencionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    public List<Atencion> findAll() {
        return atencionRepository.findAll();
    }

    public Atencion findById (Long id){
        return atencionRepository.findById(id).get();
    }

    public Atencion save(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    public void delete(Long id) {
        atencionRepository.deleteById(id);
    }

}
