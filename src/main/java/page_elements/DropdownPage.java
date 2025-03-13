package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DropdownPage {

    private WebDriver driver;
    public DropdownPage(WebDriver driver) {

        this.driver = driver;

    }

private By dropdownLocator = By.id("dropdown");


    public WebElement getDropdownElement(){
        return driver.findElement(dropdownLocator);
    }
    public Map<String, String> getDropdownOptions(){

        Map<String, String> options = new HashMap<>();

        Select select = new Select(getDropdownElement());

        List<WebElement> optionsElements = select.getOptions();

        for(WebElement eachOption : optionsElements){
            if(!eachOption.getAttribute("value").equals("disabled")) {
                options.put(eachOption.getAttribute("value"), eachOption.getText());
            }

        }

        return options;

    }

    public void clickOptionByIndex(int index){
        Select select = new Select(getDropdownElement());
        select.selectByIndex(index);

    }

    public String getSelectedOptionText(){
        Select select = new Select(getDropdownElement());
       return select.getFirstSelectedOption().getText();
    }

}
