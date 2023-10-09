package stepDef;

import constant.AppData;
import contextfactory.TestContext;
import org.openqa.selenium.WebDriver;
import uitls.DBUtils;
import uitls.ExcelUtils;
import uitls.UIUtils;

public class BaseTest {

    public ExcelUtils excelUtils;
    public DBUtils dbUtils;
    public UIUtils uiUtils;
    TestContext testContext;
    public BaseTest(TestContext testContext){

        excelUtils = new ExcelUtils();
        dbUtils = new DBUtils();
        this.testContext = testContext;
        uiUtils = new UIUtils(testContext);
    }


    public ExcelUtils getExcelUtilObj(){
        return excelUtils;
    }

    public DBUtils getDBUtilObj(){
        return dbUtils;
    }

    public UIUtils getUIUtilObj(){
        return uiUtils;
    }

}
