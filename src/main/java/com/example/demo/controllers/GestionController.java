/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.demo.controllers;

import com.example.demo.modelos.Alumno;
import com.example.demo.modelos.Actividades;
import com.example.demo.repositories.ActividadesRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import com.example.demo.repositories.AlumnoRepository;

/**
 *
 * @author AlejandroMarínBermúd
 * @author guiro
 */
@RestController
@RequestMapping("/alumno")
public class GestionController {
    
    @Autowired
    AlumnoRepository repo;
    
    @Autowired
    ActividadesRepository Arep;
    
    @GetMapping()
    public List<Alumno> list() {
        return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> get(@PathVariable Long id) {
        if(repo.existsById(id)){
            return new ResponseEntity<Alumno>(repo.findById(id).get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping("/empresa/{empresa}")
    public ResponseEntity<Alumno> getAlumnoByEmpresa(@PathVariable String empresa) {
        
     var lib = repo.findByEmpresa(empresa);
     
     if(lib.isEmpty()){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     else{
         return new ResponseEntity<Alumno>(lib.get(), HttpStatus.OK);
     }
     
    }
    
     @GetMapping("/profesor/{profesor}")
    public ResponseEntity<Alumno> getAlumnoByProfesor(@PathVariable String profesor) {
        
     var lib = repo.findByProfesor(profesor);
     
     if(lib.isEmpty()){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     else{
         return new ResponseEntity<Alumno>(lib.get(), HttpStatus.OK);
     }
     
    }
    
     @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Alumno> getAlumnoByNombre(@PathVariable String nombre) {
        
     var lib = repo.findByNombre(nombre);
     
     if(lib.isEmpty()){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     else{
         return new ResponseEntity<Alumno>(lib.get(), HttpStatus.OK);
     }
     
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Alumno> postAlumno(@RequestBody Alumno input) {
        repo.save(input);
        System.out.println(input.getNombre());
        return new ResponseEntity<>(input, HttpStatus.CREATED);
    }
    
    //ACTIVIDADES
    
     @GetMapping("/lista/actividades")
    public List<Actividades> listActividades() {
        return Arep.findAll();
    }
  
     @GetMapping("/{idalumno}/actividades")
    public ResponseEntity<Alumno> getActividades(@PathVariable Long idalumno) {
         
        var lib = repo.findById(idalumno);
         System.out.println(idalumno);
     
     if(lib.isEmpty()){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     else{
         return new ResponseEntity<Alumno>(lib.get(), HttpStatus.OK);
     }
    }
    
    @GetMapping("/actividades/{id}")
    public ResponseEntity<Actividades> getActividad(@PathVariable Long id) {
        if(Arep.existsById(id)){
            return new ResponseEntity<Actividades>(Arep.findById(id).get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
     @DeleteMapping("/actividades/borrar/{id}")
     public ResponseEntity<Actividades> delete(@PathVariable Long id){
         
         if(Arep.existsById(id)){
             var borrada = Arep.getById(id);
             Arep.deleteById(id);
             return new ResponseEntity<Actividades>(borrada, HttpStatus.OK);
         }
         else{
             return new ResponseEntity(HttpStatus.NOT_FOUND);
         }
     }

     @PostMapping("/{id}/actividades/crear")
    public ResponseEntity<Actividades> postActividades(@PathVariable Long id, @RequestBody Actividades input) {
        
        System.out.println(input);
        
        Alumno alumno = repo.getById(id);
        
        if(alumno != null){
       
            input.setAlumno(alumno);
            
            Arep.save(input);
          
        }
        return new ResponseEntity<>(input, HttpStatus.CREATED);
    }
    
    @PostMapping("{idalumno}/actividades/editar/{id}")
    public Actividades update(@PathVariable Long id, @PathVariable Long idalumno ,@RequestBody Actividades input){
         
        System.out.println(input);
        Alumno alumno = repo.getById(idalumno);
        
         
        if(Arep.existsById(id)){
       if(alumno != null){
         Actividades a = Arep.findById(id).get();
         
         input.setAlumno(alumno);
         input.setId(id);
         
         Arep.save(input);
        }
        }
        return input;
    }
    
    
}