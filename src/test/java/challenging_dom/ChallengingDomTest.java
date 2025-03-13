package challenging_dom;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcoreutils.WaitUtils;

import java.util.*;

public class ChallengingDomTest extends BaseTest {

    WaitUtils waitUtils;

    String[] columnValues =
            {"Iuvaret",
                    "Apeirian",
                    "Adipisci",
                    "Definiebas",
                    "Consequuntur",
                    "Phaedrum",
                    "edit delete"};

    Map<String, String> columnsAndValues = new HashMap<>();


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
    public void clickTheFirstLeftButton() {
        var challengingDomPage = homePage.clickChallengingDomLink();
        String buttonLabel1 = challengingDomPage.getButtonLabelByIndex(0);
        challengingDomPage.clickTopLeftButtonByIndex(0);
        String buttonLabel2 = challengingDomPage.getButtonLabelByIndex(0);
        if (buttonLabel1.equals(buttonLabel2)) {
            challengingDomPage.clickTopLeftButtonByIndex(0);
            buttonLabel2 = challengingDomPage.getButtonLabelByIndex(0);
        }
        Assert.assertNotEquals(buttonLabel1, buttonLabel2);

    }

    @Test
    public void clickTheSecondLeftButton() {
        var challengingDomPage = homePage.clickChallengingDomLink();
        String buttonLabel1 = challengingDomPage.getButtonLabelByIndex(1);
        challengingDomPage.clickTopLeftButtonByIndex(1);
        String buttonLabel2 = challengingDomPage.getButtonLabelByIndex(1);
        if (buttonLabel1.equals(buttonLabel2)) {
            challengingDomPage.clickTopLeftButtonByIndex(1);
            buttonLabel2 = challengingDomPage.getButtonLabelByIndex(1);
        }
        Assert.assertNotEquals(buttonLabel1, buttonLabel2);

    }

    @Test
    public void clickTheThirdLeftButton() {
        var challengingDomPage = homePage.clickChallengingDomLink();

        String buttonLabel1 = challengingDomPage.getButtonLabelByIndex(2);
        challengingDomPage.clickTopLeftButtonByIndex(2);
        String buttonLabel2 = challengingDomPage.getButtonLabelByIndex(2);
        if (buttonLabel1.equals(buttonLabel2)) {
            challengingDomPage.clickTopLeftButtonByIndex(2);
            buttonLabel2 = challengingDomPage.getButtonLabelByIndex(2);
        }

        Assert.assertNotEquals(buttonLabel1, buttonLabel2);

    }

    @Test
    public void testGettingTheValuesFromFirstRow() {

        var challengingDomPage = homePage.clickChallengingDomLink();
        int rowIndex = 1;
        String row = "0";
        Map<String, String> rowDataAndHeaders = challengingDomPage.getAllDataFromARow(rowIndex);

        for (String eachValue : columnValues) {
            String value = "";

            if (eachValue.equals("edit delete")) {
                value = eachValue;
            } else {
                value = eachValue + row;
            }

            Assert.assertTrue(rowDataAndHeaders.containsValue(value));

        }

    }

    @Test
    public void testGettingTheValuesFromSecondRow() {

        var challengingDomPage = homePage.clickChallengingDomLink();
        int rowIndex = 2;
        String row = "1";
        Map<String, String> rowDataAndHeaders = challengingDomPage.getAllDataFromARow(rowIndex);

        for (String eachValue : columnValues) {
            String value = "";

            if (eachValue.equals("edit delete")) {
                value = eachValue;
            } else {
                value = eachValue + row;
            }
            Assert.assertTrue(rowDataAndHeaders.containsValue(value));
        }

    }

}
