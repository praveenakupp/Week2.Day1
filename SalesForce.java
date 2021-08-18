package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {
	
	public static void main (String args[])
	{
		WebDriverManager.chromedriver().setup();  //Launch the Chrome Browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=0000000Enyk/"); //Load the SalesForce URL

		driver.manage().window().maximize(); //To maximize theFB Browser

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Wait for 10 secs if the element is not in DOM

		driver.findElement(By.name("UserFirstName")).sendKeys("Praveena");
		driver.findElement(By.name("UserLastName")).sendKeys("Kuppuswami");
		driver.findElement(By.name("UserEmail")).sendKeys("praveenakupp@gmail.com");

		WebElement drop1 =driver.findElement(By.name("UserTitle"));
		Select drpDwn1=new Select(drop1);
		drpDwn1.selectByValue("Operations_Manager_AP");

	    driver.findElement(By.name("CompanyName")).sendKeys("Impiger Technologies");
	       
		WebElement drop2 =driver.findElement(By.name("CompanyEmployees"));
		Select drpDwn2=new Select(drop2);
		drpDwn2.selectByVisibleText("101 - 500 employees");

		driver.findElement(By.name("UserPhone")).sendKeys("5634278962");
	    
		WebElement drop3 =driver.findElement(By.name("CompanyCountry"));
	    Select drpDwn3=new Select(drop3);
		drpDwn3.selectByValue("IN");
				
    	//WebElement drop4=driver.findElement(By.name("CompanyState"));
	   // Select drpDwn4=new Select(drop4);
	  // drpDwn4.selectByValue("Tamil_Nadu");
				
	   driver.findElement(By.xpath("//input[@id='SubscriptionAgreement']/following-sibling::div")).click();
	}
}
