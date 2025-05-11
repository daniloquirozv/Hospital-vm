package com.hospital_vm.cl.hopital_vm.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital_vm.cl.hopital_vm.Model.Atencion;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long>{
    
    public List<Atencion> findByPacienteId(Long pacienteId);

}
