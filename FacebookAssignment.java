package Week2.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookAssignment {

	public static void main(String[] args)
	{
	WebDriverManager.chromedriver().setup();  //Launch the Chrome Browser
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://en-gb.facebook.com/"); //Load the FaceBook URL
	driver.manage().window().maximize(); //To maximize theFB Browser
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Wait for 10 secs if the element is not in DOM
	driver.findElement(By.linkText("Create New Account")).click();
	driver.findElement(By.name("firstname")).sendKeys("Praveena");
	driver.findElement(By.name("lastname")).sendKeys("Kuppuswami");
	driver.findElement(By.name("reg_email__")).sendKeys("praveenakupp@gmail.com");
	driver.findElement(By.name("reg_email_confirmation__")).sendKeys("praveenakupp@gmail.com");
	driver.findElement(By.id("password_step_input")).sendKeys("Praveena@aliyar5");

	WebElement drop1 =driver.findElement(By.id("day"));
	Select drpDwn1=new Select(drop1);
	drpDwn1.selectByIndex(28);
	
	WebElement drop2 =driver.findElement(By.id("month"));
	Select drpDwn2=new Select(drop2);
	drpDwn2.selectByValue("9");
	
	WebElement drop3 =driver.findElement(By.id("year"));
	Select drpDwn3=new Select(drop3);
	drpDwn3.selectByVisibleText("1982");
  
     WebElement radio1 = driver.findElement(By.xpath("//input[@value='1']"));
     radio1.click();
   
	driver.findElement(By.name("websubmit")).click();
}
	
	
}
