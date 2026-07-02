package com.hospital.urgencias.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.hospital.urgencias.model.Bed;

public interface BedRepository extends ReactiveMongoRepository<Bed, String>{

}
