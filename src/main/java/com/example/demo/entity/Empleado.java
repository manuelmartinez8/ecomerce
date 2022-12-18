package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String emailId;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "empleado")
    private List<Producto> productoList;

    @OneToMany(mappedBy = "empleado")
    private List<Orden> ordenes;
}
