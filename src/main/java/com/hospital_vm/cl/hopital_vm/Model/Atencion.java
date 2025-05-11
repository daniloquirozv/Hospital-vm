package com.hospital_vm.cl.hopital_vm.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Atencion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Fecha_atencion" , nullable = false)
    private String fechaAtencion;
    
    @Column(name = "Hora_atencion" , nullable = false)
    private String horaAtencion;

    @Column(name = "Costo" , nullable = false)
    private Double costo;

    @Column(name = "Comentario" , nullable = false)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
        
}
