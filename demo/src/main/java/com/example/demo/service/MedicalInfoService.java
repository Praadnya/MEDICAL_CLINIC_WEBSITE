package com.example.demo.service;

import com.example.demo.model.MedicalInfo;
import com.example.demo.repository.MedicalInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalInfoService {

    @Autowired
    private MedicalInfoRepository medicalInfoRepository;

    public void saveMedicalInfo(MedicalInfo medicalInfo) {
        medicalInfoRepository.save(medicalInfo);
    }

 // Service method to fetch medical information by patient ID
    public MedicalInfo getMedicalInfoByPatientId(String patientId) {
        MedicalInfo medicalInfo = medicalInfoRepository.findByPatientId(patientId);
//        if (medicalInfo == null) {
//            throw new RuntimeException("Medical information not found for patient ID: " + patientId);
//        }
        return medicalInfo;
    }

    // Service method to update medical information
    public void updateMedicalInfo(MedicalInfo medicalInfo) {
        medicalInfoRepository.save(medicalInfo);
    }
    
}

