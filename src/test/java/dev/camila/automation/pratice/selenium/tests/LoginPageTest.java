package dev.camila.automation.pratice.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.camila.automation.pratice.selenium.pages.LoginPage;

class LoginPageTest {
	private LoginPage loginPage;
	private final String URL = "https://automationteststore.com/";
	private final String LOGIN_URL = "https://automationteststore.com/index.php?rt=account/login";
	private final String LOGOUT_URL = "https://automationteststore.com/index.php?rt=account/logout";

	@BeforeEach
	void setUp() throws Exception {
		this.loginPage = new LoginPage();
		this.loginPage.visit(this.URL);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.loginPage.quitWebDriver();
	}

	@Test
	void loginUserWithCorrectEmailAndPassword() {
		//when
		this.loginPage.signIn();
		
		//then
		Assertions.assertEquals("MY ACCOUNT Camila", this.loginPage.getMyAccountMessage());
		Assertions.assertNotEquals(this.loginPage.getCurrentUrl(), this.URL);
	}
	@Test
	void LoginUserWithInvalidEmailAndPassword() {
		//when
		this.loginPage.signIn("£¢¬", "£¢¬");

		//then
		String expected = "×\nError: Incorrect login or password provided.";
		String actual = this.loginPage.getEmailAlertError();
		Assertions.assertEquals(expected, actual);
		Assertions.assertEquals(this.loginPage.getCurrentUrl(), this.LOGIN_URL);
	}
	@Test
	void logoutUser() {
		//when
		this.loginPage.loginToLogout();

		//then
		Assertions.assertEquals("ACCOUNT LOGOUT", this.loginPage.getMyAccountMessage());
		Assertions.assertEquals(this.loginPage.getCurrentUrl(), this.LOGOUT_URL);
	}
	@Test
	void loginBeforeCheckout() {
		//when
		this.loginPage.signIn();

		//then

	}
}
