package dev.camila.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class ProductsPage extends LoginPage {
    //Locators
    private By searchFieldLocator = By.id("filter_keyword");
    private By btnInSearchLocator = By.xpath("//*[@id=\"search_form\"]/div/div");
    private By tagH1Locator = By.cssSelector("#maincontainer > div > div > div > h1");
    private By tagTestimonialsLocator = By.xpath("//*[@id=\"block_frame_html_block_1777\"]/h2");
    private By homepageProductLocator = By.xpath("//*[@id=\"block_frame_featured_1769\"]/div/div[1]/div[2]/a");
    private By productDescriptionLocator = By.id("productdesc");
    private By addToCartBtn = By.cssSelector("#product > fieldset > div:nth-child(4) > ul > li > a");
    private By menuCartLocator = By.xpath("//*[@id=\"main_menu_top\"]/li[3]/a");
    private By btnCheckoutLocator = By.id("cart_checkout1");

    public void searchProduct() {
        if(super.isDisplayed(searchFieldLocator)) {
            super.type("eye", searchFieldLocator);
            super.click(btnInSearchLocator);
        } else {
            System.out.println("search field was not found");
        }
    }
    public void addProductsInCart(Boolean immediatelyBuy) {
        super.waitVisibilityOfElementLocated(tagTestimonialsLocator);
        super.scrollPage(1000);
        super.actionMoveToElementClickPerform(homepageProductLocator);
        super.waitVisibilityOfElementLocated(productDescriptionLocator);
        super.actionMoveToElementClickPerform(addToCartBtn);
        if (immediatelyBuy) super.click(btnCheckoutLocator);
    }
    public void signinToBuy() {
        this.addProductsInCart(false);
        super.signin();
        super.click(menuCartLocator);
        super.click(btnCheckoutLocator);
    }
    public String getTagMessage() {
        return super.getText(tagH1Locator);
    }
}
