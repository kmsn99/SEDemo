package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {


	//	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
	//	wait1.until(ExpectedConditions.elementToBeClickable(By.id("idp-discovery-submit")));
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;

	}

	public void elementisclickable(By findBy) {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait1.until(ExpectedConditions.elementToBeClickable(findBy));

	}
	
//	WebDriverWait waita = new WebDriverWait(driver, Duration.ofSeconds(60));
//	waita.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//			"/html/body/div/div/div[1]/div[2]/div[2]/div[1]/main/div[1]/div")));
	
	public void iselementvisible(By findBy) {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait2.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	

	
	public void iselementinvisible(By findBy) {
		WebDriverWait waitb = new WebDriverWait(driver, Duration.ofSeconds(60));
		waitb.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		
	}
	

}
