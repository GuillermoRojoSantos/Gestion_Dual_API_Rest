/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.demo.repositories;

import com.example.demo.modelos.Actividades;
import com.example.demo.modelos.Alumno;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author AlejandroMarínBermúd
 * @author guiro
 */
public interface ActividadesRepository extends JpaRepository<Actividades, Long>{
    

}
