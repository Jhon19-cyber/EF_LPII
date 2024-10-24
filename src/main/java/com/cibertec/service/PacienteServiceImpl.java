package com.cibertec.service;

import com.cibertec.model.Paciente;
import com.cibertec.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.service.PacienteService;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente); 
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll(); 
    }

	@Override
	public Paciente obtenerPacientePorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}

