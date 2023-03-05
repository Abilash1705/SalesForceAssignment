package SalesForce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditDashBoard {
	@Test
	public  void edit() throws InterruptedException {
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	driver.findElement(By.id("password")).sendKeys("Leaf@123");
	driver.findElement(By.id("Login")).click();

	WebElement menu = driver.findElement(By.xpath("(//button[@type='button'])[7]"));
	menu.click();

	WebElement viewall = driver.findElement(By.xpath("//button[text()='View All']"));
	viewall.click();

	WebElement opt = driver.findElement(By.xpath("//input[@class='slds-input']"));
	opt.sendKeys("dashboard");
	driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
	
	WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"));
	search.sendKeys("Automated by 'Abilash");
	Thread.sleep(10000);
	WebElement edit = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small'])[1]//following::lightning-primitive-icon"));
	
	Actions dd2=new Actions(driver);
	dd2.moveToElement(edit).perform();
	
	edit.click();
	
	driver.findElement(By.xpath("//span[text()='Edit']")).click();
	WebElement frame = driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe"));
	driver.switchTo().frame(frame);
	
	driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();
	WebElement name = driver.findElement(By.xpath("(//input[@class='slds-input'])[1]"));
	
	name.sendKeys("SalesForce Automated by 'Abilash");
	WebElement text2 = driver.findElement(By.id("dashboardDescriptionInput"));
	text2.sendKeys("SalesForce");
	text2.getText();
	driver.findElement(By.xpath("(//span[@class='slds-radio_faux'])[2]")).click();
	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(5000);
	WebElement frame2 = driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe"));
	driver.switchTo().frame(frame2);
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	driver.findElement(By.xpath("//button[text()='Done']")).click();
	
	driver.switchTo().defaultContent();
	Thread.sleep(5000);
	WebElement frame3 = driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe"));
	driver.switchTo().frame(frame3);
	WebElement text = driver.findElement(By.xpath("//p[@class='slds-page-header__info']"));
	text.getText();
	System.out.println(text);
	String title = driver.getTitle();
	System.out.println(title);
	
	if (text2.equals(text)) {
		System.out.println("The Dashboard is Edited Successfully");
		
		
	} else {
		System.out.println("unsuccessfully");

	}
	
	
	
	
	
	

}
}
