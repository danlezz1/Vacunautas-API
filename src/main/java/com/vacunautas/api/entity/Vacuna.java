package com.vacunautas.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "vacunas")
public class Vacuna {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "dosis", nullable = false, length = 20)
	private String dosis;
	
	@Column(name = "via_aplicacion", nullable = false, length = 20)
	private String viaAplicacion;
	
	@Column(name = "laboratorio", columnDefinition = "varchar(100) default 'N/A'", nullable = true)
	private String laboratorio;
	
	@Column(name = "numero_lote", columnDefinition = "varchar(100) default 'N/A'", nullable = false)
	private String num_lote;

}
