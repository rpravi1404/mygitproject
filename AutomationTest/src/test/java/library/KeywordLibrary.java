package library;

import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeywordLibrary {
	
	public static final String path="C:\\Users\\Tauqueer\\workspace\\AutomationTest\\src\\test\\resources\\globalData\\GlobalData.Properties";
	public static Properties properties;
	
	/***************************************************************
	#Function Name: getGlobalData
	#Author: Ravi
	#Description:
	#Input Parameters:
	#Date of Creation:
	***************************************************************/
	
	public static String getGlobalData(String strPropertyName) {
		properties= new Properties();
		try {
			FileInputStream master=new FileInputStream(path);
			properties.load(master);
			master.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return properties.getProperty(strPropertyName);
	}
	
	/***************************************************************
	#Function Name: WebElementClick
	#Author: Ravi
	#Description:
	#Input Parameters:
	#Date of Creation:
	***************************************************************/
	public static void WebElementClick(WebDriver driver,WebElement element) {
		try {
			element=(new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element)));
			element=(new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(element)));
			element.click();
		}
		catch(NoSuchElementException e) {
			System.err.format("No element found to perform click", e);
		}
	}
	
	/***************************************************************
	#Function Name: WebElementHover
	#Author: Ravi
	#Description:
	#Input Parameters:
	#Date of Creation:
	***************************************************************/
	public static void WebElementHover(WebDriver driver,WebElement element) {
		try {
			element=(new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element)));
			element=(new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(element)));
			Actions action=new Actions(driver);
			action.moveToElement(element).perform();
		}
		catch(NoSuchElementException e) {
			System.err.format("No element found to perform hover", e);
		}
	}
	
	/***************************************************************
	#Function Name: WebSetText
	#Author: Ravi
	#Description:
	#Input Parameters:
	#Date of Creation:
	***************************************************************/
	public static void WebSetText(WebDriver driver,WebElement element,String strVal) {
		try {
			element=(new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element)));
			element=(new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(element)));
			element.clear();
			TimeUnit.SECONDS.sleep(1);
			element.sendKeys(strVal);
			TimeUnit.SECONDS.sleep(1);
		}
		catch(InterruptedException ex) {
			System.err.format("maximum timeout", ex);
		}
		catch(NoSuchElementException e) {
			System.err.format("No element found to perform hover", e);
		}
	}
	
	/***************************************************************
	#Function Name: WebElementExist
	#Author: Ravi
	#Description:
	#Input Parameters:
	#Date of Creation:
	***************************************************************/
	public static boolean WebElementExist(WebDriver driver,WebElement element) {
		boolean bool=false;
		try {
			element=(new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element)));
			if(element.isDisplayed()) {
				bool=true;
			}
			else {
				bool=false;
			}
		}
		catch(NoSuchElementException e) {
			System.err.format("No element found to perform hover", e);
		}
		return bool;
	}
	
	/***************************************************************
	#Function Name: findElement
	#Author: Ravi
	#Description:
	#Input Parameters:
	#Date of Creation:
	***************************************************************/
	public static WebElement findElement(final WebDriver driver,final By locator) {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
					.withTimeout(20, TimeUnit.SECONDS)
					.withTimeout(10, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
		return wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
		}
		});
	}
	

}
