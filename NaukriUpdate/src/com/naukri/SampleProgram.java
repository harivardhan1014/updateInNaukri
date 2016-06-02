package com.naukri;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.naukri.util.UtilsFile;

public class SampleProgram {

	String excelFilePath="D:\\hari vardhan\\work space\\NaukriUpdate\\test data\\data1.xlsx";
	String URL="http://www.naukri.com";
	
	@Parameters({"browser"})
	
	@Test
	
	public void naukriResumeUpdate(String browser) throws IOException
	{
		UtilsFile uf=new UtilsFile();
		UtilsFile.openBrowser(browser);
		uf.openURL(URL);
		int lastRow=uf.getLastRow(excelFilePath);

		for(int j=0;j<=lastRow;j++)
		{
		    uf.getData(excelFilePath,j);
	    	uf.loginAndUpdate();
	    	uf.updateExcel(j);
		}
		
        uf.closeURL();
	
	}

	
}
