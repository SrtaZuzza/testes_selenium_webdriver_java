## Automação de Testes com Selenium WebDriver e Java

O presente repositório tem como objetivo o estudo do **Selenium WebDriver**, uma das principais ferramentas de automação de páginas Web. A linguagem de programação escolhida foi **Java**, juntamente com o framework **JUnit** para auxiliar nossa automação e **Maven** para gerenciar nosso ambiente.

O site usado no projeto original [Automation Practice](http://automationpractice.com/) não existe mais, portanto minha escolha foi usar uma alternativa que se adequasse ao meu **nível de compreensão** das ferramentas e **objetivos de aprendizado**: o [Automation Test Store](https://automationteststore.com/). O mesmo foi excelente para que eu me mantivesse motivada e animada durante todo o processo.

Enquanto minha adaptação inicial do projeto original aborda esses processos:

| Test Case       | Description                                              |
|-----------------|----------------------------------------------------------|
| Register        | Register user with new email and nickname                |
| Login           | Login user with correct email and password               |
| Fragrances Page | Correctly access fragrances aimed at the female audience |

Esse repositório tem por objetivo ir além e seguir [essa lista de casos de teste](https://automationexercise.com/test_cases) segundo o que for possível dentro do site escolhido para esse projeto. Veja abaixo o andamento da implementação desses casos de teste:

|     | Test Case     | Description                                                           |
|-----|---------------|-----------------------------------------------------------------------|
| ✅   | Test Case 1:  | Register New User                                                     |
| ✅   | Test Case 2:  | Login User with correct email and password                            |
| ✅   | Test Case 3:  | Login User with invalid email and password                            |
| ✅   | Test Case 4:  | Logout User                                                           |
| ✅   | Test Case 5:  | Register User with existing email                                     |
| ✅   | Test Case 6:  | Contact Us Form                                                       |
| ⛔   | Test Case 7:  | Verify ~~Test Cases Page~~                                            |
| ✅   | Test Case 8:  | Verify ~~All Products~~ and product detail page                       |
| ✅   | Test Case 9:  | Search Product                                                        |
| ⛔   | Test Case 10: | Verify Subscription in home page (captcha)                            |
| ⛔   | Test Case 11: | Verify Subscription in Cart page (captcha)                            |
| ✅   | Test Case 12: | Add Product in Cart                                                   |
| ✅   | Test Case 13: | Verify Product quantity in Cart                                       |
| ✅   | Test Case 14: | Place Order: Register while Checkout                                  |
| ✅   | Test Case 15: | Place Order: Register before Checkout                                 |
| ✅   | Test Case 16: | Place Order: Login before Checkout                                    |
| ✅   | Test Case 17: | Remove Products From Cart                                             |
| ✅   | Test Case 18: | View Category Products                                                |
| ✅   | Test Case 19: | View & Cart Brand Products                                            |
| ✅   | Test Case 20: | Search Products and Verify Cart After Login                           |
| ⛔   | Test Case 21: | Add review on product (captcha)                                       |
| ✅   | Test Case 22: | Add to cart from Recommended items                                    |
| ✅   | Test Case 23: | Verify address details in checkout page                               |
| ✅   | Test Case 24: | Download Invoice after purchase order                                 |
| ✅   | Test Case 25: | Verify Scroll Up using 'Arrow' button and Scroll Down functionality   |
| ✅   | Test Case 26: | Verify Scroll Up without 'Arrow' button and Scroll Down functionality |       