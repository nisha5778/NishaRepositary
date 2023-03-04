package CovidData;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HospitalData {
	WebDriver chromeDriver;
	JavascriptExecutor js;
	
	@Test (priority = 1)
	private void LoadPage() {
		chromeDriver = new ChromeDriver();
		js = (JavascriptExecutor) chromeDriver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\manas\\eclipse-workspace\\Covid1\\src\\test\\resources\\drivers\\chromedriver.exe");
		
		
		ChromeOptions optChrome = new ChromeOptions();
		optChrome.setAcceptInsecureCerts(true);
		optChrome.addArguments("--allow-running-insecure-content");
		
		chromeDriver.manage().window() .maximize();
		chromeDriver.get("https://westbengal.covidsafe.in/");
		chromeDriver.findElement(By.id("details-button")).click();
		chromeDriver.findElement
			(By.xpath("//a[text()='Proceed to westbengal.covidsafe.in (unsafe)']")).click();		
	}
	
	@Test(priority = 2)
	private void LoadAllData() throws InterruptedException {		
		Thread.sleep(2000);
		int iSize = 1;
		
		while (iSize > 0){
			Thread.sleep(1000);
			List<WebElement> btnLoad = chromeDriver.findElements(By.xpath("//button[text()='Load next 20']"));
			iSize = btnLoad.size();
			if (iSize>0) {
				btnLoad.get(0).sendKeys(Keys.ENTER);
			}
			else {
				break;}
		}
	}
	
	@Test ( priority = 3)
	private void DisplayData() {
	
		List<WebElement> TotalRows = chromeDriver.findElements(By.xpath
					("//table[@class='result-table table table-borderless table-hover']/tbody/tr"));
		//System.out.println(TotalRows.size());
		int i, j, intNoOfRows, intTotalBeds;
		String strO2Beds, strVentilatorBeds, strName, strPhone, strAddress;
		intNoOfRows = TotalRows.size();
		String[] strHeading = {"• Name of the hospital : ",
								"• Total available beds : ",
								"• O2 beds availability : ",
								"• Ventialtor(s) availability : ", 
								"• Contact number : ",
								"• Address : "
								};
		
		for(i=1; i<=intNoOfRows ; i++) {
			System.out.println("-------------------------------------------------------------------");
			intTotalBeds = 0;
			strO2Beds = "";
			strVentilatorBeds = "";
			strName = "";
			strPhone = "";
			strAddress = "";
			//System.out.println(TotalRows.get(i).getText());
			WebElement plusMinus = chromeDriver.findElement
						(By.xpath("//table/tbody/tr[" + i + "]/td[1]/div/button"));
			plusMinus.sendKeys(Keys.SPACE);
			WebElement txtPhone = chromeDriver.findElement
					(By.xpath("//span[contains(text(), 'Phone')]"));
			strPhone = txtPhone.getText();
			
			WebElement txtAddress = chromeDriver.findElement
					(By.xpath("//span[contains(text(), 'Address')]"));
			strAddress = txtAddress.getText();
			plusMinus.sendKeys(Keys.SPACE);
			
			strName = chromeDriver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]")).getText();
			strO2Beds = chromeDriver.findElement(By.xpath
							("//table/tbody/tr[" + i + "]/td[3]/span/span")).getText();
			strVentilatorBeds = chromeDriver.findElement(By.xpath
					("//table/tbody/tr[" + i + "]/td[5]/span/span")).getText();
			
			for(j=2; j<6; j++) {
				WebElement columnData = chromeDriver.findElement(By.xpath
						("//table/tbody/tr[" + i + "]/td[" + j + "]/span/span"));
				intTotalBeds = intTotalBeds + Integer.valueOf(columnData.getText());
			}	
			System.out.println(strHeading[0] + strName);
			System.out.println(strHeading[1] + intTotalBeds);
			System.out.println(strHeading[2] + strO2Beds);
			System.out.println(strHeading[3] + strVentilatorBeds);
			System.out.println( strPhone);
			System.out.println( strAddress);
		}
	}
}
