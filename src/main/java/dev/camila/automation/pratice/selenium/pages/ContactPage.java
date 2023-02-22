package dev.camila.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class ContactPage extends BasePage {
    private By tagH1Locator = By.cssSelector("#maincontainer > div > div > div > h1");
    private By tagTestimonialsLocator = By.xpath("//*[@id=\"block_frame_html_block_1777\"]/h2");
    private By contactUsLiLocator = By.xpath("//*[@id=\"footer\"]/footer/section[2]/div/div[1]/div/ul/li[5]/a");
    //Form Locators
    private By firstNameField = By.id("ContactUsFrm_first_name");
    private By emailField = By.id("ContactUsFrm_email");
    private By enquiryField = By.id("ContactUsFrm_enquiry");
    private By submitForm = By.xpath("//*[@id=\"ContactUsFrm\"]/div[2]/div[2]/button");
    private By enquiryMessage = By.cssSelector("#maincontainer > div > div > div > div");

    public void fillContactForm() {
        super.type("Camila", firstNameField);
        super.type("camila@tester.com", emailField);
        super.type("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", enquiryField);
    }
    public void contactUsForm() {
        super.waitVisibilityOfElementLocated(tagTestimonialsLocator);
        super.scrollPage("window.scrollBy(0,%d)", 3000);
        super.actionMoveToElementClickPerform(contactUsLiLocator);
        super.waitVisibilityOfElementLocated(tagH1Locator);
        this.fillContactForm();
        super.click(submitForm);
    }
    public String getEnquiryMessage() { return super.getText(enquiryMessage); }
}
