package dev.camila.automation.pratice.selenium.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

public class RegisterPage extends ProductsPage {
	//Locators
//	private By tagH1Locator = By.cssSelector("#maincontainer > div > div > div > h1");
	private By userMenuLocator = By.xpath("//*[@id=\"customer_menu_top\"]/li/a");
	private By menuCartLocator = By.xpath("//*[@id=\"main_menu_top\"]/li[3]/a");
	private By btnCheckoutLocator = By.id("cart_checkout1");
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

	public static Faker faker = new Faker();
	public void clickContinueToRegister() {
		if(super.isDisplayed(btnContinueRegister)) {
			click(btnContinueRegister);
		} else {
			System.out.println("email textbox was not present");
		}
	}
	
	public void fillOutForm(Boolean validEmail) {
		this.clickContinueToRegister();
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		if(super.isDisplayed(firstNameLocator)) {
			super.type(String.valueOf(faker.name().firstName()), firstNameLocator);
			super.type(String.valueOf(faker.name().lastName()), lastNameLocator);
			String email = (validEmail) ? String.valueOf(faker.internet().emailAddress()) : "tester@camila.com";
			super.type(email, emailLocator);
			super.type(String.valueOf(faker.phoneNumber()), phoneLocator);
			super.type(String.valueOf(faker.phoneNumber()), faxLocator);
			super.type(String.valueOf(faker.business()), companyLocator);
			super.type(String.valueOf(faker.address()), address1Locator);
			super.type(String.valueOf(faker.address().secondaryAddress()), address2Locator);
			super.type(String.valueOf(faker.address().cityName()), cityLocator);
			super.selectByValue(countryLocator, "30");
			super.type(String.valueOf(faker.address().zipCode()), postCodeLocator);
			super.type(String.valueOf(faker.name().username()), loginNameLocator);
			String password = faker.internet().password(4,8);
			super.type(password, passwordLocator);
			super.type(password, passwordConfirmLocator);
			super.selectByValue(stateLocator, "456");
			super.click(newsletterLocator);
			super.click(privacyPolicyLocator);

			super.click(registerBtnLocator);
		} else {
			System.out.println("message was not found.");
		}
	}
	public void registerToBuy(Boolean immediatelyBuy) {
		super.visit("https://automationteststore.com/");
		super.addProductsInCart(immediatelyBuy); // apertar o checkout
		if (!immediatelyBuy) super.actionMoveToElementClickPerform(userMenuLocator);
		this.fillOutForm(true);
		super.signin();
		super.click(menuCartLocator);
		super.click(btnCheckoutLocator);
	}
	public String getWelcomeMessage() {
		super.waitVisibilityOfElementLocated(welcomeMessageLocator);
		return super.getText(welcomeMessageLocator);
	}
	public String getAlertError() {
		super.waitVisibilityOfElementLocated(alertErrorLocator);
		return super.getText(alertErrorLocator);
	}
//	public String getTagMessage() {
//		return super.getText(tagH1Locator);
//	}
}