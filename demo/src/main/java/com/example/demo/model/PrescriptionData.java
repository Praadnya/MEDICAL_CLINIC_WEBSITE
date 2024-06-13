package com.example.demo.model;

import java.util.List;

public class PrescriptionData {
    private String patientName;
    private String dob;
    private String gender;
    private String dateOfVisit;
    private String modeOfConsultation;
    private String currentComplaints;
    private String diagnosis;
    private List<Medication> treatment;
    private String investigations;
    private String dietAdvice;
    private String exerciseAdvice;
    private String specialAdvice;
    private String reviewDate;
    private List<String> allergies;
    
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public String getModeOfConsultation() {
		return modeOfConsultation;
	}
	public void setModeOfConsultation(String modeOfConsultation) {
		this.modeOfConsultation = modeOfConsultation;
	}
	public String getCurrentComplaints() {
		return currentComplaints;
	}
	public void setCurrentComplaints(String currentComplaints) {
		this.currentComplaints = currentComplaints;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public List<Medication> getTreatment() {
		return treatment;
	}
	public void setTreatment(List<Medication> treatment) {
		this.treatment = treatment;
	}
	public String getInvestigations() {
		return investigations;
	}
	public void setInvestigations(String investigations) {
		this.investigations = investigations;
	}
	public String getDietAdvice() {
		return dietAdvice;
	}
	public void setDietAdvice(String dietAdvice) {
		this.dietAdvice = dietAdvice;
	}
	public String getExerciseAdvice() {
		return exerciseAdvice;
	}
	public void setExerciseAdvice(String exerciseAdvice) {
		this.exerciseAdvice = exerciseAdvice;
	}
	public String getSpecialAdvice() {
		return specialAdvice;
	}
	public void setSpecialAdvice(String specialAdvice) {
		this.specialAdvice = specialAdvice;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
    
    

