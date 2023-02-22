package dev.camila.automation.pratice.selenium.tests;

import dev.camila.automation.pratice.selenium.pages.ProductsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductsPageTest {
    private ProductsPage productsPage;
    private final String URL = "https://automationteststore.com/";
    private final String CART_URL = "https://automationteststore.com/index.php?rt=checkout/cart";
    private final String CHECKOUT_URL = "https://automationteststore.com/index.php?rt=checkout/confirm";
    // private final String SUCCESS_URL = "https://automationteststore.com/index.php?rt=checkout/success";

    @BeforeEach
    void setUp() throws Exception {
        this.productsPage = new ProductsPage();
        this.productsPage.visit(this.URL);
    }
    @AfterEach
    void tearDown() throws Exception {
        this.productsPage.quitWebDriver();
    }
    @Test
    void successfullySearchProduct() {
        this.productsPage.searchProduct();
        Assertions.assertEquals("SEARCH", this.productsPage.getTagMessage());
        Assertions.assertNotEquals(this.URL, productsPage.getCurrentUrl());
    }
    @Test
    void verifyProductDetails() {
        this.productsPage.viewProduct();
//        Assertions.assertEquals("LATEST PRODUCTS", this.productsPage.getTagMessage());
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
        this.productsPage.signInToBuy();
        Assertions.assertEquals("CHECKOUT CONFIRMATION", this.productsPage.getTagMessage());
        Assertions.assertEquals(this.CHECKOUT_URL, productsPage.getCurrentUrl());
    }
    @Test
    void verifyProductQuantityInCart() {
        this.productsPage.addProductsInCart(false);
        Assertions.assertEquals("1", this.productsPage.verifyProductQuantity());
        Assertions.assertEquals(this.CART_URL, productsPage.getCurrentUrl());
    }
    @Test
    void removeProductFromCart() {
        this.productsPage.removeProduct();
        Assertions.assertEquals("Your shopping cart is empty!\nContinue", this.productsPage.getCartMessage());
        Assertions.assertEquals(this.CART_URL, productsPage.getCurrentUrl());
    }
    @Test
    void viewAndCartBrandProducts() {
        this.productsPage.addBrandProductsInCart();
        Assertions.assertEquals("1", this.productsPage.verifyProductQuantity());
        Assertions.assertEquals(this.CART_URL, productsPage.getCurrentUrl());
    }
    @Test
    void searchProductsAndVerifyCartAfterLogin() {
        this.productsPage.loginSearchAndBuy();
        Assertions.assertEquals("SHOPPING CART", this.productsPage.getTagMessage());
        Assertions.assertEquals(this.CART_URL, productsPage.getCurrentUrl());
    }
    @Test
    void addToCartFromRecommendedItems() {
        this.productsPage.addSpecialProductsInCart();
        Assertions.assertEquals("SHOPPING CART", this.productsPage.getTagMessage());
        Assertions.assertEquals(this.CART_URL, productsPage.getCurrentUrl());
    }
    @Test
    void verifyAddressDetailsInCheckoutPage() {
        String address = this.productsPage.verifyAddressInCheckout();
        Assertions.assertEquals("Street Name, 123 xxxxx\nRecife Pernambuco 12345\nBrazil", address);
        Assertions.assertEquals(this.CHECKOUT_URL, productsPage.getCurrentUrl());
    }
    @Test
    void downloadInvoiceAfterPurchaseOrder() {
        this.productsPage.downloadInvoice();
        Assertions.assertEquals("ORDER DETAILS", this.productsPage.getTagMessage());
        Assertions.assertNotEquals(this.URL, productsPage.getCurrentUrl());
//        Assertions.assertEquals("YOUR ORDER HAS BEEN PROCESSED!", this.productsPage.getTagMessage());
//        Assertions.assertEquals(this.SUCCESS_URL, productsPage.getCurrentUrl());
    }
}
