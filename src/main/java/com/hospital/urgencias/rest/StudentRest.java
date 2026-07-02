package com.hospital.urgencias.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.urgencias.model.Patient;
import com.hospital.urgencias.model.Student;
import com.hospital.urgencias.services.StudentService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/student")
public class StudentRest {
    
    private final StudentService service;

    @GetMapping()
    public Flux<Student> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping()
    public Mono<Student> create(@RequestBody Student student) {        
        return service.save(student);
    }


    @PutMapping("/{id}")
    public Mono<Student> update(@RequestBody Student student,@PathVariable String id) {        
        return service.update(student, id);
    }

    @PatchMapping("/{id}/delete")
    public Mono<Void> deleteLogical(@PathVariable String id){
        return service.deleteLogical(id);
    }

    @PatchMapping("/{id}/restore")
    public Mono<Void> restoreLogical(@PathVariable String id){
        return service.restoreLogical(id);
    }
    
    @DeleteMapping("/{id}")
    public Mono<Void> deletePhysical(@PathVariable String id){
        return service.deletePhysical(id);
    }

}
