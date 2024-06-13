package com.example.demo.service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAllByOrderByNameAsc();
    }

    public List<Patient> searchPatients(String keyword) {
        return patientRepository.findByNameContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrderByNameAsc(keyword, keyword);
    }

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient getPatientById(String id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.orElse(null); // Return null if patient is not found
    }

	public void updatePatient(String id, Patient updatedPatient) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            existingPatient.setName(updatedPatient.getName());
            existingPatient.setDob(updatedPatient.getDob());
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setPhone(updatedPatient.getPhone());
            patientRepository.save(existingPatient);
        } else {
            // Handle patient not found error
            throw new RuntimeException("Patient not found with ID: " + id);
        }
    }

}
