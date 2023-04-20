package week4.Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Checkalrtopp {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(Options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@data-key='chevrondown'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='slds-truncate']//span")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("4/20/2023");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		Thread.sleep(2000);
		String namealrt=driver.findElement(By.xpath("//div[@part='help-text']")).getText();
		WebElement verifyname=driver.findElement(By.xpath("//div[@part='help-text']"));
		boolean isvisible=verifyname.isDisplayed();
		System.out.println(isvisible+", It throws an alert as "+namealrt);
		
		////div[@part='help-text']-fr name
		String stagealrt = driver.findElement(By.xpath("(//div[text()='Complete this field.'])[2]")).getText();
		WebElement verifystage=driver.findElement(By.xpath("(//div[text()='Complete this field.'])[2]"));
		boolean isvisiblestg=verifystage.isDisplayed();
		System.out.println(isvisiblestg+", It throws an alert as "+stagealrt);
		

	}

}
