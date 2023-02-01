package orangeHRM;

import elementRepo.orangeHRM.LoginPage;
import genericUtility.BaseClass;
import genericUtility.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestData;

public class LoginTCs extends BaseClass {
    LoginPage loginPage;

    @Test()
    public void positiveCase1() {
        loginPage = new LoginPage(driver);
//            loginPage.doLogin(testData.userId, testData.password);
//            Assert.assertTrue(driver.getCurrentUrl().contains(testData.validMsg), testData.errorMsg);
    }

    @Test
    public void negativeCase1() {
        loginPage = new LoginPage(driver);
            loginPage.doLogin("1234", "Password123");
            Assert.assertTrue(loginPage.errorMsg().equalsIgnoreCase("Your username is invalid!"));

    }

    @Test
    public void negativeCase2() {
        loginPage = new LoginPage(driver);
            loginPage.doLogin("student", "admin1234");
            Assert.assertTrue(loginPage.errorMsg().equalsIgnoreCase("Your password is invalid!"));
        }
    }

