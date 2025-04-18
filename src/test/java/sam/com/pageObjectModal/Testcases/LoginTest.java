package sam.com.pageObjectModal.Testcases;


import org.testng.annotations.Test;
import sam.com.common.BaseTest;
import sam.com.constants.constants.ConfigData;
import sam.com.constants.helpers.CaptureHelper;
import sam.com.constants.helpers.ExcelHelper;
import sam.com.pageObjectModal.Pages.LoginPage;

public class LoginTest extends BaseTest {
    //khởi tạo đối tương cho  page login
    LoginPage loginPage;


    @Test()
    public void loginSuccess() {
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginCMSSuccess();
    }

    @Test()
    public void loginFailWithEmailInvalid() {
        CaptureHelper.startRecord("loginFailWithEmailInvalid");
        ExcelHelper.getExcelHelper("Sheet 1");
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS(ExcelHelper.getExcelHelper("Sheet 1").getCellData("Email", 1), ExcelHelper.getExcelHelper("Sheet 1").getCellData("Password", 2));
        loginPage.verifyLoginCMSFail();
        CaptureHelper.stopRecord();
    }


    @Test()
    public void loginFailWithPasswordInvalid() {
        CaptureHelper.startRecord("loginFailWithPasswordInvalid");
        ExcelHelper.getExcelHelper("Sheet 1");
        loginPage = new LoginPage();
        loginPage.clickPopup();
        loginPage.loginCMS(ConfigData.EMAIL, ExcelHelper.getExcelHelper("Sheet 1").getCellData("Password", 1));
        loginPage.verifyLoginCMSFail();
        CaptureHelper.stopRecord();
    }

}
