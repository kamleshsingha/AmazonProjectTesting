package utils;

import io.netty.handler.codec.http.multipart.FileUpload;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    ChromeOptions chromeOptions;
    WebDriver driver;
     static final Logger logger = LoggerFactory.getLogger("BaseClass.class");
@Test
    public WebDriver initialize()
    {


       System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


        chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Users\\kamlesh\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
     //   chromeOptions.setBrowserVersion();
       // DesiredCapabilities capabilities = new DesiredCapabilities();
    //    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

       ChromeDriver driver = new ChromeDriver(chromeOptions);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
     //   driver.get("htttp://www.google.com");
        return driver;
    }



    public void takescreenshot()
    {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(file, ""DestFile"")


    }
}
