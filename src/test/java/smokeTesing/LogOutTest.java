package smokeTesing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.AmazonHomePage;
import Pages.AmazonLoginPage;
import utils.BaseClass;

public class LogOutTest extends BaseClass {

	String LOGGED_IN_URL = "https://www.amazon.in";
	WebDriver driver;

	private AmazonHomePage homePage;
	private AmazonLoginPage loginPage;

	@BeforeClass
	void setup() {
		driver = initialize();
		homePage = new AmazonHomePage(driver);
		loginPage = new AmazonLoginPage(driver);
	}

	@Test
	void LogoutUser()
	{
		driver.get(LOGGED_IN_URL);
		  WebElement accountList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	        String accountText = accountList.getText();

	        if (accountText.contains("Hello, sign in")) {
	            // User is not logged in
	            System.out.println("No login detected.");
	            
	        } 
	        
	        else {
	            // User is logged in; proceed to log out
	            accountList.click(); // Click on the account link
	            WebElement signOutButton = driver.findElement(By.id("nav-item-signout"));
	            signOutButton.click(); // Click on the "Sign Out" button

	            // Verify that the user is successfully logged out
	            WebElement signInLink = driver.findElement(By.id("nav-link-accountList"));
	            String signInText = signInLink.getText();
	            if (signInText.contains("Hello, Sign in")) {
	                System.out.println("Logged out successfully.");
	                
	            } else {
	                System.out.println("Logout failed.");
	            }
	        }
		
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
