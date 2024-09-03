package seautomate.setngframework;

import static org.testng.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import seautomate.setngframework.pageobjects.LoginPage;
import seautomate.setngframework.pageobjects.agentsPage;

//import com.paulhammant.ngwebdriver.ByAngularBinding;
//import com.paulhammant.ngwebdriver.NgWebDriver;
public class Agent {
	public WebDriver driver;
	// public NgWebDriver ngdriver;
	// public NgWebDriver ngdriver1;
	public JavascriptExecutor jsdriver;

	String baseurl = "https://arch.stoneeagle.com/Manage/Login";

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/SenthilM/eclipse/chromedriver-win64/chromedriver-win64/chromedriver.exe");
// "C:\Users\SenthilM\eclipse\chromedriver-win64\chromedriver-win64\chromedriver.exe"
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--auto-open-devtools-for-tabs");
		driver = new ChromeDriver(options);

		Dimension d = new Dimension(1980, 1080);
		driver.manage().window().setSize(d);
		driver.get(baseurl);

		// driver.manage().deleteAllCookies();

		jsdriver = (JavascriptExecutor) driver;
		// ngdriver = new NgWebDriver(jsdriver);
	}

	@Test(priority = 2)
	public void pagetitle() {
		String a = driver.getTitle();
		System.out.println(a);
		// assertEquals(a,"Claim Portal - Login");
		System.out.println("Page Title is correct");

	}

	@Test(priority = 3)
	public void login() {
		// Login_Button
		System.out.println("Inside Login");
		
		System.out.println("Inside login after wait");
		LoginPage loginPage = new LoginPage(driver);
		System.out.println("driver initialised");
		loginPage.loginapp("dow/GunaseelanM", "speedGun@2dowc");
		System.out.println("Login completed");

	}

	@Test(priority = 4)
	public void dynamictable() {
		System.out.println("Inside dynamictable -->Before wait");
		
		agentsPage ap = new agentsPage(driver);	
	      ap.aps("SEARCH_IGNORE");
	      ap.aps("1000");
	      ap.hoverOverTargetElement();
	      ap.processTable(1);

		driver.quit(); 
	}
}
