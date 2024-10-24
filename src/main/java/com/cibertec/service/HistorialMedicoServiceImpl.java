package com.cibertec.service;

import com.cibertec.model.HistorialMedico;
import com.cibertec.repository.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.service.HistorialMedicoService;


import java.util.List;

@Service
public class HistorialMedicoServiceImpl implements HistorialMedicoService {

    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    @Override
    public HistorialMedico registrarAtencion(HistorialMedico historialMedico) {
        return historialMedicoRepository.save(historialMedico);
    }

    @Override
    public List<HistorialMedico> listarAtenciones() {
        return historialMedicoRepository.findAll();
    }
    
    @Override
    public List<HistorialMedico> listarHistorialPorPaciente(Integer pacienteId) {
        return historialMedicoRepository.findByPacienteId(pacienteId);
    }
    
}

