package com.fecbo.companydeviceregister.controller.util;

import com.fecbo.companydeviceregister.controller.model.response.DeviceResponse;
import com.fecbo.companydeviceregister.controller.model.response.WorkerResponse;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class PdfGenerator {

    public static void workerReport(HttpServletResponse response, WorkerResponse workerResponse) throws IOException {
        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdfDocument;
        pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        try {
            document.add(new Paragraph("Worker report").setBold().setPaddingLeft(200f));
            document.add(new Paragraph("Name: " + workerResponse.getName() + "\n" +
                    "Id: " + workerResponse.getWorkerId() + "\n" +
                    "GroupId: " + workerResponse.getGroupId() + "\n" +
                    "Details: " + workerResponse.getDetails()));
            Table table = new Table(new float[]{20f, 20f, 25F, 15F});
            table.setWidthPercent(100)
                    .setPadding(0)
                    .setFontSize(9);

            Cell cell1 = new Cell(1,4);
            cell1.setTextAlignment(TextAlignment.CENTER);
            cell1.add("Devices").setBold();
            table.addCell(cell1);

            table.addCell(new Cell().add("Id").setBold());
            table.addCell(new Cell().add("Name").setBold());
            table.addCell(new Cell().add("Description").setBold());
            table.addCell(new Cell().add("Time of registration").setBold());

            for(DeviceResponse dev : workerResponse.getDevices()) {
                table.addCell(new Cell().add(String.valueOf(dev.getDeviceId())));
                table.addCell(new Cell().add(dev.getName()));
                table.addCell(new Cell().add(dev.getDescription()));
                table.addCell(new Cell().add(dev.getTimeOfRegistration()
                        .format(DateTimeFormatter.ISO_DATE)));
            }

            document.add(table);

            document.close();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
