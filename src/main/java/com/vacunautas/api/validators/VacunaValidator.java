package com.vacunautas.api.validators;

import com.vacunautas.api.entity.Vacuna;

public class VacunaValidator {
	
	public static void comprobar(Vacuna vacuna) {
		if(vacuna.getNombre() == null || vacuna.getNombre().trim().isEmpty()) {
			throw new RuntimeException("El nombre de la vacuna es obligatorio.");				
		}
		
		if(vacuna.getNombre().length() > 100) {
			throw new RuntimeException("El nombre de la vacuna excede la cantidad de caracteres "
					+ "permitida, utilice máximo 100 caracteres.");
		}
		
		if(vacuna.getDosis() == null || vacuna.getDosis().trim().isEmpty()) {
			throw new RuntimeException("Por favor especifique la dosis de la vacuna. "
					+ "(Ejemplo: primera, segunda, refuerzo, única, etc");
		}
		
		if(vacuna.getDosis().length() > 20) {
			throw new RuntimeException("La especificación de la dosis excede la cantidad de caracteres "
					+ "permitida, utilice máximo 20 caracteres.");
		}
		
		if(vacuna.getViaAplicacion() == null || vacuna.getViaAplicacion().trim().isEmpty()) {
			throw new RuntimeException("Debe especificar la vía de aplicación de la vacuna.(Ejemplo: vía oral.)");
		}
		
		if(vacuna.getViaAplicacion().length() > 20) {
			throw new RuntimeException("La especificación de la vía de aplicación de la vacuna excede la "
					+ "cantidad de caracteres permitida, utilice máximo 20 caracteres.");
		}
		
		if(vacuna.getLaboratorio() == null || vacuna.getLaboratorio().trim().isEmpty()) {
			vacuna.setLaboratorio("N/A");
		}
		
		if(vacuna.getLaboratorio().length() > 100) {
			throw new RuntimeException("El nombre del laboratorio de la vacuna excede la cantidad de caracteres "
					+ "permitida, utilice máximo 100 caracteres.");
		}
		
		if(vacuna.getNum_lote() == null || vacuna.getNum_lote().trim().isEmpty()) {
			vacuna.setNum_lote("N/A");
		}
		
		if(vacuna.getNum_lote().length() > 100) {
			throw new RuntimeException("El número del lote de la vacuna excede la cantidad de caracteres "
					+ "permitida, utilice máximo 100 caracteres.");
		}
		
	}

}
