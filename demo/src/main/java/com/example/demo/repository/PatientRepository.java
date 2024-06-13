package com.example.demo.repository;

import com.example.demo.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findAllByOrderByNameAsc();
    List<Patient> findByNameContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrderByNameAsc(String name, String phone);
}
