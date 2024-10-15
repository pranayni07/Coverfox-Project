package coverfoxBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class BaseClass {
	protected static WebDriver driver;
	
	public void openBrowser()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		
		driver.get("https://www.coverfox.com/");
		Reporter.log("launching Browser",true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		Reporter.log("Waiting...",false);

	}
	
	public void browserClose() throws InterruptedException //close browser is also known as Tear-Down method
	{
		Reporter.log("closing Browser");
		Thread.sleep(1000);
		driver.close();
	}

}
