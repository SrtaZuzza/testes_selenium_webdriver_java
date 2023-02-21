package dev.camila.automation.pratice.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.camila.automation.pratice.selenium.pages.FragrancesPage;

class FragrancesPageTest {
	private FragrancesPage fragrancesPage;
	private final String URL = "https://automationteststore.com/";

	@BeforeEach
	void setUp() throws Exception {
		this.fragrancesPage = new FragrancesPage();
		this.fragrancesPage.visit(this.URL);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.fragrancesPage.quitWebDriver();
	}

	@Test
	void showFragrancesForWomen() {
		//when
		this.fragrancesPage.viewWomenFragrancesPage();
		
		//then
		Assertions.assertEquals("Women".toUpperCase(), this.fragrancesPage.getTitlePage());
		Assertions.assertNotEquals(this.URL, fragrancesPage.getCurrentUrl());
	}
}
