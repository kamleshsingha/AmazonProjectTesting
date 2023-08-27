package smokeTesing;

import Pages.AmazonHomePage;
import Pages.AmazonLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

public class LoginTest extends BaseClass {

    private WebDriver driver;
    private AmazonHomePage homePage;
    private AmazonLoginPage loginPage;
//    @BeforeClass
//    public void setUp() {
//        driver =   initialize();
//        homePage = new AmazonHomePage(driver);
//        loginPage = new AmazonLoginPage(driver);
//    }
    @Test(dataProvider = "logindata")
    public void testUserLogin(String username, String password) throws InterruptedException {
        driver =   initialize();
        homePage = new AmazonHomePage(driver);
        loginPage = new AmazonLoginPage(driver);
        driver.get("https://www.amazon.in");
        homePage.clickSignInButton();
        loginPage.enterUsername(username);
        loginPage.clickUsernameButton();
// Assert that email/phone is same
      //  Assert.assertEquals(loginPage.getuseremail(), "skamlesh1234@gmail.com");
        //  Thread.sleep(5000);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        // Assert that login was successful
        String uname = homePage.getUserName();
    //    Assert.assertEquals(uname, "Hello, kamlesh");

        // For example, after successful login, you might assert the user's name is displayed.
        WebElement accountName = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
     //   Assert.assertEquals(accountName.getText(), "Hello, kamlesh");
        driver.close();
    }


@DataProvider(name = "logindata")
public Object[][] getuUname_pass()
{

    return new Object[][]{
            {"skamlesh1234@gmail.com","hancythefancy"},
            {"skamlesh1234@gmail.com","hancythefancy"}

    };
} @AfterClass
    public void tearDown() {
        driver.quit();
    }
        }