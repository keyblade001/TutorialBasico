package Paginas;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    static Logger log = LoggerFactory.getLogger(BasePage.class);
    public static WebDriver driver;
    private static WebDriverWait wait;

    static {
        System.setProperty("webdriver.chrome.driver", "/Users/emilianorodriguez/Downloads/chromedriver 3");
        driver = new ChromeDriver();
         wait = new WebDriverWait(driver, 10);
    }

    public BasePage(WebDriver driver)  {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static void closeBrowser() { driver.quit(); }

    public static void navigateTo(String url)  {  driver.get(url);  }

    private WebElement Find (String locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(locator))));
    }

    public void clickElement(String locator)
    {  Find(locator).clear(); }

    public void sendKeysTo(String locator, String keysToSend) {
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }
}