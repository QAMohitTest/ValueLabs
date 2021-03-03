package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.crm.qa.util.TestUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.LocksDevice;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static AppiumDriver driver;
	public static Properties prop;




	public TestBase(){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}





	@BeforeClass
	public static void initialization() throws MalformedURLException{
		System.out.println("Installing App...........");
		String appPath= System.getProperty("user.dir")+"\\src\\test\\resources\\app\\app-debug.apk";
		//System.out.println(appPath);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName",prop.getProperty("platformName") );
		caps.setCapability("platformVersion",prop.getProperty("platformVersion") );
		caps.setCapability("deviceName", prop.getProperty("deviceName") );
		caps.setCapability("automationName", prop.getProperty("automationName") );
		caps.setCapability("app", appPath );
		caps.setCapability("noReset", false);
		//caps.setCapability("unlockType", "pattern"); 
		//caps.setCapability("unlockKey", "6589"); 
		caps.setCapability("appPackage", prop.getProperty("appPackage") );
		caps.setCapability("appActivity", prop.getProperty("appActivity") );
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}



	@AfterClass
	public static void uninstallapp() throws MalformedURLException, InterruptedException {
		System.out.println("Uninstalling App...........");
		driver.removeApp(prop.getProperty("appPackage"));

	}


}
