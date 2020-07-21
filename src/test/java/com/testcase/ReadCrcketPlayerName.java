package com.testcase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjec.LoginPageObject;

public class ReadCrcketPlayerName {
	public static void main(String[] args) throws Exception {

System.out.println(System.getProperty("user.dir")+"\\src\\test\\java\\util\\login.xlsx");
	}

	public static void namesOfCricketer() {
		// *[@id="main-content"]/div[2]/div/div/div[3]/table/tbody/tr/td[2]/div[2]/div[2]
		System.setProperty("webdriver.chrome.driver",
				"D:\\javaWorkspaceNew24_april_2020\\AllFixedCodes\\src\\main\\resources\\resourcesFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.iplt20.com/stats/all-time/highest-scores");
		List<WebElement> names = driver.findElements(
				By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/div[3]/table/tbody/tr/td[2]/div[2]/div[2]"));
		for (int i = 0; i < names.size() - 1; i++) {
			System.out.println(names.get(i + 1).getText());
		}
	}

	public static void customerName() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\javaWorkspaceNew24_april_2020\\AllFixedCodes\\src\\main\\resources\\resourcesFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		LoginPageObject l1 = new LoginPageObject(driver);
		l1.username().sendKeys("Tester");// EXCEL PART NEED TO BE DONE
		l1.password().sendKeys("test");
		l1.Submit().click();
		l1.viewOrder().click();
		// List<WebElement> names = driver.findElements(By.tagName("tr"));
		List<WebElement> names = driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
		for (int i = 0; i < names.size() - 1; i++) {
			if(names.get(i).getText().equalsIgnoreCase("paul brown")) {
				System.out.println("awesome");
			}
		}

	}
}
