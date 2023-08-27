package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {


    private WebDriver driver;

    @FindBy(xpath = "//span[@id='productTitle']")
    WebElement itemTitle  ;
    @FindBy(id = "add-to-cart-button")
    WebElement addToCart  ;
    @FindBy(xpath ="//a[@id ='attach-close_sideSheet-link']")
    WebElement closCartbar  ;
     @FindBy(xpath ="//input[@name='proceedToRetailCheckout']")
    WebElement proceddToBuy  ;


    public ItemPage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

    public String getItemTitle()
    {
       return itemTitle.getText();

    }

    public void  clickItemAddToCart() {
        addToCart.click();
    }
        public void  closeCartBar() {
        closCartbar.click();

    }   public void  ClickProceedToBuy() {
        proceddToBuy.click();

    }
}
