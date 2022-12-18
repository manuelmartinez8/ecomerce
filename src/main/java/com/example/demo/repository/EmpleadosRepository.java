package com.example.demo.repository;

import com.example.demo.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadosRepository extends JpaRepository<Empleado, Long> {
}
