package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcoreutils.WaitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.By.xpath;

public class ChallengingDomPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public ChallengingDomPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }


    private By pageTittleLocator = xpath("//div/h3");

    private By allLeftButtonsLocator = xpath("//div[@class='large-2 columns']/a");

    private By canvasLocator = By.cssSelector("canvas#canvas");

    private By tableHeadersLocator = By.xpath("//table/thead/tr/th");

    private By tableRowsLocator = xpath("//table/tbody");


    public String getPageTitle() {
        return driver.findElement(pageTittleLocator).getText();
    }

    public List<WebElement> getAllLeftButtonsElements() {
        return waitUtils.fluentWaitForElements(allLeftButtonsLocator, 10, 3);
    }

    public void clickTopLeftButtonByIndex(int index) {
        List<WebElement> buttons = driver.findElements(allLeftButtonsLocator);
        buttons.get(index).click();
    }

    public String getButtonLabelByIndex(int index) {
        List<WebElement> allButtons = getAllLeftButtonsElements();
        if (allButtons.size() > 0) {
            return allButtons.get(index).getText();
        }
        return null;
    }

    public String getCanvasText() {
        return driver.findElement(canvasLocator).getText();
    }

    public List<WebElement> getRowElementByIndex(int row) {
        WebElement tableBody = driver.findElement(tableRowsLocator);
        List<WebElement> rowData = tableBody.findElements(By.xpath(".//tr[" + row + "]/td"));
        return rowData;
    }

    public Map<String, String> getAllDataFromARow(int rowIndex) {

        Map<String, String> rowHeadersAndValues = new HashMap<>();
        List<WebElement> rowData = getRowElementByIndex(rowIndex);
        if (rowData != null) {

            List<WebElement> columnHeaderElements = driver.findElements(tableHeadersLocator);

            for (int i = 0; i < columnHeaderElements.size(); i++) {

                String columnValue = rowData.get(i).getText();

                rowHeadersAndValues.put(columnHeaderElements.get(i).getText(), columnValue);
            }

        }
        return rowHeadersAndValues;
    }
}
