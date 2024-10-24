package com.cibertec.repository;

import com.cibertec.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Aquí puedes agregar consultas personalizadas si es necesario.
}

