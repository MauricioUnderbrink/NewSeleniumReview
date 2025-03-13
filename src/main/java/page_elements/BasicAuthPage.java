package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testcoreutils.WaitUtils;

public class BasicAuthPage {

    private WebDriver driver;
    private WaitUtils waitUtils;


    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector(".fa.fa-2x.fa-sign-in");


    public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }


    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

}
