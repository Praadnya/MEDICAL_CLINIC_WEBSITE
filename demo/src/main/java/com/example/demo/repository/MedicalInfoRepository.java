package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.MedicalInfo;

import org.springframework.stereotype.Repository;

@Repository
public interface MedicalInfoRepository extends MongoRepository<MedicalInfo, String> {


	MedicalInfo findByPatientId(String patientId);
}

