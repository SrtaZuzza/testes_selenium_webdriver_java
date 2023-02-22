package dev.camila.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

import java.time.Duration;

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
    private By quantityNumber = By.xpath("//*[@id=\"cart_quantity58\"]");
    private By removeBtnLocator = By.cssSelector("#cart > div > div.container-fluid.cart-info.product-list > table > tbody > tr:nth-child(2) > td:nth-child(7) > a");
    private By shoppingCartMessage = By.cssSelector("#maincontainer > div > div > div > div");
    private By brandListLocator = By.xpath("//*[@id=\"brandcarousal\"]/li[1]/div[1]/a");
    private By addBrandToCartBtn = By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[2]/div[2]/div[3]/a");
    private By homeBtnLocator = By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[1]/a");
    private By specialsBtnLocator = By.xpath("//*[@id=\"main_menu\"]/li[1]/a");
    private By conditionerLocator = By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[9]/div[2]/a");
    private By eyeProductLocator = By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[4]/div[2]/a");
    private By addressDetailsLocator = By.xpath("//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/table[1]/tbody/tr/td[2]/address");
    private By confirmOrderLocator = By.cssSelector("#checkout_btn");
    private By invoiceLinkLocator = By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]/a");

    public void searchProduct() {
        if(super.isDisplayed(searchFieldLocator)) {
            super.type("eye", searchFieldLocator);
            super.click(btnInSearchLocator);
        } else {
            System.out.println("search field was not found");
        }
    }
    public void viewProduct() {
        super.waitVisibilityOfElementLocated(tagTestimonialsLocator);
        super.scrollPage("window.scrollBy(0,%d)", 1000);
        super.actionMoveToElementClickPerform(homepageProductLocator);
        super.waitVisibilityOfElementLocated(productDescriptionLocator);
    }
    public void addProductsInCart(Boolean immediatelyBuy) {
        this.viewProduct();
        super.actionMoveToElementClickPerform(addToCartBtn);
        if (immediatelyBuy) super.click(btnCheckoutLocator);
    }
    public void addBrandProductsInCart() {
        super.scrollPage("window.scrollBy(0,%d)", 3000);
        super.click(brandListLocator);
        super.scrollPage("window.scrollBy(0,%d)", 350);
        super.click(addBrandToCartBtn);
        super.click(menuCartLocator);
    }
    public void addSpecialProductsInCart() {
        super.actionMoveToElementPerform(homeBtnLocator);
        super.actionMoveToElementClickPerform(specialsBtnLocator);
        if (super.isDisplayed(tagH1Locator)) {
            super.actionMoveToElementClickPerform(conditionerLocator);
            super.actionMoveToElementClickPerform(addToCartBtn);
        }
    }
    public String verifyAddressInCheckout() {
        this.signInToBuy();
        return super.getText(addressDetailsLocator);
    }
    public void removeProduct() {
        this.addProductsInCart(false);
        super.click(removeBtnLocator);
    }
    public void signInToBuy() {
        super.signIn();
        super.visit("https://automationteststore.com/");
        this.addProductsInCart(true);
    }
    public String verifyProductQuantity() {
        super.waitVisibilityOfElementLocated(btnCheckoutLocator);
        return super.getAttribute(quantityNumber);
    }
    public void loginSearchAndBuy() {
        super.signIn();
        this.searchProduct();
        super.click(eyeProductLocator);
        super.actionMoveToElementClickPerform(addToCartBtn);
//        super.click(menuCartLocator);
    }
    public void downloadInvoice() {
        this.signInToBuy();
        super.actionMoveToElementClickPerform(confirmOrderLocator);
        super.waitVisibilityOfElementLocated(invoiceLinkLocator, Duration.ofSeconds(5));
        super.actionMoveToElementClickPerform(invoiceLinkLocator);
    }
    public String getCartMessage() { return super.getText(shoppingCartMessage); }
    public String getTagMessage() { return super.getText(tagH1Locator); }
}
