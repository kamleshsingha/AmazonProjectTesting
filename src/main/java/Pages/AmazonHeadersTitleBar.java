package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHeadersTitleBar {

    private WebDriver driver;



    @FindBy(xpath = "//a[@data-nav-ref='nav_ya_signin']")
    private WebElement AccountAndList;


    @FindBy(xpath = "//a[contains(text(),'Start here.')]")
    private WebElement startHereElement;

    public AmazonHeadersTitleBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public WebElement getAccountAndList() {
        return AccountAndList;
    }
    public WebElement getStartHereElement() {
        return startHereElement;
    }

}
