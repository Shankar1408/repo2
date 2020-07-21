package comThomes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	static Properties prop;
	public static WebDriver driver;/*
									 * making it static so that once the object is initallized till it get null all
									 * our driver wherever I have used the driver it will refer to this driver only
									 */

	public static WebDriver initiallizeDriver() throws IOException {
		// inovke chrome, ie or other browser with one method
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\resourcesFiles\\data.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\resourcesFiles\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\resourcesFiles\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	public void getScreenshotFail(String result) throws IOException
	{
		Date d=new Date();
		String screenShotName=d.toString().replace(":","_").replace(" ", "_")+".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File(System.getProperty("user.dir") + "\\src\\test\\java\\screenShotFail\\"+result+screenShotName));
	}
	public void getScreenshotPass(String result) throws IOException
	{
		Date d=new Date();
		String screenShotName=d.toString().replace(":","_").replace(" ", "_")+".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File(System.getProperty("user.dir") + "\\src\\test\\java\\screenShotPass\\"+result+screenShotName));
	}

}
