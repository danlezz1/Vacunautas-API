package com.vacunautas.api.controllers;

import java.util.List;

import javax.xml.transform.OutputKeys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vacunautas.api.entity.Vacuna;
import com.vacunautas.api.services.VacunaService;

@RestController
public class VacunaController {
	
	@Autowired
	private VacunaService vacunaService;
	
	@GetMapping(value = "/vacunas")
	public ResponseEntity<List<Vacuna>> findAll() {
		List<Vacuna> vacunas = vacunaService.findAll();
		return new ResponseEntity<List<Vacuna>>(vacunas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/vacunas/{id}")
	public ResponseEntity<Vacuna> findById(@PathVariable("id") Long id) {
		Vacuna vacuna = vacunaService.findById(id);		
		
		return new ResponseEntity<Vacuna>(vacuna, HttpStatus.OK);
	}
	
	@PostMapping(value = "/vacunas")
	public ResponseEntity<Vacuna> create(@RequestBody Vacuna vacuna) {
		Vacuna nuevaVacuna = vacunaService.create(vacuna);
		return new ResponseEntity<>(nuevaVacuna, HttpStatus.CREATED); 
	}
	
	@PutMapping(value = "/vacunas")
	public ResponseEntity<Vacuna> update(@RequestBody Vacuna vacuna) {
		Vacuna existeVacuna = vacunaService.update(vacuna);
		return new ResponseEntity<Vacuna>(existeVacuna, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/vacunas/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		vacunaService.delete(id);
		return new ResponseEntity<>("Vacuna eliminada con exito...", HttpStatus.OK);
	}

}
