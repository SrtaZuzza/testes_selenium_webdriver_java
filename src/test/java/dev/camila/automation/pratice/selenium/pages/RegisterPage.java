package dev.camila.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
	//Locators
	private By btnContinueRegister = By.cssSelector("#accountFrm > fieldset > button");
	private By alertAdditionalInformationLocator = By.xpath("//*[@id=\"AccountFrm\"]/div[5]/div");
	//Locators YOUR PERSONAL INFORMATION
	private By firstNameLocator = By.name("firstname");
	private By lastNameLocator = By.name("lastname");
	private By emailLocator = By.name("email");
	private By phoneLocator = By.name("telephone");
	private By faxLocator = By.name("fax");
	//Locators YOUR ADDRESS
	private By companyLocator = By.name("company");
	private By address1Locator = By.name("address_1");
	private By address2Locator = By.name("address_2");
	private By cityLocator = By.name("city");
	private By stateLocator = By.name("zone_id");
	private By postCodeLocator = By.name("postcode");
	private By countryLocator = By.name("country_id");
	//Locators LOGIN DETAILS
	private By loginNameLocator = By.name("loginname");
	private By passwordLocator = By.name("password");
	private By passwordConfirmLocator = By.name("confirm");
	//Locators NEWSLETTER
	private By newsletterLocator = By.id("AccountFrm_newsletter0");
	private By privacyPolicyLocator = By.id("AccountFrm_agree");
	//Locators SUBMIT
	private By registerBtnLocator = By.cssSelector("#AccountFrm > div.form-group > div > div > button");
	private By welcomeMessageLocator = By.className("maintext");
	private By alertErrorLocator = By.cssSelector("#maincontainer > div > div > div > div.alert.alert-error.alert-danger");
	
	
	public void clickContinueToRegister() {
		if(super.isDisplayed(btnContinueRegister)) {
			click(btnContinueRegister);
		} else {
			System.out.println("email textbox was not present");
		}
	}
	
	public void fillOutForm() {
		this.clickContinueToRegister();
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		if(super.isDisplayed(firstNameLocator)) {
			super.type("Camila", firstNameLocator);
			super.type("Cavalcante", lastNameLocator);
			super.type("camila@tester.com", emailLocator);
			super.type("99999999", phoneLocator);
			super.type("99999999", faxLocator);
			super.type("DIO", companyLocator);
			super.type("Street Name, 123", address1Locator);
			super.type("xxxxx", address2Locator);
			super.type("Recife", cityLocator);
			super.selectByValue(countryLocator, "30");
			super.type("12345", postCodeLocator);
			super.type("camilaTester", loginNameLocator);
			super.type("1234@", passwordLocator);
			super.type("1234@", passwordConfirmLocator);
			super.selectByValue(stateLocator, "456");
			super.click(newsletterLocator);
			super.click(privacyPolicyLocator);

			super.click(registerBtnLocator);
		} else {
			System.out.println("message was not found.");
		}
	}
	
	public String getWelcomeMessage() {
		super.waitVisibilityOfElementLocated(welcomeMessageLocator);
		return super.getText(welcomeMessageLocator);
	}
	public String getAlertError() {
		super.waitVisibilityOfElementLocated(alertErrorLocator);
		return super.getText(alertErrorLocator);
	}

}
