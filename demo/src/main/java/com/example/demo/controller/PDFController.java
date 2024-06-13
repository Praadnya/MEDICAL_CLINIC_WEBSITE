package com.example.demo.controller;

import com.example.demo.model.Consultation;
import com.example.demo.model.PrescriptionData;
import com.example.demo.service.ConsultationService;
import com.example.demo.service.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;

import java.io.ByteArrayInputStream;

@Controller
public class PDFController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private PdfGenerator pdfGenerator;

    @GetMapping("/prescription/pdf")
    public ResponseEntity<byte[]> generatePDF(@RequestParam String consultationId) {
        // Fetch the consultation details by consultationId
        Consultation consultation = consultationService.getConsultationById(consultationId);

        // Convert Consultation to PrescriptionData
        PrescriptionData prescriptionData = consultationService.convertToPrescriptionData(consultation);

        // Generate PDF
        ByteArrayInputStream bis = pdfGenerator.generatePDF(prescriptionData);

        // Set HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=prescription.pdf");

        // Return PDF as byte array
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(bis.readAllBytes());
    }
}

