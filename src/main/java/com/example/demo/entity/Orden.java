package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;

    private double total;
    @ManyToOne
    private Empleado empleado;
    @OneToOne(mappedBy = "orden")
    private DetalleOrden detalle;
}
