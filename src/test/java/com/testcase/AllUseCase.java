package com.testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import comThomes.Base;
import pageObjec.LoginPageObject;
import util.TestUtilLogin;

public class AllUseCase extends Base {
	LoginPageObject l1;// global variable
	static String pageLoadStatus = null;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initiallizeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// driver is initiallized in the base class
	}

	@DataProvider(name = "getLoginData")
	public Object[][] getLoginData(Method method) throws Exception// this will read the data from excel file
	{ // now i will create utility which will apply to all excel file
		Object data[][] = TestUtilLogin.getTestData(0);
		return data;
	}

	public static void waitForPageLoad() {

		do {

			JavascriptExecutor js;

			js = (JavascriptExecutor) driver;

			pageLoadStatus = (String) js.executeScript("return document.readyState");

		} while (!pageLoadStatus.equals("complete"));

		System.out.println("Page Loaded.");

	}

	@Test(priority = 1, dataProvider = "getLoginData")
	public void loginPage(String username, String password) throws Exception {
		

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\resourcesFiles\\data.properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		waitForPageLoad();
		driver.get(url);
		driver.manage().window().maximize();
		l1 = new LoginPageObject(driver);// required to create constructor so that driver's life can be send
		// this driver is object model which contains the information of WebDriver
		l1.username().sendKeys(username);
		l1.password().sendKeys(password);
		l1.Submit().click();
		Thread.sleep(2000);
	}

	@DataProvider(name = "getDataForOrder") // since I am using multiple data provider annotations I am using name for
											// the data providers
	public Object[][] getDataForOrder(Method method) throws Exception// this will read the data from excel file
	{ // now i will create utility which will apply to all excel file
		Object data[][] = TestUtilLogin.getTestData(1);
		return data;
	}

	@Test(priority = 2, dataProvider = "getDataForOrder")
	public void orderPage(String quantity, String pricePerunit, String discount, String customerName, String streetName,
			String City, String state, String zip, String cardNumber, String expDate) throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\resourcesFiles\\data.properties");
		prop.load(fis);
		l1 = new LoginPageObject(driver);
		l1.Submit().click();
		l1.Order().click();
		Select d1 = new Select(l1.dropdown());
		d1.selectByValue(prop.getProperty("productName"));
		l1.quantity().sendKeys(Keys.chord(Keys.CONTROL, "a"), quantity);
		l1.pricePerUnit().sendKeys(Keys.chord(Keys.CONTROL, "a"), pricePerunit);
		l1.discount().sendKeys(Keys.chord(Keys.CONTROL, "a"), discount);
		l1.totoal().click();
		System.out.println("total values =" + l1.totalValue().getText());
		l1.name().sendKeys(Keys.chord(Keys.CONTROL, "a"), customerName);
		l1.streeName().sendKeys(Keys.chord(Keys.CONTROL, "a"), streetName);
		l1.city().sendKeys(Keys.chord(Keys.CONTROL, "a"), City);
		l1.state().sendKeys(Keys.chord(Keys.CONTROL, "a"), state);
		l1.zipCode().sendKeys(Keys.chord(Keys.CONTROL, "a"), zip);
		l1.card().click();
		l1.cardNum().sendKeys(Keys.chord(Keys.CONTROL, "a"), cardNumber);
		l1.expDate().sendKeys(Keys.chord(Keys.CONTROL, "a"), expDate);
		l1.prcoeess().click();
		AssertJUnit.assertEquals(prop.getProperty("orderPlacedSucceessfuly"), l1.orderPlaceMessage().getText());
		System.out.println("verification completed for placed order after assert statement is completed");
	}

	@DataProvider(name = "getchangeOrder")
	public Object[][] getchangeOrder(Method method) throws Exception// this will read the data from excel file
	{
		Object data[][] = TestUtilLogin.getTestData(2);
		return data;
	}

	@Test(priority = 3, dataProvider = "getchangeOrder")
	public void updateOrderWithNewAddress(String streetName, String City, String state, String expDate)
			throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\resourcesFiles\\data.properties");
		prop.load(fis);
		l1 = new LoginPageObject(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		l1.viewOrder().click();
		l1.nameClick().click();
		l1.cilckMyOrder().click();
		l1.calculate().click();
		l1.expDate().sendKeys(Keys.chord(Keys.CONTROL, "a"), expDate);
		Thread.sleep(2000);
		l1.streeName().sendKeys(Keys.chord(Keys.CONTROL, "a"), streetName);
		l1.city().sendKeys(Keys.chord(Keys.CONTROL, "a"), City);
		l1.state().sendKeys(Keys.chord(Keys.CONTROL, "a"), state);
		l1.update().click();
	}

	@Test(priority = 4)

	public void deleteOrder() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		l1.viewOrder().click();

		List<WebElement> names = driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
		for (int i = 0; i < names.size() - 1; i++) {
			if (names.get(i).getText().equalsIgnoreCase("undertake")) {
				l1.checkBox().click();
				l1.deleteT().click();
				break;
			}

			Thread.sleep(2000);

		}
	}

	@AfterTest()
	public void tearDown() {

		driver.quit();
	}
}
