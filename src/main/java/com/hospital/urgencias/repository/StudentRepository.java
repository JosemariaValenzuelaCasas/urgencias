package com.hospital.urgencias.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.hospital.urgencias.model.Student;

public interface StudentRepository extends ReactiveMongoRepository<Student, String> {
    
}
