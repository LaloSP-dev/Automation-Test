package com.testing.project;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunner {

	private WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.iztapalapa.uam.mx/");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {

		WebElement searchBox = driver.findElement(By.name("q"));

//		searchBox.clear();
//		searchBox.sendKeys("GitHub");
//		searchBox.submit();

		// Wait for the page title to update
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(driver -> driver.getTitle().toLowerCase().startsWith("uam"));

		// Verify that the title page is as expected
		assertEquals("UAM-Iztapalapa", driver.getTitle());

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
