package com.adactin.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		DOMConfigurator.configure("log4j.xml");
	}
	
	@BeforeTest
	public void BaseClass() {
		
		prop = new Properties();
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void launchApp( ) {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromiumdriver().driverVersion("136.0.7103.114").setup();
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("gecko")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); 
		}
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
}	

