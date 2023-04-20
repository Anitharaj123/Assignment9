package week4.Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class CreateOpp {

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
	
	WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));
			name.sendKeys("Salesforce Automation By Anitha");
			Thread.sleep(2000);
			String data=name.getText();
			System.out.println(data);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("4/19/2023");
			WebElement dd=driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]"));
			dd.click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//span[text()='Needs Analysis']")).click();
			
//			Select Option=new Select(dd);
//			Thread.sleep(2000);
//			Option.selectByIndex(3);
		
			driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
			String name1=driver.findElement(By.xpath("//slot[@name='primaryField']")).getText();	
			
			System.out.println(name1);
			if(data.equalsIgnoreCase(name1)) {
				System.out.println("Verified");
			}
		
		
		

	}

}
