package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
    private WebDriver driver;
    @FindBy(id = "nav-link-accountList")
    private WebElement signInButton;

    @FindBy(css = ".nav-line-1-container")
    private WebElement username;
    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchbar;
    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchbutton;
    @FindBy(id = "nav-cart")
    private WebElement clickCart;
    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
    public String getUserName() { return username.getText();}
    public void getSearch(String item) {
        searchbar.click();
        searchbar.sendKeys(item);

    }

    public void clickSearchButton() {
        searchbutton.click();

    }   public WebElement clickOnCartIcon() {
        return clickCart;

    }
}
