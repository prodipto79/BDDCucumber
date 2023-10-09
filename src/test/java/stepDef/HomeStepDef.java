package stepDef;

import constant.AppData;
import contextfactory.TestContext;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class HomeStepDef  {

    public TestContext testContext;
    private WebDriver  driver;
    private String url;

    public HomeStepDef(TestContext testContext){
       this.testContext = testContext;

        driver = testContext.driver;
        url = testContext.url;
    }
    @Given("invoke the application")
    public void invokeTheApplication() throws InterruptedException {

        System.out.println("Invoke the application " + url);
        driver.get(url);
        Thread.sleep(AppData.smallWait);
        driver.manage().window().maximize();
        Thread.sleep(AppData.smallWait);
    }
}
