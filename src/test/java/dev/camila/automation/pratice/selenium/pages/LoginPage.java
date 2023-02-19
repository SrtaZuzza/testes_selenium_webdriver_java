package dev.camila.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	//Locators
	private By loginNameLocator = By.name("loginname");
	private By passwordLocator = By.name("password");
	private By submitBtnLocator = By.xpath("//*[@id=\"loginFrm\"]/fieldset/button");
	private By tagMyAccountLocator = By.tagName("h1");
	
	
	public void signin() {
		if(super.isDisplayed(loginNameLocator)) {
			super.type("Camila", loginNameLocator);
			super.type("1234@", passwordLocator);
			super.click(submitBtnLocator);
		} else {
			System.out.println("email textbox was not present");
		}
	}
	
	public String getMyAccountMessage() {
		return super.getText(tagMyAccountLocator);
	}

}
