import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class test1 

{

	public void setUp() throws Exception 
	
	{
		
		WebDriver driver;

		File app = new File("D:/Back up/AppiumForWindows-1.3.4.1/MAG_Cryptall_Build_V1.0.13.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("device","Android");

		capabilities.setCapability(CapabilityType.VERSION, "4.3");

		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("deviceName", "csi-android");

		capabilities.setCapability("app", app.getAbsolutePath());

			
		              

		//Create an instance of RemoteWebDriver and connect to the Appium server.

		driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		 Thread.sleep(10000);
	        driver.findElement(By.id("com.cryptall:id/et_countrycode")).sendKeys("91");
	       Thread.sleep(10000);
	        driver.findElement(By.id("com.cryptall:id/et_phoneNumber")).sendKeys("12345678094");
	        Thread.sleep(10000);
	        driver.findElement(By.id("com.cryptall:id/btn_welcome_next_disabled")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.id("com.cryptall:id/button_ok")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.id("com.cryptall:id/et_otp")).sendKeys("123456");
	        Thread.sleep(10000);
	        driver.findElement(By.id("com.cryptall:id/btn_otp_next_disabled")).click();
	        Thread.sleep(10000);
	        /*driver.findElement(By.id("com.cryptall:id/iv_profile_picture")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.id("android:id/text1")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.id("com.sec.android.gallery3d:id/cancel_button")).click();
	        Thread.sleep(50000);*/
	        driver.findElement(By.id("com.cryptall:id/rel_profile_info")).click();
	        driver.findElement(By.id("com.cryptall:id/et_user_status")).sendKeys("abc");
	        Thread.sleep(10000);
	       //driver.findElement(By.id("com.cryptall:id/et_user_status")).submit();
	       //Thread.sleep(10000);
	       // driver.findElement(By.id("com.cryptall:id/et_user_status")).sendKeys("abc");
	        Thread.sleep(30000);
	        driver.findElement(By.id("com.cryptall:id/btn_profile_editing_next")).click();
	        
	       
	        
	        
	        Thread.sleep(40000);
		
		

		}
}
