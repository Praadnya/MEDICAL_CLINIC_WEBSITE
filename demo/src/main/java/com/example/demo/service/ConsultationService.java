package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Consultation;
import com.example.demo.model.MedicalInfo;
import com.example.demo.model.PrescriptionData;
import com.example.demo.repository.ConsultationRepository;
import com.example.demo.repository.MedicalInfoRepository;

@Service
public class ConsultationService {
	@Autowired
	private ConsultationRepository consultationRepository;
	@Autowired
    private MedicalInfoRepository medicalInfoRepository;
	
	public void saveConsultation(Consultation consultation) {
        // Add any additional logic here, if needed
        consultationRepository.save(consultation);
    }

    public Consultation getConsultationById(String consultationId) {
        return consultationRepository.findById(consultationId).orElse(null);
    }
    
 // Add this method to fetch all consultations for a given patient ID
    public List<Consultation> getAllConsultationsByPatientId(String patientId) {
        return consultationRepository.findByPatientId(patientId);
    }

    public PrescriptionData convertToPrescriptionData(Consultation consultation) {
        if (consultation == null) {
            return null;
        }

        PrescriptionData prescriptionData = new PrescriptionData();
        prescriptionData.setPatientName(consultation.getPatient().getName());
        prescriptionData.setDob(consultation.getPatient().getDob());
        prescriptionData.setGender(consultation.getPatient().getGender());
        prescriptionData.setDateOfVisit(consultation.getDateOfVisit().toString());
        prescriptionData.setModeOfConsultation(consultation.getMode());
        prescriptionData.setCurrentComplaints(consultation.getCurrentComplaints());
        prescriptionData.setDiagnosis(consultation.getDiagnosis());
        prescriptionData.setTreatment(consultation.getTreatment());
        prescriptionData.setInvestigations(consultation.getInvestigations());
        prescriptionData.setDietAdvice(consultation.getDietAdvice());
        prescriptionData.setExerciseAdvice(consultation.getExerciseAdvice());
        prescriptionData.setSpecialAdvice(consultation.getSpecialAdvice());
        prescriptionData.setReviewDate(consultation.getReviewDate());
        prescriptionData.setAllergies(getAllergiesByPatientId(consultation.getPatient().getId()));

        return prescriptionData;
    }

    public List<String> getAllergiesByPatientId(String patientId) {
        MedicalInfo medicalInfo = medicalInfoRepository.findByPatientId(patientId);
        return medicalInfo != null ? medicalInfo.getAllergies() : List.of("NKA");
    }

}

