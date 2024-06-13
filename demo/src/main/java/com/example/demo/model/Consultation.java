package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Consultation")
public class Consultation {
    @Id
    private String id;
    @DBRef
    private Patient patient;
    private String mode;
    private Date dateOfVisit;
    private String currentComplaints;
    private String diagnosis;
    private List<Medication> treatment;
    private String investigations;
    private String dietAdvice;
    private String exerciseAdvice;
    private String specialAdvice;
    private String reviewDate;
    private Date createdAt;
    private Date updatedAt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(Date date) {
		this.dateOfVisit = date;
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
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
    
    // Getters and Setters
}



