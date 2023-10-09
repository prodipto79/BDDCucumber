package contextfactory;

import org.openqa.selenium.WebDriver;
import uitls.DBUtils;
import uitls.ExcelUtils;
import uitls.UIUtils;

public class TestContext {
    public String scenarioName;
    public String url;
    public WebDriver driver;
    public ExcelUtils excelUtils;
    public DBUtils dbUtils;
    public UIUtils uiUtils;

}
