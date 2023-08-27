package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
private WebDriver driver;
    @FindBy(tagName ="h1")
    WebElement pageTitle  ;
  @FindBy(xpath ="//span[contains(text(),'House no 22,9th cross, 1st main,, Muneshwara nagar')]")
    WebElement selectAddress  ;
  @FindBy(id ="orderSummaryPrimaryActionBtn")
    WebElement buttonUseThisAddress  ;


    public Checkout(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

    public String getPageTitle()
    {
        return pageTitle.getText();

    }

    public void selectAddress()
    {
        if(!selectAddress.isSelected()) {
            selectAddress.click();
        }

    } public void clickButtonUseThisAddress()
    {
       buttonUseThisAddress.click();

    }
}
