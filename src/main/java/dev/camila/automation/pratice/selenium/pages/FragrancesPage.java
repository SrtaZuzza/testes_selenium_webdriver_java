package dev.camila.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class FragrancesPage extends BasePage {
	//Locators
	private By menuFragranceLocator = By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[5]/a");
	private By submenuFragranceLocator = By.cssSelector("#categorymenu > nav > ul > li:nth-child(5) > div > ul:nth-child(1) > li:nth-child(2) > a");
	private By titleFragrancesPageLocator = By.tagName("h1");
	
	public void viewWomenFragrancesPage() {
		if(super.isDisplayed(menuFragranceLocator)) {
			super.actionMoveToElementPerform(menuFragranceLocator);
			super.actionMoveToElementClickPerform(submenuFragranceLocator);
		} else {
			System.out.println("fragrances was not found");
		}
	}
	
	public String getTitlePage() {
		return super.getText(titleFragrancesPageLocator);
	}

}
