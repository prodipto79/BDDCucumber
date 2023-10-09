package uitls;

import contextfactory.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UIUtils {

    TestContext testContext;
    WebDriver driver;
    WebDriverWait webdriverWait;
    public UIUtils(TestContext testContext){
        this.testContext = testContext;
        driver = testContext.driver;
        webdriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void click(By locator, String objectName)  {
        webdriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        System.out.println("Store link clicked ");
    }

    public String getText(By locator, String objectName){
        webdriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String value =  driver.findElement(locator).getText();
        System.out.println("get the text " + value);
        return value;
    }

}
