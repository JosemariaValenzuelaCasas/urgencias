package com.hospital.urgencias.services;

import com.hospital.urgencias.model.Patient;
import com.hospital.urgencias.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
    Flux<Student> findAll();
    Mono<Student> findById(String id);
    Mono<Student> save(Student student);
    Mono<Student> update(Student student, String id);
    Mono<Void> deleteLogical(String id);
    Mono<Void> restoreLogical(String id);
    Mono<Void> deletePhysical(String id);
}
