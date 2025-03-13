package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DragAndDropPage {

    private WebDriver driver;
    public DragAndDropPage(WebDriver driver) {

        this.driver = driver;
    }


    private By allColumnsLocator = By.xpath("//div[@id='columns']/div");


    public WebElement getColumnByIndex(int index){
        List<WebElement> columns = driver.findElements(allColumnsLocator);
       return columns.get(index);

    }

    public void clickColumnByIndex(int index){
        getColumnByIndex(index).click();
    }

    public void getColumnClassName(int index){
        getColumnByIndex(index).getAttribute("id");

    }

}
