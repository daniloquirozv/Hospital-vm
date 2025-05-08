package com.hospital_vm.cl.hopital_vm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital_vm.cl.hopital_vm.Model.Paciente;
import java.util.List;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {  

    //Usando JPQL
    @Query("SELECT p FROM Paciente p WHERE p.apellido= : apellido")
    List<Paciente> findByApellido(String apellido);

    //Usando SQL nativo
    @Query(value = "SELECT * FROM Paciente WHERE correo= :correo", nativeQuery = true)
    Paciente findByCorreo(String correo);

    List<Paciente> findByNombreAndApellido(String nombre, String apellido);
    

}
