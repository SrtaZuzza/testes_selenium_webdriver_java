package dev.camila.automation.pratice.selenium.tests;

import dev.camila.automation.pratice.selenium.pages.Scroll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScrollTest {
    private Scroll scroll;
    private final String URL = "https://automationteststore.com/";

    @BeforeEach
    void setUp() throws Exception {
        this.scroll = new Scroll();
        this.scroll.visit(this.URL);
    }
    @AfterEach
    void tearDown() throws Exception {
        this.scroll.quitWebDriver();
    }
    @Test
    void scrollUpUsingArrow() {
        Boolean result = this.scroll.scrollWithArrow();
        Assertions.assertEquals(true, result);
    }
    @Test
    void scrollUpWithoutUsingArrow() {
        Boolean result = this.scroll.scrollWithoutArrow();
        Assertions.assertEquals(true, result);
    }

}
