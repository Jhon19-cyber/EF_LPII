package com.cibertec.controller;

import com.cibertec.model.Paciente;
import com.cibertec.service.PacienteService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/pacientes/registro")
    public String mostrarFormularioRegistro(Model model) {
        Paciente paciente = new Paciente();
        model.addAttribute("paciente", paciente); 
        return "registro_paciente"; 
    }

    @PostMapping("/pacientes/registrar")
    public String registrarPaciente(@ModelAttribute("paciente") Paciente paciente, HttpServletResponse response) throws DocumentException, IOException {
        
        pacienteService.registrarPaciente(paciente);

        Document documento = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(documento, baos);

        documento.open();
        documento.add(new Paragraph("Constancia de Registro de Paciente"));
        documento.add(new Paragraph(" "));
        documento.add(new Paragraph("Nombre: " + paciente.getNombre()));
        documento.add(new Paragraph("Dirección: " + paciente.getDireccion()));
        documento.add(new Paragraph("Teléfono: " + paciente.getTelefono()));
        documento.add(new Paragraph("Correo Electrónico: " + paciente.getCorreoElectronico()));
        documento.add(new Paragraph("Historial Odontológico: " + paciente.getHistorialOdontologico()));
        documento.add(new Paragraph("Alergias: " + paciente.getAlergias()));
        documento.add(new Paragraph("Tratamientos Previos: " + paciente.getTratamientosPrevios()));
        documento.close();

        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=constancia_paciente.pdf");
        response.setContentLength(baos.size());

        
        response.getOutputStream().write(baos.toByteArray());
        response.getOutputStream().flush();
        response.getOutputStream().close();

        return "redirect:/pacientes/lista";
    }

    @GetMapping("/pacientes/lista")
    public String listarPacientes(Model model) {
        List<Paciente> listaPacientes = pacienteService.listarPacientes();
        model.addAttribute("pacientes", listaPacientes); 
        return "lista_pacientes"; 
    }
}


