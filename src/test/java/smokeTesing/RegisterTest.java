package smokeTesing;
import Pages.AmazonHeadersTitleBar;
import Pages.AmazonHomePage;
import Pages.AmazonLoginPage;
import Pages.AmazonRegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseClass;

public class RegisterTest extends BaseClass {
    WebDriver driver;

    private AmazonHeadersTitleBar headersTitleBar;
    private AmazonLoginPage loginPage;
    private AmazonRegisterPage registerPage;

    @BeforeClass
    void setup() {
        driver = initialize();
       headersTitleBar = new AmazonHeadersTitleBar(driver);
        registerPage = new AmazonRegisterPage(driver);
    }

    @Test(priority = 1)
    void verifyPage_userRegistration() {
        driver.get("https://amazon.in");

        WebElement accoountAnddddList = headersTitleBar.getAccountAndList();

       Actions actions = new Actions(driver);

        Point offsets = accoountAnddddList.getLocation();
        int xOffset = offsets.getX();
        int yOffset = offsets.getY();
        actions.moveByOffset(xOffset,yOffset).perform();
        headersTitleBar.getStartHereElement().click();



        String title = registerPage.getPageTitle().getText();

        Assert.assertEquals(title, "Create Account");

    }

    @Test(priority = 2)
    void userRegistration() {

        registerPage.getCustomerName().sendKeys("Sontu Ponka");
        registerPage.getPhoneNumber().sendKeys("0000000000");
        registerPage.getEmail().sendKeys("abcdef@zxy.com");
        registerPage.getPassword().sendKeys("lappusasachinkyahaisachinme");
        registerPage.getContinueButton().click();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}