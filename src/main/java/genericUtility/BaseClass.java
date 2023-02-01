package genericUtility;

import enums.Browsers;
import enums.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v106.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.remote.Browser.CHROME;

public class BaseClass {
    public static Environment ENV = Environment.DEV;
    public static Browsers BR = Browsers.CHROME;
    public static WebDriver driver;
    public ChromeOptions chromeOptions;
    private PropertyFileUtility propLib = new PropertyFileUtility();

    @Parameters("Browser")
    @BeforeTest
    public void setUpBrowser() {
        switch (BR) {
            case CHROME -> {
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver();
            }
            case EDGE -> driver = new EdgeDriver();
            case FIREFOX -> driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void setENV() throws IOException {
        switch (ENV) {
            case DEV -> driver.get(propLib.getPropertyFileData("devBaseUrl"));
            case QA -> driver.get(propLib.getPropertyFileData("qaBaseUrl"));
            case STAGE -> driver.get(propLib.getPropertyFileData("stageBaseUrl"));
            case PROD -> driver.get(propLib.getPropertyFileData("prodBaseUrl"));
        }

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
