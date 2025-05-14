package com.hospital_vm.cl.hopital_vm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hopital_vm.Model.Atencion;
import com.hospital_vm.cl.hopital_vm.Service.AtencionService;

@RestController
@RequestMapping("/api/v1/atencion")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<Atencion>> listar(){
        List<Atencion> atenciones = atencionService.findAll();
        if(atenciones.isEmpty()){
            return ResponseEntity.noContent().build(); // Alternativa 2 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(atenciones); // Alternativa 2 return new ResponseEntity<>(atenciones, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Atencion> buscar(@PathVariable Long id){
        try {
            Atencion atencion = atencionService.findById(id);
            return ResponseEntity.ok(atencion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Atencion> guardar(@RequestBody Atencion atencion){
        Atencion atencionNuevo = atencionService.save(atencion);
        return ResponseEntity.status(HttpStatus.CREATED).body(atencionNuevo);
    }

    @PostMapping("/pacientes/{pacienteId}")
    public ResponseEntity<Atencion> guardar(@PathVariable Long pacienteId, @RequestBody Atencion atencion){
        Atencion nuevaAtencion = atencionService.saveById(atencion, pacienteId);
        if(nuevaAtencion == null){
            return null;
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAtencion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atencion> actualizar(@PathVariable Long id, @RequestBody Atencion atencion){
        try {
            Atencion at = atencionService.findById(id);
            at.setId(id);
            at.setFechaAtencion(atencion.getFechaAtencion());
            at.setHoraAtencion(atencion.getHoraAtencion());
            at.setCosto(atencion.getCosto());
            at.setComentario(atencion.getComentario());
            at.setPaciente(atencion.getPaciente());

            atencionService.save(at);
            return ResponseEntity.ok(atencion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            atencionService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
        
    

}
