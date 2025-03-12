package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testcoreutils.WaitsUtils;

import java.util.List;

public class AddRemoveElementsPage {

    private WebDriver driver;
  private WaitsUtils waitsUtils;

    private By addElementButton = By.xpath("//button[@onclick='addElement()']");

    private By deleteElementButton = By.xpath("//button[@onclick = 'deleteElement()']");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
      this.waitsUtils = new WaitsUtils(driver);


    }

    public void clickAddButton(){
        waitsUtils.waitForElementToBeClickable(addElementButton,10).click();
    }

    public WebElement deleteButtonElement(){
        return driver.findElement(deleteElementButton);
    }

    public By deleteButtonLocator(){
        return deleteElementButton;
    }

    public void clickDeleteButton(){
       waitsUtils.fluentWaitForElement(deleteElementButton,10,5000).click();
    }

    public List<WebElement> getAllDeleteButtonsElements(){
        return driver.findElements(deleteElementButton);
    }
}
