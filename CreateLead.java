package Week2.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		WebElement webUser = driver.findElement(By.id("username"));
		webUser.sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Praveena");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kuppuswami");

		WebElement dropDownSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropSource = new Select(dropDownSource);
		dropSource.selectByValue("LEAD_CONFERENCE");

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Praveena");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Ms");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Lead");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("100000000");

		WebElement dropDown1 = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select drop1 = new Select(dropDown1);
		drop1.selectByIndex(2);

		WebElement dropDown2 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select drop2 = new Select(dropDown2);
		drop2.selectByVisibleText("LLC/LLP");

		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("QWERTY");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Notes");

		WebElement dropDown3 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select drop3 = new Select(dropDown3);
		drop3.selectByIndex(2);

		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Bal");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("08/26/21");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Engineering");

		WebElement dropDown4 = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select drop4 = new Select(dropDown4);
		drop4.selectByVisibleText("CHF - Swiss Franc");

		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("5");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("A");

		WebElement countryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		countryCode.clear();
		countryCode.sendKeys("91");

		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("600");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("121");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("pk@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("64838392947");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("pk");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.pk.com");

		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("general");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("No. 46");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("11");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("600109");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Uma");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Kollidam");
		WebElement dropDown5 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select drop5 = new Select(dropDown5);
		drop5.selectByValue("AZ");
		WebElement dropDown6 = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select drop6 = new Select(dropDown6);
		drop6.selectByVisibleText("Denmark");

		driver.findElement(By.name("submitButton")).click();
		
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String firstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(firstName+" works in "+companyName);
		
		String title = driver.getTitle();
		if(title.equals("View Lead | opentaps CRM")) {
			System.out.println("The title of the web page is "+title);
		}
		else {
			System.out.println("The title is wrong");
		}
		driver.findElement(By.className("smallSubmit")).click();
		
}
}
