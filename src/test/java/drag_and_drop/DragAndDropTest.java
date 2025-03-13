package drag_and_drop;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcoreutils.WaitUtils;

public class DragAndDropTest extends BaseTest {


    WaitUtils waitUtils;

    @BeforeClass
    public void setUp() {
        setUp("chrome");
        this.waitUtils = new WaitUtils(driver);
    }

    @BeforeMethod
    public void goToHomePage() {
        navigateToHomePage();
    }


    @Test
    public void clickAndDragFirstColumnToSecondPlace(){
        var dragAndDropPage = homePage.clickDragAndDropLink();

        WebElement firstColumnElement = dragAndDropPage.getColumnByIndex(0);
        WebElement secondColumnElement = dragAndDropPage.getColumnByIndex(1);
        //Get the column's names before the drag and drop action
        String getFirstColumnName1 = firstColumnElement.getText();
        String getSecondColumnName1 = secondColumnElement.getText();

        Actions actions = new Actions(driver);

        actions.dragAndDrop(firstColumnElement, secondColumnElement).perform();

        //Get the Column Names again to check that they have changed
        String getFirstColumnName2 = waitUtils.waitForElementToBeVisibleByWebElement(firstColumnElement,10).getText();
        String getSecondColumnName2 = waitUtils.waitForElementToBeVisibleByWebElement(secondColumnElement,10).getText();

        Assert.assertEquals(getFirstColumnName1, getSecondColumnName2);
        Assert.assertEquals(getSecondColumnName1, getFirstColumnName2);

    }

    @Test
    public void clickAndDragFirstColumnToSecondPlaceClickAndHold(){
        var dragAndDropPage = homePage.clickDragAndDropLink();

        WebElement firstColumnElement = dragAndDropPage.getColumnByIndex(0);
        WebElement secondColumnElement = dragAndDropPage.getColumnByIndex(1);
        //Get the column's names before the drag and drop action
        String getFirstColumnName1 = firstColumnElement.getText();
        String getSecondColumnName1 = secondColumnElement.getText();

        Actions actions = new Actions(driver);

        actions.clickAndHold(firstColumnElement)
                .moveToElement(secondColumnElement)
                .release()
                .build()
                .perform();

        //Get the Column Names again to check that they have changed
        String getFirstColumnName2 = waitUtils.waitForElementToBeVisibleByWebElement(firstColumnElement,10).getText();
        String getSecondColumnName2 = waitUtils.waitForElementToBeVisibleByWebElement(secondColumnElement,10).getText();


        Assert.assertEquals(getFirstColumnName1, getSecondColumnName2);
        Assert.assertEquals(getSecondColumnName1, getFirstColumnName2);
        
    }

}
