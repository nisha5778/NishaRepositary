
package Login ;

import java.time.Duration;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Login {
	WebDriver chromeDriver;
		@FindBy (id = "email") WebElement txtEmail;
		@FindBy (id = "password") WebElement txtPassword;
		@FindBy (id = "loginButton") WebElement btnLogin;
		@FindBy (xpath = "//button [@aria-label='Next page']") WebElement btnNextPage;	
		@FindBy (xpath = "//div[text()=' Lemon Juice (500ml) ']/../../../div[2]/button") 
					WebElement btnAddLemonJuice;
		@FindBy (xpath = "//div[text()=' OWASP Juice Shop Iron-Ons (16pcs) ']/../../../div[2]/button") 
					WebElement btnAddIronOns;
		@FindBy (xpath = "//div[text()=' Apple Juice (1000ml) ']/../../../div[2]/button") 
					WebElement btnAddAppleJuice;
		@FindBy (xpath = "//div[text()=' Quince Juice (1000ml) ']/../../../div[2]/button") 
					WebElement btnAddQuinceJuice;
		@FindBy (xpath = "//span[.=' Your Basket']") WebElement lnkBasket;
		@FindBy (xpath = "//button[.=' Checkout ']") WebElement btnCheckOut;
		@FindBy (xpath = "//button[@routerlink='/address/create']") 
					WebElement btnAddAddress;	
		@FindBy (xpath ="//input[@data-placeholder='Please provide a country.']") 
					WebElement txtCountry;
		@FindBy (xpath ="//input[@placeholder=\"Please provide a name.\"]") 
					WebElement txtname;	
		@FindBy (xpath ="//input[@placeholder=\"Please provide a mobile number.\"]") 
					WebElement txtMobile;
		@FindBy (xpath ="//input[@placeholder=\"Please provide a ZIP code.\"]") 
					WebElement txtZip;
		@FindBy (xpath ="//textarea[@placeholder='Please provide an address.']") 
					WebElement txtAddress;
		@FindBy (xpath ="//input[@placeholder='Please provide a city.']") 
					WebElement txtCity;
		@FindBy (xpath ="//input[@placeholder='Please provide a state.']") 
					WebElement txtState;		
		@FindBy (xpath ="//button[@id='submitButton']") 
					WebElement btnSubmit;
		@FindBy (xpath = "//mat-card/mat-table/mat-row/mat-cell[1]")
					WebElement radioSelectAddres; 	
		@FindBy (xpath = "//span[text()='Continue']/../..")
					WebElement btnContinueAddress;
		@FindBy (xpath = "//h1/../../div[3]/mat-table/mat-row[2]/mat-cell")
					WebElement radioDeliverySpeed;
		@FindBy (xpath = "//span[text()='Continue']/../..")
					WebElement btnContinueWDelAddress;
		@FindBy (xpath = "//mat-panel-title[.=' Add new card ']")
					WebElement lnkAddNewCard;
		@FindBy (xpath = "//mat-label[text()='Name']/../../../input")
					WebElement txtNameOnCard;
		@FindBy (xpath = "//mat-label[text()='Card Number']/../../../input")
					WebElement txtCardNumber;
		@FindBy (xpath = "//mat-label[text()='Expiry Month']/../../../select")
					WebElement selectCardExpMonth;
		@FindBy (xpath = "//mat-label[text()='Expiry Year']/../../../select")
					WebElement selectCardExpYear;	
		@FindBy (xpath = "//span[text()=' Submit ']/..")
					WebElement btnSubmitCardDetails;
		@FindBy (xpath = "//mat-table/mat-row[1]/mat-cell[1]/mat-radio-button")
					WebElement radioSelectCard;	
		@FindBy (xpath = "//mat-icon[text()=' navigate_next ']/../span")
					WebElement btnProceedToReview;
		@FindBy (xpath = "//span[text()='Place your order and pay']/../..")
					WebElement btnPlaceOrderAndPay;
		@FindBy (xpath = "//span[text()=' Account ']/../..")
					WebElement lnkAccount;
		@FindBy (xpath = "//button[@aria-label='Show Orders and Payment Menu']")
					WebElement lnkAccOrdersPayment;
		@FindBy (xpath = "//span[text()=' Order History ']")
					WebElement lnkOrderStatus;
		@FindBy (xpath = "//button[@id='navbarLogoutButton']")
					WebElement lnkLogout;
		@FindBy (xpath = "//mat-panel-title[text()=' Add a coupon ']")
					WebElement lnkAddCoupon;
		@FindBy (xpath = "//input[@data-placeholder='Please enter your coupon code']")
					WebElement txtCouponCode;
		@FindBy (xpath = "//button/span[text()=' Redeem ']")
					WebElement btnRedeemCoupon;
		
	public void OpenWebsite() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\manas\\eclipse-workspace\\JuiceShop1\\src\\test\\resources\\drivers\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.get("https://juice-shop.herokuapp.com/#/login");
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--disable-notifications");
		//chromeDriver.switchTo().alert().dismiss();
		//Actions action= new Actions(chromeDriver);
		//action.keyDown(Keys.CONTROL).sendKeys("a").perform();
		//Robot robot = new Robot(); //alternative for Actions class
	}
	
	public void CreateUser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\manas\\eclipse-workspace\\Hello-Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.get("https://juice-shop.herokuapp.com/#/register");
		
		WebElement txtEmail = chromeDriver.findElement(By.xpath("//mat-label[text()='Email']"));
		txtEmail.sendKeys("nisha5778@gmail.com");
		WebElement txtPassword = chromeDriver.findElement(By.xpath("//mat-label[text()='Password']"));
		txtPassword.sendKeys("password");
		WebElement txtRPassword = chromeDriver.findElement(By.id("repeatPasswordControl"));
		txtRPassword.sendKeys("password");		
	}
	
	 
	@Test	
	public void LoginToWebsite() throws InterruptedException {
		OpenWebsite();
		PageFactory.initElements(chromeDriver, this);
		txtEmail.sendKeys("nisha@gmail.com");
		txtPassword.sendKeys("11111");
		btnLogin.sendKeys(Keys.ENTER);
		//chromeDriver.manage().window().maximize();
		//ChromeOptions chrOptions = new ChromeOptions();
		//chrOptions.setImplicitWaitTimeout(Duration.ofSeconds(5));
		
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		chromeDriver.findElement(By.xpath("//div[@class='cc-compliance']/a")).click();
		chromeDriver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		AddToBasket();
		Thread.sleep(2000);
		OpenBasket();
		IncreaseQuantity();
		CheckOut();
		Thread.sleep(2000);
		AddAddress();
		Thread.sleep(5000);
		SelectAddress();
		Thread.sleep(5000);
		SelectDeliverySpeed();
		AddNewCard();
		PlaceOrdeer();
		PrintTrackOrder();		
		Logout();
	}
	
	private void AddToBasket() throws InterruptedException {
			/*boolean bNextPage = true;
		while(bNextPage) {
			btnNextPage.click();
			bNextPage = btnNextPage.isEnabled();
		}*/
		Thread.sleep(2000);
		btnAddLemonJuice.click();
		btnNextPage.click();
		btnAddIronOns.click();
		btnNextPage.click();
		btnAddQuinceJuice.click();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}
	
	private void OpenBasket() {
		lnkBasket.click();
	}
	
	private void IncreaseQuantity() throws InterruptedException {
		
		Thread.sleep(2000);

		List<WebElement> btnsAdd = chromeDriver.findElements
				(By.xpath("//mat-table/mat-row/mat-cell[3]/button[2]")); 
		
		for (WebElement btnAdd : btnsAdd) {
			btnAdd.sendKeys(Keys.ENTER);
		}
	}
	
	private void CheckOut() {
		btnCheckOut.sendKeys(Keys.ENTER);
	}
	
	private void AddAddress() {
		btnAddAddress.sendKeys(Keys.ENTER);
		txtCountry.sendKeys(RandomStringUtils.randomAlphabetic(8));
		txtname.sendKeys(RandomStringUtils.randomAlphabetic(8));
		txtMobile.sendKeys(RandomStringUtils.randomNumeric(10));
		txtZip.sendKeys(RandomStringUtils.randomNumeric(5));
		txtAddress.sendKeys(RandomStringUtils.randomAlphanumeric(30));
		txtCity.sendKeys(RandomStringUtils.randomAlphabetic(10));
		txtState.sendKeys(RandomStringUtils.randomAlphabetic(8));
		btnSubmit.sendKeys(Keys.ENTER);
	}
	
	private void SelectAddress() throws InterruptedException {

		Thread.sleep(2000);
		radioSelectAddres.click();
		btnContinueAddress.click();		
	}

	private void SelectDeliverySpeed() {
		radioDeliverySpeed.click();
		btnContinueWDelAddress.click();
	}
	private void AddNewCard() throws InterruptedException {
		lnkAddNewCard.click();
		txtNameOnCard.sendKeys(RandomStringUtils.randomAlphabetic(10));
		txtCardNumber.sendKeys(RandomStringUtils.randomNumeric(16));
		Select selMonth = new Select(selectCardExpMonth);
		selMonth.selectByIndex(Integer.parseInt(RandomStringUtils.randomNumeric(1,2)));
		Select selYear = new Select(selectCardExpYear);
		selYear.selectByIndex(Integer.parseInt(RandomStringUtils.randomNumeric(1,2)));
		btnSubmitCardDetails.click();
		Thread.sleep(9000);
		AddCoupon();
		Thread.sleep(1000);;
		radioSelectCard.click();
		btnProceedToReview.click();
	}
	private void AddCoupon() throws InterruptedException {
		lnkAddCoupon.click();
		Thread.sleep(1000);
		txtCouponCode.sendKeys(RandomStringUtils.randomAlphabetic(10));
		btnRedeemCoupon.click();
		List<WebElement> errorMessage = 
				chromeDriver.findElements(By.xpath("//div[@class='error ng-star-inserted']"));
		if (errorMessage.size()>0)
		{
			System.out.println(errorMessage.get(0).getText());	
		}
	}
	private void PlaceOrdeer() throws InterruptedException {
		Thread.sleep(2000);
		btnPlaceOrderAndPay.click();
	}
	private void PrintTrackOrder() {
		lnkAccount.click();
		lnkAccOrdersPayment.click();
		lnkOrderStatus.click();	
	}
	private void Logout() throws InterruptedException {
		lnkAccount.click();
		Thread.sleep(2000);
		lnkLogout.click();
	}
	
}