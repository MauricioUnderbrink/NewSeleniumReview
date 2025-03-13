package dropdown;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcoreutils.WaitUtils;

public class DropDownTest extends BaseTest {

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
    public void clickFirstEnabledOption() {
        var DropdownPage = homePage.clickDropdownLink();
        int index = 1;
        DropdownPage.clickOptionByIndex(index);
        String selectedOptionText = DropdownPage.getSelectedOptionText();
        String expectedOption = "Option " + String.valueOf(index);
        Assert.assertEquals(selectedOptionText, expectedOption);

    }

    @Test
    public void clickSecondEnabledOption() {
        var DropdownPage = homePage.clickDropdownLink();
        int index = 2;
        DropdownPage.clickOptionByIndex(index);
        String selectedOptionText = DropdownPage.getSelectedOptionText();
        String expectedOption = "Option " + String.valueOf(index);
        Assert.assertEquals(selectedOptionText, expectedOption);

    }

}



