package testDemo;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import library.BaseClass;

public class Demo extends BaseClass {
	
	public static WebDriver driver;
	
	@Test
	public void launch() {
		driver=initializeDriver("Chrome");
		driver.get("http://www.google.co.in");
	}
	
	

}
