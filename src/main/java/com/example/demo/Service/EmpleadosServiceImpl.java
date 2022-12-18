package com.example.demo.Service;

import com.example.demo.Service.interfaces.EmpleadosService;
import com.example.demo.dto.EmpleadoDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.Empleado;
import com.example.demo.repository.EmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

    @Autowired
    private EmpleadosRepository repository;

    ModelMapper modelMapper = new ModelMapper();


    public EmpleadoDto getEmpleado(long id){
        return mapEmpleado(repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" + id)));
    }

    public Empleado  createEmpleado(EmpleadoDto dto){
        Empleado empleado = mapEmpleadoDto(dto);
        return  repository.save(empleado);
    }

    public List<EmpleadoDto> getAllEmpleados() {
        List<Empleado> empleados = repository.findAll();
        List<EmpleadoDto> allEmpleados = empleados.stream().map(empl->mapEmpleado(empl))
                .collect(Collectors.toList());
        return allEmpleados;
    }

    public EmpleadoDto updateEmpleado(EmpleadoDto dto, long id){
        Empleado empleado = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" + id));
        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setEmailId(dto.getEmailId());
        empleado.setTipo(dto.getTipo());
        repository.save(empleado);

        return mapEmpleado(empleado);
    }

    public void deleteEmpleado(long id){
        Empleado empleado = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" + id));
        repository.delete(empleado);
    }


    public EmpleadoDto mapEmpleado(Empleado empleado){
        EmpleadoDto dto = modelMapper.map(empleado, EmpleadoDto.class);
        return dto;
    }

    public  Empleado mapEmpleadoDto(EmpleadoDto dto){
        Empleado empleado = modelMapper.map(dto, Empleado.class);
        return  empleado;
    }

    @Override
    public EmpleadoDto getEmpleadoByNombre(String nombre) {
        return null;
    }



   /* public boolean containsSwearWords(String comment){
        if(comment.contains("shit")){
            throw new IllegalArgumentException("Comments contains unaccetable language");
        }
        return false;
    }*/

}
