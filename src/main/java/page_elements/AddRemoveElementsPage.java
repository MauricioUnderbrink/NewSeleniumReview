package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcoreutils.WaitUtils;

import java.util.List;

public class AddRemoveElementsPage {

    private WebDriver driver;
  private WaitUtils waitUtils;

    private By addElementButton = By.xpath("//button[@onclick='addElement()']");

    private By deleteElementButton = By.xpath("//button[@onclick = 'deleteElement()']");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
      this.waitUtils = new WaitUtils(driver);


    }

    public void clickAddButton(){
        waitUtils.waitForElementToBeClickable(addElementButton,10).click();
    }

    public WebElement deleteButtonElement(){
        return driver.findElement(deleteElementButton);
    }

    public By deleteButtonLocator(){
        return deleteElementButton;
    }

    public void clickDeleteButton(){
       waitUtils.fluentWaitForElement(deleteElementButton,10,5000).click();
    }

    public List<WebElement> getAllDeleteButtonsElements(){
        return driver.findElements(deleteElementButton);
    }
}
