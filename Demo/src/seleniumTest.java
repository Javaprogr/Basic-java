


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;


import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

import java.net.URL;


public class seleniumTest {

private WebDriver driver;

@BeforeClass

public void setUp() throws Exception {

File app = new File("D:/Back up/AppiumForWindows-1.3.4.1/MAG_Cryptall_Build_V1.0.13.apk");

DesiredCapabilities capabilities = new DesiredCapabilities();

capabilities.setCapability("device","Android");

//capabilities.setCapability(CapabilityType.VERSION, "4.3");
capabilities.setCapability(CapabilityType.VERSION, "5.0.1");

capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");

capabilities.setCapability("platformName", "Android");

//capabilities.setCapability("deviceName", "csi-android");
capabilities.setCapability("deviceName", "Nexus 5");

capabilities.setCapability("app", app.getAbsolutePath());

	
              

//Create an instance of RemoteWebDriver and connect to the Appium server.

driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

}

@Test
	  public <MobileElement> void testcase_001() throws Exception{
	        
	        Thread.sleep(10000);
	      
	        driver.findElement(By.id("com.cryptall:id/autoComplete")).click();
	        driver.findElement(By.id("com.cryptall:id/autoComplete")).sendKeys("India");
	        //driver.findElement(By.id("com.cryptall:id/et_countrycode")).sendKeys("91");
	        //driver.findElement(By.name("Mobile Number")).click();
	        //Thread.sleep(10000);
	     
	        Thread.sleep(10000);
	        driver.findElement(By.id("com.cryptall:id/et_phoneNumber")).click();
	        driver.findElement(By.id("com.cryptall:id/et_phoneNumber")).sendKeys("124878094");
	        Thread.sleep(10000);
	        	       
	        driver.findElement(By.id("com.cryptall:id/btn_welcome_next_disabled")).click();
	        //driver.findElement(By.name("Next")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.id("com.cryptall:id/button_ok")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.id("com.cryptall:id/et_otp")).sendKeys("123456");
	        Thread.sleep(10000);
	        driver.findElement(By.id("com.cryptall:id/btn_otp_next_disabled")).click();
	        Thread.sleep(10000);
	        
	    //    driver.findElement(By.id("com.cryptall:id/rel_profile_info")).click();
	        driver.findElement(By.id("com.cryptall:id/et_user_name")).click();
	        driver.findElement(By.id("com.cryptall:id/et_user_name")).sendKeys("abc");
	        
	      
	        driver.findElement(By.id("com.cryptall:id/iv_profile_picture")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.name("Photos")).click();
	        Thread.sleep(10000);
	        //Actions.ContextClick(element).Click(x axis, y axis).build.perform();
	       /* driver.findElement(By.name("Camera")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.id("com.android.camera2:id/shutter_button")).click();
	        Thread.sleep(20000);
	        driver.findElement(By.id("com.android.camera2:id/done_button")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.name("Done")).click();
	        Thread.sleep(20000);*/
	      
	        
	       
	        driver.findElement(By.id("com.cryptall:id/btn_profile_editing_next")).click();
	        Thread.sleep(40000);
	        String ExpectedResult = "Contacts";
	        SoftAssert Soft = new SoftAssert();
	       WebElement ActualResult = driver.findElement(By.name("Contacts"));
			Soft.assertEquals(ActualResult,ExpectedResult);
	        System.out.println("Soft Assertion ----> Passed");
	        Thread.sleep(10000);
	        
	        
	        
}

@AfterClass
public void tearDown() throws Exception {
//Close the app and simulator
	// TODO: Commented below to stop appium exit
	 driver.quit();
}
}



