package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Paciente")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    
    private String direccion;
    
    private String telefono;
    
    private String correoElectronico;
    
    @Lob
    private String historialOdontologico;
    
    @Lob
    private String alergias;
    
    @Lob
    private String tratamientosPrevios;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getHistorialOdontologico() {
		return historialOdontologico;
	}

	public void setHistorialOdontologico(String historialOdontologico) {
		this.historialOdontologico = historialOdontologico;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getTratamientosPrevios() {
		return tratamientosPrevios;
	}

	public void setTratamientosPrevios(String tratamientosPrevios) {
		this.tratamientosPrevios = tratamientosPrevios;
	}
    
     
    
}
