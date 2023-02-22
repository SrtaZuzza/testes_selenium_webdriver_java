package dev.camila.automation.pratice.selenium.tests;

import dev.camila.automation.pratice.selenium.pages.ContactPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactPageTest {
    ContactPage contactPage;
    private final String URL = "https://automationteststore.com/";
    private final String CONTACT_SUCCESS_URL = "https://automationteststore.com/index.php?rt=content/contact/success";

    @BeforeEach
    void setUp() throws Exception {
        this.contactPage = new ContactPage();
        this.contactPage.visit(this.URL);
    }
    @AfterEach
    void tearDown() throws Exception {
        this.contactPage.quitWebDriver();
    }
    @Test
    void fillContactUsForm() {
        this.contactPage.contactUsForm();
        Assertions.assertEquals("Your enquiry has been successfully sent to the store owner!\nContinue", this.contactPage.getEnquiryMessage());
        Assertions.assertEquals(this.CONTACT_SUCCESS_URL, contactPage.getCurrentUrl());
    }
}
