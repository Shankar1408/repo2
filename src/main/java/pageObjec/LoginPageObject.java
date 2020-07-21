package pageObjec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import comThomes.Base;

public class LoginPageObject extends Base {

	public WebDriver driver;

	public LoginPageObject(WebDriver driver) {// the constructor is created so that the life of driver from initiallize
												// driver in base method can be passed in the current instance
		this.driver = driver;
	}

	By Username = By.xpath("//input[@name='ctl00$MainContent$username']");
	By Password = By.xpath("//input[@name='ctl00$MainContent$password']");
	By Submit = By.xpath("//input[@type='submit']");
	By Order = By.xpath("//a[contains(text(),'Order')]");
	By dropdown = By.id("ctl00_MainContent_fmwOrder_ddlProduct");
	By quantity = By.id("ctl00_MainContent_fmwOrder_txtQuantity");// send keys
	By pricePerUnit = By.id("ctl00_MainContent_fmwOrder_txtUnitPrice");// send keys
	By discount = By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtDiscount']");// send keys
	By calculate = By.xpath("//input[@value='Calculate']");// click
	By total=By.id("ctl00_MainContent_fmwOrder_txtTotal");
	By totalValue=By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/ol[1]/li[5]/label");
	By name = By.id("ctl00_MainContent_fmwOrder_txtName");// send name
	By streeName = By.id("ctl00_MainContent_fmwOrder_TextBox2");
	By city = By.id("ctl00_MainContent_fmwOrder_TextBox3");
	By state = By.id("ctl00_MainContent_fmwOrder_TextBox4");
	By zipCode = By.id("ctl00_MainContent_fmwOrder_TextBox5");
	By card = By.xpath("//input[@value='MasterCard']");
	By cardNum = By.id("ctl00_MainContent_fmwOrder_TextBox6");
	By expDate = By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']");
	By prcoeess = By.xpath("//a[@class='btn_light']");
	By orderPlaceMessage=By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong");
	//for vieworder
	By nameClick = By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']");
	By viewOrder=By.xpath("//*[text()='View all orders']");
	By cilckMyOrder=By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[13]/input");
	By update=By.id("ctl00_MainContent_fmwOrder_UpdateButton");
	By checkText=By.xpath("//*[text()='undertake']");
	By deleteT=By.xpath("//input[@name='ctl00$MainContent$btnDelete']");
	By tableNames=By.xpath("By.xpath(\"//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]\")");
	By checkBox=By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]//..//td//input[@type='checkbox']");
	By allTableNames=By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]");
	//update
	//By deleteT=By.xpath("//input[@name='ctl00$MainContent$btnDelete']");
	
	public WebElement checkBox() {
		return driver.findElement(checkBox);
	}
	

	public WebElement username() {
		return driver.findElement(Username);
	}
	

	public WebElement password() {
		return driver.findElement(Password);
	}

	public WebElement Submit() {
		return driver.findElement(Submit);
	}

	public WebElement Order() {
		return driver.findElement(Order);
	}

	public WebElement dropdown() {
		return driver.findElement(dropdown);
	}

	public WebElement quantity() {
		return driver.findElement(quantity);
	}

	public WebElement pricePerUnit() {
		return driver.findElement(pricePerUnit);
	}

	public WebElement discount() {
		return driver.findElement(discount);
	}

	public WebElement calculate() {
		return driver.findElement(calculate);
	}
	public WebElement totoal() {
		return driver.findElement(total);
	}
	public WebElement totalValue() {
		return driver.findElement(totalValue);
	}
	
	

	public WebElement name() {
		return driver.findElement(name);
	}

	public WebElement streeName() {
		return driver.findElement(streeName);
	}

	public WebElement city() {
		return driver.findElement(city);
	}

	public WebElement state() {
		return driver.findElement(state);
	}

	public WebElement zipCode() {
		return driver.findElement(zipCode);
	}

	public WebElement card() {
		return driver.findElement(card);
	}

	public WebElement cardNum() {
		return driver.findElement(cardNum);
	}

	public WebElement expDate() {
		return driver.findElement(expDate);
	}

	public WebElement prcoeess() {
		return driver.findElement(prcoeess);
	}

	public WebElement nameClick() {
		return driver.findElement(nameClick);
		}
	public WebElement viewOrder() {
		return driver.findElement(viewOrder);
}
	
	public WebElement cilckMyOrder() {
		return driver.findElement(cilckMyOrder);
	}
		
		public WebElement update() {
			return driver.findElement(update);
		}
		public String checkText() {
			return driver.findElement(checkText).getText();
		}
		
		public WebElement deleteT()
		{
			return driver.findElement(deleteT);
		}
		
		public WebElement orderPlaceMessage()
		{
			return driver.findElement(orderPlaceMessage);
		}
		
		public WebElement tableNames()
		{
			return (WebElement) driver.findElements(tableNames);
		}
		
		
}
