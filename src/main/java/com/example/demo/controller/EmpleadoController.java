package com.example.demo.controller;

import com.example.demo.Service.EmpleadosServiceImpl;
import com.example.demo.dto.EmpleadoDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.Empleado;
import com.example.demo.repository.EmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadosRepository repository;
    @Autowired
    private EmpleadosServiceImpl service;

    @GetMapping("/all")
    public List<EmpleadoDto> getAllEmployees(){
        return service.getAllEmpleados();
    }

    @PostMapping
    public Empleado crearEmpleado(@RequestBody  EmpleadoDto em){
    return service.createEmpleado(em);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmpleadoDto> getEmployeeById(@PathVariable  long id){
        return new ResponseEntity<EmpleadoDto>(service.getEmpleado(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable long id, @RequestBody Empleado em){
        Empleado updateEmpleado = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" + id));

        updateEmpleado.setNombre(em.getNombre());
        updateEmpleado.setApellido(em.getApellido());
        updateEmpleado.setEmailId(em.getEmailId());
        repository.save(em);

    return ResponseEntity.ok(updateEmpleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpleado(@PathVariable  long id){
    service.deleteEmpleado(id);
    return new ResponseEntity<>("Empleado eliminado con exito!", HttpStatus.OK);

    }
}
