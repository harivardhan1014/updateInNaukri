package com.naukri;
	 
import java.io.*;

//import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
 
public class SampleExcel{
 
@Test
public void dataToExcel(){
 
 try {
    
  FileInputStream file = new FileInputStream(new File("D:\\hari vardhan\\work space\\NaukriUpdate\\test data\\data1.xlsx")); 
  XSSFWorkbook workbook = new XSSFWorkbook(file);
   XSSFSheet sheet = workbook.getSheetAt(0);
 
   int i=sheet.getLastRowNum();
   System.out.println(i);
   XSSFRow row=sheet.getRow(i);
   row.createCell(2).setCellValue("hi");
		   
 // XSSFCell searchText3 = sheet.getRow(0).getCell(0);
  //searchText3.setCellValue("Test Search Keyword");
 
  file.close();
 
  FileOutputStream outFile =new FileOutputStream(new File("D:\\hari vardhan\\work space\\NaukriUpdate\\test data\\data1.xlsx"));
  workbook.write(outFile);
  outFile.close();
 
 } catch (FileNotFoundException fnfe) {
  fnfe.printStackTrace();
 } catch (IOException ioe) {
  ioe.printStackTrace();
 }
 }
}