package seautomate.setngframework.pageobjects;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponents.AbstractComponents;

public class agentsPage extends AbstractComponents {

	WebDriver driver;

	public agentsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//Page Factory

	By id1 = By.id("ui-id-1");

	@FindBy(id="ui-id-1")
	WebElement menu;

	By id2 = By.id("UsersandGroups-Agents");

	@FindBy(id="UsersandGroups-Agents")
	WebElement submenu;

	By id3 = By.xpath(
			"/html/body/div[2]/div[3]/div/div/div[5]/div/table/tbody/tr/td[3]/div");

	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div[5]/div/table/tbody/tr/td[3]/div/span")
	WebElement showcount;


	By id4 = By.xpath("/html/body/div[2]/div[3]/div/div/div[2]");

	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[3]/div[2]/div/table/thead/tr[2]/th[26]/div/table/tbody/tr/td[2]/select")
	WebElement dropdownElement;



	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[5]/div/table/tbody/tr/td[2]/table/tbody/tr/td[8]/select")
	WebElement dropdownElement1;


	@FindBy(className = "ui-pg-div")
	WebElement pgDivButton;

	By id6 = By.id("ui-id-19");
	
	   @FindBy(id = "ui-id-19")
	    WebElement targetElement;
	
	   By id7 = By.id("ui-id-20");
	   
	   @FindBy(id = "ui-id-20")
	   WebElement  btn;
	   
	   @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[3]/div[2]/div/table/thead/tr[1]")
	    private WebElement tableHeadingElement;

	    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[3]/div[3]/div/table/tbody")
	    private WebElement tableBodyElement;

	    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[5]/div/table/tbody/tr/td[2]/table/tbody/tr/td[6]/span")
	    private WebElement nextButton;

	    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[2]")
	    private WebElement loader;


	//Action methods
	public void aps(String value) {
		elementisclickable(id1);
		menu.click();

		elementisclickable(id2);
		submenu.click();

		elementisclickable(id3);
		showcount.click();

		iselementinvisible(id4);


		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue(value);
		iselementinvisible(id4);

		Select dropdown1 = new Select(dropdownElement1);
		dropdown1.selectByValue(value);
		iselementinvisible(id4);

		pgDivButton.click();
		elementisclickable(id6);
		
		
	}

	public void hoverOverTargetElement() {
        Actions builder = new Actions(driver);
        builder.moveToElement(targetElement).perform();
    }

	public void aps1(String value) {
		elementisclickable(id7);
		btn.click();
		iselementinvisible(id4);
	}
	
	public void processTable(int iterations) {
        try {
            // Extract and write table heading
            String tableHeading = tableHeadingElement.getAttribute("innerHTML");
            File file = new File("agent.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.append("<table border=\"1\">").append(tableHeading);

            // Loop through table rows
            for (int i = 1; i <= iterations; i++) {
                System.out.println("Inside loop " + i);
                String tableBody = tableBodyElement.getAttribute("innerHTML");

                // Append table body to the file
                fw.append(tableBody);

                // Click next button
                nextButton.click();

                // Wait for loader to disappear
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.invisibilityOf(loader));

                System.out.println("Iteration " + i + " completed.");
            }

            // Close the table HTML tag and the file
            fw.append("</table>");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

