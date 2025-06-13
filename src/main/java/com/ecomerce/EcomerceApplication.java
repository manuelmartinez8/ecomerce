package com.ecomerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomerceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EcomerceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		/*
		Empleado empleado = new Empleado();
		empleado.setNombre("Manuel");
		empleado.setApellido("Martinez");
		empleado.setEmailId("manuelon_8");

		repo.save(empleado);

		Empleado empleado2 = new Empleado();
		empleado2.setNombre("Adriana");
		empleado2.setApellido("Martinez");
		empleado2.setEmailId("Adri_8");
		repo.save(empleado2);*/
	}
}
