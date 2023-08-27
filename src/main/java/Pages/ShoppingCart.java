package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCart {

private WebDriver driver;


@FindBy(tagName = "h1")
    WebElement heading;
@FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    WebElement itemcount;
@FindBy(id = "quantity")
    WebElement selectDropDown;
@FindBy(css = "input[value='Proceed to checkout']")
    WebElement proceedToBuy;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getHeading()
    {
      return  heading.getText();
    }
    public int getItemCount()
    {
       return Integer.parseInt(itemcount.getText());
    }
    public void clickDropDown()
    {
        Select select = new Select(selectDropDown);
        select.selectByIndex(1);
    }

    public void clickToBuy()
    {
        proceedToBuy.click();
    }

}
