package regressionTesting;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class AmazonEndToEndTest extends BaseClass {
    private Actions actions;
      private WebDriver driver;
    private AmazonHomePage homePage;
    private AmazonLoginPage loginPage;
    private ItemListPage itemListPage;
    private ShoppingCart shoppingCart;
    private Checkout checkout;
     private ItemPage itemPage;
    @BeforeClass
    public void setUp() {
     driver =   initialize();
        homePage = new AmazonHomePage(driver);
        loginPage = new AmazonLoginPage(driver);
        itemListPage = new ItemListPage(driver);
        itemPage = new ItemPage(driver);
        shoppingCart = new ShoppingCart(driver);
        checkout = new Checkout(driver);
    }

    @Test(priority = 1)
    public void testUserLogin() throws InterruptedException {
        driver.get("https://www.amazon.in");
        homePage.clickSignInButton();
        loginPage.enterUsername("skamlesh1234@gmail.com");
        loginPage.clickUsernameButton();
// Assert that email/phone is same
        Assert.assertEquals( loginPage.getuseremail(),"skamlesh1234@gmail.com");
      //  Thread.sleep(5000);
        loginPage.enterPassword("hancythefancy");
        loginPage.clickLoginButton();
        // Assert that login was successful
       String uname = homePage.getUserName();
      Assert.assertEquals(uname ,"Hello, kamlesh");

        // For example, after successful login, you might assert the user's name is displayed.
        WebElement accountName = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
         Assert.assertEquals(accountName.getText(), "Hello, kamlesh");
    }

    // Searching items in searchbar and adding it in the cart
    @Test(priority = 2)
    void searchAndAddToCart() throws InterruptedException {
        String originalWindow = driver.getWindowHandle();
        homePage.getSearch("iphone 13");
        homePage.clickSearchButton();
//Get Current Windowandle
        String parentwindow = driver.getWindowHandle();
        Thread.sleep(1000);
//select item iphone 13 from the list
        WebElement productLink =  itemListPage.getitem();
        productLink.click();
      Set<String> windowhandles = driver.getWindowHandles();
        for (String handle: windowhandles) {

            if(!handle.equals(parentwindow))
            {
                driver.switchTo().window(handle);
                String itemTitle=  itemPage.getItemTitle();
                Assert.assertEquals(itemTitle,"Apple iPhone 13 (128GB) - Midnight");
            }
        }
        itemPage.clickItemAddToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.id("attach-added-to-cart-alert-and-image-area"))));
        Assert.assertTrue(confirmationMessage.getText().contains("Added to Cart"));
         itemPage.closeCartBar();


    }

@Test(priority = 3)
    void viewAndUpdateCart()
    {
        if(driver.findElement(By.xpath("//a[contains(text(),'Go to Cart')]")).isDisplayed())
        {
            driver.findElement(By.xpath("//a[contains(text(),'Go to Cart')]")).click();
        }
        else {
            homePage.clickOnCartIcon();
            String heading = shoppingCart.getHeading();
            Assert.assertEquals(heading,"Shopping Cart");
        }

      int count =  shoppingCart.getItemCount();

        if(count!=1)
        {
            shoppingCart.clickDropDown();
            shoppingCart.clickToBuy();


            Assert.assertEquals(checkout.getPageTitle(),"Checkout");
        }


    }


    //proceed to checkout
    @Test(priority = 4)
    public void proceedToCheckOut() {

        checkout.selectAddress();
        checkout.clickButtonUseThisAddress();

    }

    // Implement other test cases using Page Objects in a similar way

    @AfterClass
    public void tearDown() {
     driver.quit();
    }

}



