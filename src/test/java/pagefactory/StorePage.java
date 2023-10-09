package pagefactory;

import contextfactory.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDef.BaseTest;
import uitls.ExcelUtils;
import uitls.UIUtils;

public class StorePage  {

     By storelink = By.xpath("(.//a[text()='Store'])[1]");
     By addToCart = By.xpath("(.//a[text()='Add to cart'])[1]");
     By cartValue = By.xpath("(.//a[@title='View your shopping cart']//span)[1]");
     private UIUtils uiUtils;

    private WebDriver driver;
    private TestContext testContext;

    public StorePage(TestContext testContext){


        this.testContext = testContext;
        driver = testContext.driver;
        uiUtils = testContext.uiUtils;
    }

    public void clickStoreLink(){

        uiUtils.click(storelink, "Store Link");
    }

    public void clickAddToCart() throws InterruptedException {
        Thread.sleep(2000);
        uiUtils.click(addToCart,"Add To Cart Link");
    }

    public String getOneProduct() throws InterruptedException {
        Thread.sleep(2000);
        return uiUtils.getText(cartValue, "cart value");
    }

}
