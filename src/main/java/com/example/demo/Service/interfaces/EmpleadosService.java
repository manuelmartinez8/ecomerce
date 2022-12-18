package com.example.demo.Service.interfaces;

import com.example.demo.dto.EmpleadoDto;
import com.example.demo.entity.Empleado;

import java.util.List;

public interface EmpleadosService {

    public EmpleadoDto getEmpleado(long id);
    public Empleado createEmpleado(EmpleadoDto dto);
    public List<EmpleadoDto> getAllEmpleados();
    public EmpleadoDto updateEmpleado(EmpleadoDto dto, long id);
    public void deleteEmpleado(long id);
    public EmpleadoDto mapEmpleado(Empleado empleado);
    public Empleado mapEmpleadoDto(EmpleadoDto dto);
    public EmpleadoDto getEmpleadoByNombre(String nombre);



}
