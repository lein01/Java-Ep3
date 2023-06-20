package com.Ep3.Cliente.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(name = "tbl_cliente")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;

	@Column
	private String apellido;

	@Column(unique = true)
	private String correo;

	@Column(unique = true)
	private String celular;

	private Date fechaCreacion;
	private Date fechaModificacion;



	@PrePersist
	protected void onCreate() {
		fechaCreacion = new Date();
		fechaModificacion = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		fechaModificacion = new Date();
	}


}
