package com.rubeus.qa.report;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.io.image.ImageDataFactory;


/**
 * QAReportGenerator
 *
 * Generates automatic QA reports in PDF and XLSX formats.
 * Includes screenshots, type, classification, and priority.
 */
public class QAReportGenerator 
{
	private List<QAItem> items;
	
	public QAReportGenerator() 
	{
		items = new ArrayList<>();
	}
	
	public static class QAItem 
	{
		public String page;
		public String item;
		public String type;
		public String classification;
		public String priority;
		public String description;
		public String screenshotPath;
		
		public QAItem(String page, String item, String type, String classification, String priority,
				String description, String screenshotPath)
		{
			this.page = page;
			this.item = item;
			this.type = type;
			this.classification = classification;
			this.priority = priority;
			this.description = description;
			this.screenshotPath = screenshotPath;
		}
	}
	
	public void addItem(QAItem item) 
	{
		items.add(item);
	}
	
	// ================= PDF =================
	public void generatePDF(String outputPath) throws Exception
	{
		Path folder = Paths.get(outputPath).getParent();
		if (!Files.exists(folder)) Files.createDirectories(folder);
		
		PdfWriter writer = new PdfWriter(outputPath);
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);
		
		for (QAItem item : items) 
		{
			document.add(new com.itextpdf.layout.element.Paragraph("Página: " + item.page)); 
			document.add(new com.itextpdf.layout.element.Paragraph("Item: " + item.item)); 
			document.add(new com.itextpdf.layout.element.Paragraph("Tipo: " + item.type +
					" | Classificação: " + item.classification + " | Prioridade: " + item.priority)); 
			document.add(new com.itextpdf.layout.element.Paragraph("Descrição: " + item.description)); 
			
			if (item.screenshotPath != null && Files.exists(Paths.get(item.screenshotPath)))
			{
				Image img = new Image(ImageDataFactory.create(item.screenshotPath));
				img.setAutoScale(true);
				document.add(img);
			}
			
			document.add(new com.itextpdf.layout.element.Paragraph(
					"---------------------------------------------------------------------------------------"));
		}
		document.close();
		System.out.println("PDF gerado: " + outputPath);
	}
	
	// ================= EXCEL =================
	public void generateExcel(String outputPath) throws Exception
	{
		Path folder = Paths.get(outputPath).getParent();
		if (!Files.exists(folder)) Files.createDirectories(folder);
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("QA Report");
		
		// Header
		String[] columns = {"Page", "Item", "Type", "Classification", "Priority", "Description", "Screenshot"};
		Row header = sheet.createRow(0);
		
		for (int i = 0; i < columns.length; i++) 
			header.createCell(i).setCellValue(columns[i]);
		
		// Data 
		int rowNum = 1;
		
		for (QAItem item : items) 
		{
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(item.page);
			row.createCell(1).setCellValue(item.item);
			row.createCell(2).setCellValue(item.type);
			row.createCell(3).setCellValue(item.classification);
			row.createCell(4).setCellValue(item.priority);
			row.createCell(5).setCellValue(item.description);
			row.createCell(6).setCellValue(item.screenshotPath);
		}
		
		for (int i = 0; i < columns.length; i++) 
			sheet.autoSizeColumn(i);
		
		FileOutputStream fileOut = new FileOutputStream(outputPath);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
		
		System.out.println("Excel gerado: " + outputPath);
	}
}
