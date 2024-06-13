package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Consultation;

public interface ConsultationRepository extends MongoRepository<Consultation, String> {
	List<Consultation> findByPatientId(String patientId);
}

