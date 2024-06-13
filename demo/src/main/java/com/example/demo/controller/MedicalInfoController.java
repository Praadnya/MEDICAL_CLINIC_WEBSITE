package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Child;
import com.example.demo.model.Habits;
import com.example.demo.model.MedicalInfo;
import com.example.demo.model.OBH;
import com.example.demo.model.Objective;
import com.example.demo.model.PastHistory;
import com.example.demo.model.Patient;
import com.example.demo.model.Reports;
import com.example.demo.repository.MedicalInfoRepository;
import com.example.demo.service.PatientService;

@Controller
public class MedicalInfoController {
	@Autowired
    private MedicalInfoRepository medicalInfoRepository;
	@Autowired
    private PatientService patientService;

    
	@GetMapping("/add-medical-info/{Id}")
    public String showMedicalInfoForm(@PathVariable String Id, Model model) {
    	Patient patient = patientService.getPatientById(Id);
        model.addAttribute("patient", patient);  // Add saved patient to model
        model.addAttribute("medicalInfo", new MedicalInfo());
        return "medical-info";
    }

    @PostMapping("/save-medical-info")
    public String saveMedicalInfo(@RequestParam("PatientId") String patientId, @ModelAttribute MedicalInfo medicalInfo) {
    	Patient patient = patientService.getPatientById(patientId);
        // Set the patient reference in the medicalInfo object
        medicalInfo.setPatient(patient);        
        // Create a new PastHistory object based on the selected checkboxes and input value
        PastHistory pastHistory = new PastHistory();
        pastHistory.setDM(medicalInfo.getPastHistory().isDM());
        pastHistory.setHTN(medicalInfo.getPastHistory().isHTN());
        pastHistory.setTHY(medicalInfo.getPastHistory().isTHY());
        pastHistory.setDL(medicalInfo.getPastHistory().isDL());
        pastHistory.setIHD(medicalInfo.getPastHistory().isIHD());
        pastHistory.setCA(medicalInfo.getPastHistory().isCA());
        pastHistory.setBA(medicalInfo.getPastHistory().isBA());
        pastHistory.setTB(medicalInfo.getPastHistory().isTB());
        pastHistory.setOther(medicalInfo.getPastHistory().getOther());

        // Set the updated PastHistory object in the medicalInfo
        medicalInfo.setPastHistory(pastHistory);
        
     // Create a new PastHistory object based on the selected checkboxes and input value
        PastHistory familyHistory = new PastHistory();
        familyHistory.setDM(medicalInfo.getPastHistory().isDM());
        familyHistory.setHTN(medicalInfo.getPastHistory().isHTN());
        familyHistory.setTHY(medicalInfo.getPastHistory().isTHY());
        familyHistory.setDL(medicalInfo.getPastHistory().isDL());
        familyHistory.setIHD(medicalInfo.getPastHistory().isIHD());
        familyHistory.setCA(medicalInfo.getPastHistory().isCA());
        familyHistory.setBA(medicalInfo.getPastHistory().isBA());
        familyHistory.setTB(medicalInfo.getPastHistory().isTB());
        familyHistory.setOther(medicalInfo.getPastHistory().getOther());

        // Set the updated PastHistory object in the medicalInfo
        medicalInfo.setPastHistory(familyHistory);

        // Check if the patient is female
        if ("Female".equals(patient.getGender())) {
            // Create a new OBH object based on the input values
            OBH obh = new OBH();
            
            obh.setMA(medicalInfo.getObh().getMA());
            obh.setMP(medicalInfo.getObh().getMP());
            obh.setMCU(medicalInfo.getObh().getMCU());
            obh.setMCB(medicalInfo.getObh().getMCB());
            obh.setLMP(medicalInfo.getObh().getLMP());
            obh.setP(medicalInfo.getObh().getP());
            obh.setG(medicalInfo.getObh().getG());
            obh.setA(medicalInfo.getObh().getA());
            obh.setL(medicalInfo.getObh().getL());

            // Initialize children list if null
            List<Child> children = medicalInfo.getObh().getChildren();
            if (children == null) {
                children = new ArrayList<>();
            }

            // Create a new list to store Child objects
            List<Child> newChildren = new ArrayList<>();

            // Iterate over the list of children provided in the form
            for (Child child : children) {
                // Create a new Child object based on the input values
                Child newChild = new Child();
                newChild.setGender(child.getGender());
                newChild.setAge(child.getAge());
                newChild.setType(child.getType());
                newChild.setComplications(child.getComplications());

                // Add the new Child object to the list
                newChildren.add(newChild);
            }

            // Set the list of Child objects in the OBH object
            obh.setChildren(newChildren);

            // Set the updated OBH object in the medicalInfo
            medicalInfo.setObh(obh);
        } else {
            // If the patient is not female, set the OBH object to null
            medicalInfo.setObh(null);
        }
        
     // Set the filled History details if the History object is not null
        if (medicalInfo.getHabits() != null) {
            Habits habits = new Habits();
            habits.setAlcohol(medicalInfo.getHabits().getAlcohol());
            habits.setAlcoholText(medicalInfo.getHabits().getAlcoholText());
            habits.setSmoking(medicalInfo.getHabits().getSmoking());
            habits.setSmokingText(medicalInfo.getHabits().getSmokingText());
            habits.setSleep(medicalInfo.getHabits().getSleep());
            habits.setSleepText(medicalInfo.getHabits().getSleepText());
            habits.setBowel(medicalInfo.getHabits().getBowel());
            habits.setBowelText(medicalInfo.getHabits().getBowelText());
            medicalInfo.setHabits(habits);
        }

     // Set the filled Objective details if the Objective object is not null
        if (medicalInfo.getObjective() != null) {
            Objective objective = new Objective();
            objective.setBP(medicalInfo.getObjective().getBP());
            objective.setSPO2(medicalInfo.getObjective().getSPO2());
            objective.setPR(medicalInfo.getObjective().getPR());
            objective.setTEMP(medicalInfo.getObjective().getTEMP());
            objective.setRBS(medicalInfo.getObjective().getRBS());
            objective.setHT(medicalInfo.getObjective().getHT());
            objective.setWT(medicalInfo.getObjective().getWT());
            objective.setBMI(medicalInfo.getObjective().getBMI());
            objective.setRS(medicalInfo.getObjective().getRS());
            objective.setPA(medicalInfo.getObjective().getPA());
            objective.setCVS(medicalInfo.getObjective().getCVS());
            objective.setENT(medicalInfo.getObjective().getENT());
            objective.setOTH(medicalInfo.getObjective().getOTH());
            medicalInfo.setObjective(objective);
        }

        
     // Handle the reports section if it's not null
        if (medicalInfo.getReports() != null) {
            List<Reports> reports = new ArrayList<>();
            for (Reports report : medicalInfo.getReports()) {
                if (report != null) {
                    Reports newReport = new Reports();
                    newReport.setDate(report.getDate());
                    newReport.setWt(report.getWt());
                    newReport.setBMI(report.getBMI());
                    newReport.setFBS(report.getFBS());
                    newReport.setPPBS(report.getPPBS());
                    newReport.setA1c(report.getA1c());
                    newReport.setSCr(report.getSCr());
                    newReport.setUAC(report.getUAC());
                    newReport.setTC(report.getTC());
                    newReport.setTGL(report.getTGL());
                    newReport.setLDL(report.getLDL());
                    newReport.setHDL(report.getHDL());
                    newReport.setTSH(report.getTSH());
                    newReport.setHb(report.getHb());
                    newReport.setTLC(report.getTLC());
                    newReport.setEGFR(report.getEGFR());
                    newReport.setD3(report.getD3());
                    newReport.setB12(report.getB12());
                    newReport.setAT(report.getAT());
                    newReport.setLT4(report.getLT4());
                    newReport.setMET(report.getMET());
                    newReport.setGP(report.getGP());
                    newReport.setDPP4(report.getDPP4());
                    newReport.setVOG(report.getVOG());
                    newReport.setSGLT(report.getSGLT());
                    newReport.setINS(report.getINS());
                    newReport.setRemarks(report.getRemarks());
                    reports.add(newReport);
                }
            }
            medicalInfo.setReports(reports);
        }


        // Save the medicalInfo object
        medicalInfoRepository.save(medicalInfo);

        return "redirect:/patient/" + patient.getId();  // Redirect back to the personal details form for a new entry
    }
        
}
