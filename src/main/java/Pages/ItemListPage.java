package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemListPage {
   private WebDriver driver;


   @FindBy(xpath = "//img[@alt='Apple iPhone 13 (128GB) - Midnight'][1]")
    WebElement item  ;
    public ItemListPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);

    }


    public WebElement getitem()
    {
      return   item;

    }
}
