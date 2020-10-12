package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int TIMEOUT = 5; //seconds
    private static final int POLLING = 100; //milliseconds
    protected WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }
}