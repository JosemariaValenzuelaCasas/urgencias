package com.hospital.urgencias.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.hospital.urgencias.model.Patient;

public interface PatientRepository extends ReactiveMongoRepository<Patient, String>{
    
}
