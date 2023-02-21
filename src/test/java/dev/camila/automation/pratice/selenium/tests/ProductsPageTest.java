package dev.camila.automation.pratice.selenium.tests;

import dev.camila.automation.pratice.selenium.pages.ProductsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductsPageTest {
    private ProductsPage productsPage;
    private final String URL = "https://automationteststore.com/";
    private final String CHECKOUT_URL = "https://automationteststore.com/index.php?rt=checkout/confirm";

    @BeforeEach
    void setUp() throws Exception {
        this.productsPage = new ProductsPage();
        this.productsPage.visit(this.URL);
    }
    @AfterEach
    void tearDown() throws Exception {
//        this.productsPage.quitWebDriver();
    }
    @Test
    void successfullySearchProduct() {
        this.productsPage.searchProduct();
        Assertions.assertEquals("SEARCH", this.productsPage.getTagMessage());
        Assertions.assertNotEquals(this.URL, productsPage.getCurrentUrl());
    }
    @Test
    void successfullyAddProductToCart() {
        this.productsPage.addProductsInCart(false);
        Assertions.assertEquals("SHOPPING CART", this.productsPage.getTagMessage());
        Assertions.assertNotEquals(this.URL, productsPage.getCurrentUrl());
    }
    @Test
    void successfullyLoginBeforeCheckout() {
        this.productsPage.signinToBuy();
        Assertions.assertEquals("CHECKOUT CONFIRMATION", this.productsPage.getTagMessage());
        Assertions.assertEquals(this.CHECKOUT_URL, productsPage.getCurrentUrl());
    }

}
