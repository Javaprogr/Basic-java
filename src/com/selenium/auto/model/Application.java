package com.selenium.auto.model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.auto.model.Repository;

public class Application 
{
	public void login(WebDriver driver,String username,String password)
	{
		driver.findElement(By.xpath(Repository.username)).sendKeys(username);
		driver.findElement(By.xpath(Repository.password)).sendKeys(password);
		driver.findElement(By.linkText(Repository.login_button)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void logout(WebDriver driver)
	{
		driver.findElement(By.xpath(Repository.logout)).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}
}