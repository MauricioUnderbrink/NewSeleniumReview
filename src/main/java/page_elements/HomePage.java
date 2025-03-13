package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

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

    public ChallengingDomPage clickChallengingDomLink(){
        clickLink("Challenging DOM");
        return new ChallengingDomPage(driver);
    }

    public DragAndDropPage clickDragAndDropLink(){
        clickLink("Drag and Drop");
        return new DragAndDropPage(driver);
    }

    public DropdownPage clickDropdownLink(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public DynamicContentPage clickDynamicContentLink(){
        clickLink("Dynamic Content");
        return new DynamicContentPage(driver);
    }

    public FileDownloadPage clickFileDownloadLink(){
        clickLink("File Download");
        return new FileDownloadPage(driver);
    }

    public FileUploadPage clickFileUploadLink(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public FramesPage clickFramesLink(){
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSliderLink(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public HoversPage clickHoversLink(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public JavaScriptAlertsPage clickJavaScriptAlertsLink(){
        clickLink("JavaScript Alerts");
        return new JavaScriptAlertsPage(driver);
    }

    public KeyPressesPage clickKeyPressesLink(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindowsLink(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }

    public NestedFramesPage clickNestedFramesLink(){
        clickLink("Nested Frames");
        return new NestedFramesPage(driver);
    }

}
