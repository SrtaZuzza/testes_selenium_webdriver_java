package dev.camila.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class Scroll extends BasePage {
    private By headerLogoLocator = By.className("header-logo");
    private By tagTestimonialsLocator = By.xpath("//*[@id=\"block_frame_html_block_1777\"]/h2");
    private By scrollBtnLocator = By.xpath("//*[@id=\"gotop\"]");
    public Boolean scrollWithArrow() {
        super.waitVisibilityOfElementLocated(headerLogoLocator);
        super.scrollPage("window.scrollBy(0,%d)", 3000);
        super.click(scrollBtnLocator);
        return isDisplayed(headerLogoLocator);
    }
    public Boolean scrollWithoutArrow() {
        super.waitVisibilityOfElementLocated(headerLogoLocator);
        super.scrollPage("window.scrollBy(0,%d)", 3000);
        super.waitVisibilityOfElementLocated(tagTestimonialsLocator);
        super.scrollPage("window.scrollBy(%d, 0)", 3000);
        return isDisplayed(headerLogoLocator);
    }
}
