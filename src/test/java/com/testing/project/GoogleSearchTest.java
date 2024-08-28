package com.testing.project;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com.mx");
	}
	
	@Test
	public void testGooglePage() {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.clear();
		searchBox.sendKeys("GitHub");
		searchBox.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(driver -> driver.getTitle().toLowerCase().startsWith("github"));
		
		assertEquals("GitHub - Buscar con Google", driver.getTitle());
		
		try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
