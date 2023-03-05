package SalesForce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashBoard {
	@Test
	public void dashboard() throws InterruptedException {
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
		
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		WebElement frame = driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe"));
		driver.switchTo().frame(frame);
		
		
		WebElement name = driver.findElement(By.xpath("(//input[@class='slds-input'])[1]"));
		
		name.sendKeys("SalesForce Automated by 'Abilash");
		
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		WebElement frame2 = driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		
		
		
		}

}
