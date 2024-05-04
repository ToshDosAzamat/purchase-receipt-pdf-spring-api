package com.example.purchasereceiptpdfspringapi.service;

import com.example.purchasereceiptpdfspringapi.model.Product;
import com.example.purchasereceiptpdfspringapi.model.Receipt;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Date;

@Service
public class ReceiptService {

    public byte[] generatePdf(Receipt receipt) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Date date = new Date();
        String dateString = date.toString();

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(new Paragraph("-----------------------------------------------------------"));
            document.add(new Paragraph("                PURCHASE RECEIPT                 "));
            document.add(new Paragraph("-----------------------------------------------------------"));
            document.add(new Paragraph("MARKET NAME: " + receipt.getMarket()));
            document.add(new Paragraph("CLIENT NAME: " + receipt.getClient()));
            document.add(new Paragraph("PURCHASE DATE: " + dateString));
            document.add(new Paragraph("-----------------------------------------------------------"));
            document.add(new Paragraph("PRODUCT LIST:"));
            double total = 0;
            for (Product product : receipt.getProducts()) {
                document.add(new Paragraph("- " + product.getName() + ": $" + product.getPrice()));
                total += product.getPrice();
            }
            document.add(new Paragraph("-----------------------------------------------------------"));
            document.add(new Paragraph("TOTAL PRICE: " + "$ " + total));
            document.add(new Paragraph("-----------------------------------------------------------"));
            document.add(new Paragraph("STATUS: " + receipt.getStatus()));
            document.add(new Paragraph("-----------------------------------------------------------"));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }
}
