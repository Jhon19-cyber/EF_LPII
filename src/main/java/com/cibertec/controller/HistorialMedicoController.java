package com.cibertec.controller;

import com.cibertec.model.HistorialMedico;
import com.cibertec.model.Paciente;
import com.cibertec.service.HistorialMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/historial")
public class HistorialMedicoController {

    @Autowired
    private HistorialMedicoService historialMedicoService;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("historialMedico", new HistorialMedico());
        return "registroAtencion"; 
    }

    @PostMapping("/registro")
    public String registrarAtencion(@ModelAttribute("historialMedico") HistorialMedico historialMedico) {
        historialMedicoService.registrarAtencion(historialMedico);
        return "redirect:/historial/lista"; 
    }

    @GetMapping("/lista")
    public String listarAtenciones(Model model) {
        List<HistorialMedico> listaAtenciones = historialMedicoService.listarAtenciones();
        model.addAttribute("atenciones", listaAtenciones);
        return "listaAtenciones"; 
    }
    
    @GetMapping("/paciente/{pacienteId}")
    public String listarHistorialPorPaciente(@PathVariable Integer pacienteId, Model model) {
        List<HistorialMedico> historial = historialMedicoService.listarHistorialPorPaciente(pacienteId);
        model.addAttribute("historial", historial);
        model.addAttribute("pacienteId", pacienteId);
        return "historialPorPaciente"; 
    }




}
   

