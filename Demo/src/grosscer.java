import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class grosscer {
public void setUp() throws Exception 
	
	{
		 
		WebDriver driver; 

		File app = new File("D:\\tej\\Tesco Groceries.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("device","Android");

		capabilities.setCapability(CapabilityType.VERSION, "4.4");

		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("deviceName", "Nexus 5");

		capabilities.setCapability("app", app.getAbsolutePath());

			
		              

		//Create an instance of RemoteWebDriver and connect to the Appium server.

		driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		 Thread.sleep(10000);
		 driver.findElement(By.id("com.tesco.grocery.view:id/signin_btn")).click();
}
}