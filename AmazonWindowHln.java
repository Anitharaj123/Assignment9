package week4.Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.internal.AbstractParallelWorker.Arguments;

//import io.github.sukgu.Shadow;


public class AmazonWindowHln {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement Search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Search.sendKeys("oneplus 9 pro" +Keys.ENTER);
		String phPrice=driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("The First resultant phone price is: Rs. "+phPrice);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='javascript:void(0)']//i")).click();
		String ratingcount = driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']")).getText();
     	System.out.println("The rating is: "+ratingcount);
     	Thread.sleep(2000);
     	driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).click();
     	//String WindowHandle=driver.getWindowHandle();
     	Set<String> WindowHandles=driver.getWindowHandles();
     	List<String> Allwindw=new ArrayList<String>(WindowHandles);
     	driver.switchTo().window(Allwindw.get(1));
     	File snap=driver.getScreenshotAs(OutputType.FILE);
     	File dst=new File("./snaps/snaps.png");
     	FileUtils.copyFile(snap, dst);
     	driver.findElement(By.id("add-to-cart-button")).click();
     	Thread.sleep(8000);
     	String amount = driver.findElement(By.xpath("(//div[contains(@class,'a-column a-span11')])[1]")).getText();
     	System.out.println(amount);
     	System.out.println(amount.contains(phPrice) +". "+"The phone Price is verified");
     	driver.quit();
     	
		
		
		
	}

}
