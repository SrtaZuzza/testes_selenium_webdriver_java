package dev.camila.automation.pratice.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTest {
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationteststore.com/index.php?rt=account/login");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() {
		WebElement emailAddressElement = driver.findElement(By.name("loginname"));
		emailAddressElement.sendKeys("Camila");
		
		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys("1234@");
		
		WebElement submitBtnElement = driver.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button"));
		submitBtnElement.click();
		
		WebElement tagMyAccount = driver.findElement(By.tagName("h1"));
		String textTagH1 = tagMyAccount.getText();

		Assertions.assertEquals("MY ACCOUNT Camila", textTagH1);
	}

}
