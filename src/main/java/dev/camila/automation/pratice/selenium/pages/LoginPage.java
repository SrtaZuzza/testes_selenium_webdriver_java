package dev.camila.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	//Locators
	private By userMenuLocator = By.xpath("//*[@id=\"customer_menu_top\"]/li/a");
	private By loginNameLocator = By.name("loginname");
	private By passwordLocator = By.name("password");
	private By submitBtnLocator = By.xpath("//*[@id=\"loginFrm\"]/fieldset/button");
	private By tagMyAccountLocator = By.tagName("h1");
	private By alertErrorLocator = By.cssSelector("#maincontainer > div > div > div > div.alert.alert-error.alert-danger");
	private By notUserOptionLocator = By.xpath("//*[@id=\"customer_menu_top\"]/li/ul/li[10]/a");
	
	public void signIn() {
		super.waitVisibilityOfElementLocated(userMenuLocator);
		super.actionMoveToElementClickPerform(userMenuLocator);
		if(super.isDisplayed(loginNameLocator)) {
			super.type("Camila", loginNameLocator);
			super.type("1234@", passwordLocator);
			super.click(submitBtnLocator);
		} else {
			System.out.println("email textbox was not present");
		}
	}
	public void signIn(String username, String password) {
		super.waitVisibilityOfElementLocated(userMenuLocator);
		super.actionMoveToElementClickPerform(userMenuLocator);
		if(super.isDisplayed(loginNameLocator)) {
			super.type(username, loginNameLocator);
			super.type(password, passwordLocator);
			super.click(submitBtnLocator);
		} else {
			System.out.println("email textbox was not present");
		}
	}
	public void loginToLogout(){
		this.signIn();
		super.waitVisibilityOfElementLocated(tagMyAccountLocator);
		if(super.isDisplayed(userMenuLocator)) {
			super.actionMoveToElementPerform(userMenuLocator);
			super.actionMoveToElementClickPerform(notUserOptionLocator);
		} else {
			System.out.println("welcomeMessageLocator was not present");
		}
	}
	public String getMyAccountMessage() {
		return super.getText(tagMyAccountLocator);
	}

	public String getEmailAlertError() {
		super.waitVisibilityOfElementLocated(alertErrorLocator);
		return super.getText(alertErrorLocator);
	}

}
