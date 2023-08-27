package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AmazonLoginPage {
    private WebDriver driver;

    @FindBy(id = "ap_email")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement usernameButton;

    @FindBy(xpath = "//div[@class='a-box']")
    WebElement userEmail;
    @FindBy(id = "ap_password")
    private WebElement passwordInput;

    @FindBy(id = "signInSubmit")
    private WebElement loginButton;

    public AmazonLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }
    public void clickUsernameButton() {
        usernameButton.click();
    }

    public String getuseremail()
    {

        return userEmail.findElement(By.xpath("//div[@class='a-box']//span[contains(text(),'skamlesh1234@gmail.com')]")).getText(); }
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }





}