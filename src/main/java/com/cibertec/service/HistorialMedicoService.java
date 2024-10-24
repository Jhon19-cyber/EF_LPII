package com.cibertec.service;

import com.cibertec.model.HistorialMedico;
import java.util.List;

public interface HistorialMedicoService {
    HistorialMedico registrarAtencion(HistorialMedico historialMedico);
    
    List<HistorialMedico> listarAtenciones();
    
    
    List<HistorialMedico> listarHistorialPorPaciente(Integer pacienteId);
}
