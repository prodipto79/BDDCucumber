package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    //private static ThreadLocal<WebDriver> localDriverThread = new ThreadLocal<WebDriver>();
    OptionsManager optionsManager = new OptionsManager();
    private WebDriver driver;
    String currentDir = System.getProperty("user.dir");

    public WebDriver startDriver(String browser, String remoteRun) {


        String filePath = currentDir + "\\drivers\\";
        String driverPath = null;

        if (browser.equals("chrome")) {

            if (remoteRun.equalsIgnoreCase("Y")) {
                // remote run
                //	createRemoteDriver(browserName);

            } else {
                // local run
                driverPath = filePath + "chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", driverPath);
                //WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(optionsManager.getChromeOptions());
                //localDriverThread.set(driver);

            }

        } else if (browser.equals("firefox")) {
            if (remoteRun.equalsIgnoreCase("Y")) {
                // remote run
                //	createRemoteDriver(browserName);

            } else {
                // local run
                driverPath = filePath + "geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", driverPath);
                //WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
               // localDriverThread.set(driver);

            }
        }
        return driver;

    }
}
