package coverfoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
	public static String readDataFromExcel(String filepath,String SheetNo,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile=new FileInputStream(filepath);
		String Value = WorkbookFactory.create(myFile).getSheet(SheetNo).getRow(row).getCell(cell).getStringCellValue();
		System.out.println(Value);//To retrive Value on Console
		return Value;
	}

	
	public static void takeScreenShot(WebDriver driver,String FileName) throws IOException
	{
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    Reporter.log("taking screenshot",true);
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    File dest=new File(System.getProperty("user.dir")+"\\screenShot\\"+FileName+timeStamp+".png");
	    FileHandler.copy(src, dest);
	    Reporter.log("saving file at location"+dest,true);

	}
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		String filepath = System.getProperty("user.dir")+"//testData.properties";
		FileInputStream myfile=new FileInputStream(filepath);
		
		Properties prop=new Properties();
		prop.load(myfile);
		String value = prop.getProperty(key);
		return value;
	}

}
