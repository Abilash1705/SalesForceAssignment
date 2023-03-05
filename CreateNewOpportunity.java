package SalesForce;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOpportunity {
	@Test
	public  void opportunity() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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
		opt.sendKeys("opportunities");

		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();

		driver.findElement(By.xpath("//div[@title='New']")).click();

		WebElement name = driver.findElement(By.xpath("//input[@name='Name']"));
		name.sendKeys("SalesForce Automated by 'Abilash'");


		WebElement date = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));
		date.click();

		WebElement calendar = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));

		calendar.sendKeys("12/17/2022");

		WebElement stage=driver.findElement(By.xpath("(//span[text()='--None--'])[1]"));

		stage.click();

		WebElement option=driver.findElement(By.xpath("(//span[@class='slds-media__body'])[5]//span"));

		option.click();

		WebElement save=driver.findElement(By.xpath("//button[text()='Save']"));

		save.click();























	}

}
