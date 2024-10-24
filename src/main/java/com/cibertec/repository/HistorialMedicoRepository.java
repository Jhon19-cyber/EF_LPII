package com.cibertec.repository;

import com.cibertec.model.HistorialMedico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Integer> {
    
	
	List<HistorialMedico> findByPacienteId(Integer  pacienteId);
}

