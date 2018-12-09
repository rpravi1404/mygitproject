package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import library.KeywordLibrary;

public class HomePage extends KeywordLibrary {
	
	public WebDriver driver;
	public By link_Login=By.xpath("//a[@class='login-link']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement clickOnLogin() {
		return findElement(driver, link_Login);
	}

}
