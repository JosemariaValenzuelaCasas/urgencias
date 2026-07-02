package com.hospital.urgencias.services.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.hospital.urgencias.model.Student;
import com.hospital.urgencias.repository.StudentRepository;
import com.hospital.urgencias.services.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepository repository;

    @Override
    public Flux<Student> findAll() {
        return repository.findAll();
    }

        @Override
        public Mono<Student> findById(String id) {
            return repository.findById(id);
        }

    @Override
    public Mono<Student> save(Student student) {
        student.setRegisterDate(LocalDateTime.now());
        return repository.save(student);
    }

    @Override
    public Mono<Student> update(Student student, String id) {
        return repository.findById(id)
                .flatMap(existing->{
                    existing.setDni(student.getDni());
                    existing.setName(student.getName());
                    existing.setLastName(student.getLastName());
                    existing.setPromotion(student.getPromotion());
                    existing.setRegisterDate(LocalDateTime.now());
                    return repository.save(existing);
                });
    }

    @Override
    public Mono<Void> deleteLogical(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("no se pudo encontrar al paciente")))
                .flatMap(existing->{
                    existing.setStatus("I");
                    return repository.save(existing);
                }).then();
    }

    @Override
    public Mono<Void> deletePhysical(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("no se pudo encontrar al paciente")))
                .flatMap(existing->{
                    return repository.delete(existing);
                }).then();
    }

    @Override
    public Mono<Void> restoreLogical(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("no se pudo encontrar al paciente")))
                .flatMap(existing->{
                    existing.setStatus("A");
                    return repository.save(existing);
                }).then();
    }
}
