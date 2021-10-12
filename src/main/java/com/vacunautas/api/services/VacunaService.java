package com.vacunautas.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacunautas.api.entity.Vacuna;
import com.vacunautas.api.repository.VacunaRepository;

@Service
public class VacunaService {

	@Autowired
	private VacunaRepository vacunaRepository;

	// Listar todas las vacunas
	public List<Vacuna> findAll() {
		return vacunaRepository.findAll();
	}

	// Buscar vacuna por ID
	public Vacuna findById(Long id) {
		Vacuna vacuna = vacunaRepository.findById(id).orElseThrow(() -> new RuntimeException("La vacuna no existe..."));
		return vacuna;
	}

	// Crear vacuna
	@Transactional
	public Vacuna create(Vacuna vacuna) {
		Vacuna newVacuna = vacunaRepository.save(vacuna);
		return newVacuna;
	}

	// Actualizar vacuna
	@Transactional
	public Vacuna update(Vacuna vacuna) {
		Vacuna existeVacuna = vacunaRepository.findById(vacuna.getId())
				.orElseThrow(() -> new RuntimeException("La vacuna no existe..."));

		existeVacuna.setDosis(vacuna.getDosis());
		existeVacuna.setLaboratorio(vacuna.getLaboratorio());
		existeVacuna.setNombre(vacuna.getNombre());
		existeVacuna.setNum_lote(vacuna.getNum_lote());
		existeVacuna.setViaAplicacion(vacuna.getViaAplicacion());

		vacunaRepository.save(existeVacuna);
		return existeVacuna;
	}

	// Eliminar vacuna
	@Transactional
	public void delete(Long id) {
		Vacuna existeVacuna = vacunaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("La vacuna no existe..."));

		vacunaRepository.delete(existeVacuna);
	}

}
