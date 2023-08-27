package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonRegisterPage {

    private WebDriver driver;
    @FindBy(xpath = "//h1[contains(text(),'Create Account')]")
    private WebElement pageTitle;
    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement customerName;

    @FindBy(xpath = "//input[@id='ap_phone_number']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement password;

    public WebElement getContinueButton() {
        return continueButton;
    }

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    public AmazonRegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public WebElement getPageTitle() {
      return   pageTitle;

    }

    public WebElement getCustomerName() {
        return customerName;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }
}
