package com.example.demo.service;

import com.example.demo.model.PrescriptionData;
import com.example.demo.model.Medication;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Component
public class PdfGenerator {

    public ByteArrayInputStream generatePDF(PrescriptionData prescriptionData) {
        Document document = new Document(PageSize.A4, 36, 36, 120, 50); // Adjust the margins: left, right, top, bottom
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            String headerImagePath = "src/main/resources/images/header1.png"; // Replace with your header image path
            String footerImagePath = "src/main/resources/images/footer1.png"; // Replace with your footer image path

            PdfWriter writer = PdfWriter.getInstance(document, out);
            HeaderFooterPageEvent event = new HeaderFooterPageEvent(headerImagePath, footerImagePath);
            writer.setPageEvent(event);
            document.open();

            // Create a table with 4 columns
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100); // Set the table to be the full width of the page
            document.add(new Paragraph("             "));

            // Add table cells with data
            table.addCell(createCellWithBoldText("Date of Visit: ", prescriptionData.getDateOfVisit()));
            table.addCell(createCellWithBoldText("Patient Name: ", prescriptionData.getPatientName()));
            table.addCell(createCellWithBoldText("DOB: ", prescriptionData.getDob()));
            table.addCell(createCellWithBoldText("Gender: ", prescriptionData.getGender()));

            // Add the table to the document
            document.add(table);

            document.add(new Paragraph("             "));

            List<String> allergies = prescriptionData.getAllergies();
            String allergiesString = allergies != null && !allergies.isEmpty() ? String.join(", ", allergies) : "-";
            addNonNullParagraphWithBoldLabel(document, "Allergies: ", allergiesString);

            addNonNullParagraphWithBoldLabel(document, "Mode of Consultation: ", prescriptionData.getModeOfConsultation());
            addNonNullParagraphWithBoldLabel(document, "Current Complaints: ", prescriptionData.getCurrentComplaints());
            addNonNullParagraphWithBoldLabel(document, "Diagnosis: ", prescriptionData.getDiagnosis());

            List<Medication> treatment = prescriptionData.getTreatment();
            if (treatment != null && !treatment.isEmpty()) {
                document.add(new Paragraph("Treatment:", new Font(Font.HELVETICA, 12, Font.BOLD)));
                document.add(new Paragraph("             "));
                PdfPTable table1 = new PdfPTable(4);
                addTableHeader(table1);
                addRows(table1, treatment);
                document.add(table1);
                document.add(new Paragraph("             "));
            }

            addNonNullParagraphWithBoldLabel(document, "Investigations: ", prescriptionData.getInvestigations());
            addNonNullParagraphWithBoldLabel(document, "Diet Advice: ", prescriptionData.getDietAdvice());
            addNonNullParagraphWithBoldLabel(document, "Exercise Advice: ", prescriptionData.getExerciseAdvice());
            addNonNullParagraphWithBoldLabel(document, "Special Advice: ", prescriptionData.getSpecialAdvice());
            addNonNullParagraphWithBoldLabel(document, "Review Date: ", prescriptionData.getReviewDate());

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private PdfPCell createCellWithBoldText(String label, String value) {
        PdfPCell cell = new PdfPCell();
        Font boldFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL);
        cell.addElement(new Phrase(label, boldFont));
        cell.addElement(new Phrase(value != null && !value.isEmpty() ? value : "-", normalFont));
        return cell;
    }

    private void addNonNullParagraphWithBoldLabel(Document document, String label, String value) throws DocumentException {
        Font boldFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL);
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Phrase(label, boldFont));
        paragraph.add(new Phrase(value != null && !value.isEmpty() ? value : "-", normalFont));
        document.add(paragraph);
    }

    private void addTableHeader(PdfPTable table) {
        Font boldFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Stream.of("Medicine Name", "Frequency", "Number of Days", "Special Instructions")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setPhrase(new Phrase(columnTitle, boldFont));
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, List<Medication> treatment) {
        if (treatment != null) {
            for (int i = 1; i < treatment.size(); i++) {
                Medication medication = treatment.get(i);
                table.addCell(new Phrase(medication.getMedicineName()));
                table.addCell(new Phrase(medication.getFrequency()));
                table.addCell(new Phrase(String.valueOf(medication.getNumberOfDays())));
                table.addCell(new Phrase(medication.getSpecialInstructions()));
            }
        }
    }
}
