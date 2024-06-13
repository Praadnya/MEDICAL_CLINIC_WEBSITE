package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "MedicalInfo")
public class MedicalInfo {
    @Id
    private String id;
    @DBRef
    private Patient patient;
    private List<String> allergies;
    private List<CMed> currentMedication;
    private PastHistory pastHistory;
    private PastHistory familyHistory;
    private OBH obh;
    private Habits habits;
    private Objective objective;
    private List<Reports> reports;
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
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
	public List<CMed> getCurrentMedication() {
		return currentMedication;
	}
	public void setCurrentMedication(List<CMed> currentMedication) {
		this.currentMedication = currentMedication;
	}
	public PastHistory getPastHistory() {
		return pastHistory;
	}
	public void setPastHistory(PastHistory pastHistory) {
		this.pastHistory = pastHistory;
	}
	public PastHistory getFamilyHistory() {
		return familyHistory;
	}
	public void setFamilyHistory(PastHistory familyHistory) {
		this.familyHistory = familyHistory;
	}
	public OBH getObh() {
		return obh;
	}
	public void setObh(OBH obh) {
		this.obh = obh;
	}
	public Objective getObjective() {
		return objective;
	}
	public void setObjective(Objective objective) {
		this.objective = objective;
	}
	public Habits getHabits() {
		return habits;
	}
	public void setHabits(Habits habits) {
		this.habits = habits;
	}
	public List<Reports> getReports() {
		return reports;
	}
	public void setReports(List<Reports> reports) {
		this.reports = reports;
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
}


