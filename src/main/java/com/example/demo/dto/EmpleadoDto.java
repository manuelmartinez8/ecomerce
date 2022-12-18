package com.example.demo.dto;

import com.example.demo.entity.Orden;
import com.example.demo.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpleadoDto {

    private long id;


    private String nombre;


    private String apellido;


    private String emailId;


    private String tipo;


    private String password;


    private List<Producto> productoList;


    private List<Orden> ordenes;


}
