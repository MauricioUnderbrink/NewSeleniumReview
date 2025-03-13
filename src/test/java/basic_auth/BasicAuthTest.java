package basic_auth;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcoreutils.WaitUtils;

public class BasicAuthTest extends BaseTest {
    WaitUtils waitUtils;
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        setUp("chrome");
        this.waitUtils = new WaitUtils(driver);

    }
    @BeforeMethod
    public void goToHomePage() {
        navigateToHomePage();
    }

    @Test
    public void sendUserNameToAlert(){

        var basicAuthPage = homePage.clickBasicAuthLink();

        //basicAuthPage.addUserName("user");


    }

}
