package seautomate.setngframework.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	//Pagefactory
	@FindBy(id="Username")
	WebElement username;
	//Page factory for By elements
	By pro = By.id("Login_Button");

	@FindBy(id="Login_Button")
	WebElement submit;

	By pro1 = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/main/div[1]/div");

	@FindBy(id="Password")
	WebElement pwd;

	@FindBy(id="okta-signin-submit")
	WebElement submitFinal;

	
	

	//action  class
	public void loginapp(String un,String p1) {


		System.out.println("Login page class");
		elementisclickable(pro);
		username.sendKeys(un);
		pwd.sendKeys(p1);
		submit.click();
//		iselementvisible(pro1);
//		iselementinvisible(pro1);
//		pwd.sendKeys(p1);
//		submitFinal.click();
	}




}
