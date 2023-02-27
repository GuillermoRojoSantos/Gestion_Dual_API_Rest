/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demo.repositories;

import com.example.demo.modelos.Alumno;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AlejandroMarínBermúd
 * @author guiro
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
    
    public Optional<Alumno> findByNombre(String nombre);
    
    public Optional<Alumno> findByEmpresa(String empresa);
    
    public Optional<Alumno> findByProfesor(String profesor);
    
    public Optional<Alumno> findById(Long id);

}
