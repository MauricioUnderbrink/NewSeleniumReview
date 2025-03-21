package add_remove_elements;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcoreutils.WaitUtils;

import java.util.List;

public class AddAndRemoveElementsTest extends BaseTest {

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
    public void testAddingElementsToPage(){
        var addRemoveElementsPage = homePage.clickAddRemoveElements();

           addRemoveElementsPage.clickAddButton();

        Assert.assertTrue(addRemoveElementsPage.deleteButtonElement().isDisplayed());


    }

    @Test
    public void testAddingMultipleElements(){
        var addRemoveElementsPage = homePage.clickAddRemoveElements();
        addRemoveElementsPage.clickAddButton();
        addRemoveElementsPage.clickAddButton();

        List<WebElement> listElements = addRemoveElementsPage.getAllDeleteButtonsElements();

        Assert.assertTrue(listElements.size() > 1);

    }


    @Test
    public void testRemovingAllAddedButtons(){
        var addRemoveElementsPage = homePage.clickAddRemoveElements();
        addRemoveElementsPage.clickAddButton();
        addRemoveElementsPage.clickAddButton();

        List<WebElement> listElements = addRemoveElementsPage.getAllDeleteButtonsElements();

        int size = listElements.size();
        int index = 0;

        while(index < size){

          for(WebElement eachButton : listElements){

              eachButton.click();
              index ++;

          }


        }

        boolean isGone = waitUtils.fluentWaitForElementToDisappear(addRemoveElementsPage.deleteButtonLocator(),10,500);
        Assert.assertTrue(isGone, "Element did not disappear");

    }


}
