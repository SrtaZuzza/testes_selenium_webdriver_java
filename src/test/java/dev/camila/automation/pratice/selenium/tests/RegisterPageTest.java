package dev.camila.automation.pratice.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.camila.automation.pratice.selenium.pages.RegisterPage;

class RegisterPageTest {
	private RegisterPage registerPage;
	private final String URL = "https://automationteststore.com/index.php?rt=account/login";
	private final String CREATE_URL = "https://automationteststore.com/index.php?rt=account/create";
	private final String CHECKOUT_URL = "https://automationteststore.com/index.php?rt=checkout/confirm";

	@BeforeEach
	void setUp() throws Exception {
		this.registerPage = new RegisterPage();
		this.registerPage.visit(this.URL);
	}

	@AfterEach
	void tearDown() throws Exception {
//		this.registerPage.quitWebDriver();
	}

	@Test
	void goToRegisterPage() {
		//when
		this.registerPage.clickContinueToRegister();
		
		//then
		Assertions.assertNotEquals(this.URL, registerPage.getCurrentUrl());
	}
	
	@Test
	void registerNewUser() {
		//when
		this.registerPage.fillOutForm(true);
		
		//then
		String expected = "Your Account Has Been Created!".toUpperCase();
		String actual = this.registerPage.getWelcomeMessage();
		Assertions.assertEquals(expected, actual);
		
		String actualUrl = this.registerPage.getCurrentUrl();
		Assertions.assertNotEquals(this.URL, actualUrl);
	}

	@Test
	void emailAlreadyRegistered() {
		//when
		this.registerPage.fillOutForm(false);

		//then
		String expected = "×\nError: E-Mail Address is already registered!";
		String actual = this.registerPage.getAlertError();
		Assertions.assertEquals(expected, actual);

		String actualUrl = this.registerPage.getCurrentUrl();
		Assertions.assertEquals(this.CREATE_URL, actualUrl);
	}
	@Test // O signin sempre usa dados válidos
	void registerBeforeCheckout() {
		this.registerPage.registerToBuy(false);
		Assertions.assertEquals("CHECKOUT CONFIRMATION", this.registerPage.getTagMessage());
		Assertions.assertEquals(this.CHECKOUT_URL, registerPage.getCurrentUrl());
	}
	@Test // O signin sempre usa dados válidos
	void registerWhileCheckout() {
		this.registerPage.registerToBuy(true);
		Assertions.assertEquals("CHECKOUT CONFIRMATION", this.registerPage.getTagMessage());
		Assertions.assertEquals(this.CHECKOUT_URL, registerPage.getCurrentUrl());
	}

}
