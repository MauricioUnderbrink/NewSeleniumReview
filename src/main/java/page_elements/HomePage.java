package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();

    }

    public AddRemoveElementsPage clickAddRemoveElements(){
        clickLink("Add/Remove Elements");
        return new AddRemoveElementsPage(driver);
    }

    public BasicAuthPage clickBasicAuthLink(){
        clickLink("Basic Auth");
        return new BasicAuthPage(driver);
    }

}
