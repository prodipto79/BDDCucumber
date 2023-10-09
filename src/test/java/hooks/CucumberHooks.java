package hooks;

import configfactory.PropertyLoader;
import constant.AppData;
import contextfactory.TestContext;
import driverfactory.DriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import stepDef.BaseTest;
import uitls.DBUtils;
import uitls.ExcelUtils;
import uitls.UIUtils;

public class CucumberHooks {

     public String configFileName = "config.properties";
     private  PropertyLoader  configProperties;
     private DriverManager driverManager;
     private  TestContext context;
     private WebDriver driver;
     private BaseTest baseTest;

     private ExcelUtils excelUtils;
     private DBUtils dbUtils;
     private UIUtils uiUtils;
     public CucumberHooks(TestContext context){
         this.context = context;
     }


    @Before
    public void beforeHook(Scenario scenario) throws InterruptedException {
        String env;
        context.scenarioName = scenario.getName();
        System.out.println("BEFORE HOOK");
        configProperties = new PropertyLoader(configFileName);
        driverManager = new DriverManager();

        String remoreRun = configProperties.getRemoteRun();
        driver = driverManager.startDriver( System.getProperty("browser","chrome"),remoreRun);
        context.driver = driver;

        excelUtils = new ExcelUtils();
        context.excelUtils = excelUtils;
        dbUtils = new DBUtils();
        context.dbUtils = dbUtils;
        uiUtils = new UIUtils(context);
        context.uiUtils = uiUtils;

        Thread.sleep(AppData.smallWait);
        env = configProperties.getEnv().toString();
        switch(env){
            case "QA":
                context.url = configProperties.getQABaseUrl();
                break;
            case "PROD":
                context.url = configProperties.getProdBaseUrl();
                break;
            default:
        }
    }

    @After
    public void afterHook(){

        System.out.println("AFTER HOOK");
        driver.quit();
        driverManager = null;

    }
    @BeforeAll
    public static void beforeAllHook(){

        System.out.println("BEFORE All HOOK");
        System.out.println("DataBase Connection Estabilishment");
    }

    @AfterAll
    public static void afterAllHook(){

        System.out.println("AFTER All HOOK");
        System.out.println("DataBase End Connection Done");
    }

    @AfterStep
    public void addScreenshots(Scenario scenario){
      //  if(scenario.isFailed()){
         //    {
                 driver = context.driver;
                 final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                 // attche image file to report
                 scenario.attach(screenshot,"image/png", scenario.getName());
            // }
        // }
    }


}
