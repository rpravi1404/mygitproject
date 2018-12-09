package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass extends KeywordLibrary {
	
	public static WebDriver driver;
	
	public static WebDriver initializeDriver(String browserName) {
		String driverPath;
		if(browserName.equalsIgnoreCase("chrome")) {
			driverPath=getGlobalData("ChromeDriverPath");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
