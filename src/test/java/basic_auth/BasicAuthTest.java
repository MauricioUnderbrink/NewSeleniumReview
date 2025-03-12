package basic_auth;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcoreutils.WaitsUtils;

public class BasicAuthTest extends BaseTest {
    WaitsUtils waitsUtils;
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        setUp("chrome");
        this.waitsUtils = new WaitsUtils(driver);

    }
    @BeforeMethod
    public void goToHomePage() {
        navigateToHomePage();
    }

    @Test
    public void sendUserNameToAlert(){

        var basicAuthPage = homePage.clickBasicAuthLink();

        basicAuthPage.addUserName("user");


    }

}
