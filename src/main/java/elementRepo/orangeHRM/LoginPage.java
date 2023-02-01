package elementRepo.orangeHRM;

import genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameTF = By.id("username");
    By passwordTF = By.id("password");
    By loginBTN = By.id("submit");
    By loginErrorMsg = By.id("error");

    public LoginPage doLogin(String username, String password) {
        driver.findElement(usernameTF).sendKeys(username);
        driver.findElement(passwordTF).sendKeys(password);
        driver.findElement(loginBTN).click();
        return this;
    }
    public String errorMsg(){
        return driver.findElement(loginErrorMsg).getAttribute("textContent");
    }
}

