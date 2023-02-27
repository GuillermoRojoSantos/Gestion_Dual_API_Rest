/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author AlejandroMarínBermúd
 * @author guiro
 */

@Data
@Entity
@Table(name="alumno")
public class Alumno implements Serializable{
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column (name = "empresa")
    private String empresa;
    
     @Column (name = "profesor")
    private String profesor;
     
     @Column (name = "practicas")
    private Float practicas;
     
      @OneToMany( mappedBy ="alumno", cascade = CascadeType.ALL)
      @JsonIgnoreProperties(value = {"alumno"})
      
      private List<Actividades> actividades;
    
}
