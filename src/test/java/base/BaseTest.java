package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import page_elements.HomePage;
import testcoreutils.WebDriverFactory;

import java.io.File;
import java.io.IOException;

public class BaseTest {


   private  WebDriver driver;
   protected HomePage homePage;

    protected final String THE_INTERNET_URL = "https://the-internet.herokuapp.com/";

    protected final String AUTOMATION_URL = "http://www.automationpractice.pl/index.php";

   public void setUp(String browser){
       driver = WebDriverFactory.createDriver(browser);
       navigateToHomePage();
       driver.manage().window().maximize();
       homePage = new HomePage(driver);

   }

    public void navigateToHomePage(){
        driver.get(THE_INTERNET_URL);
        driver.manage().timeouts().getPageLoadTimeout();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs((OutputType.FILE));
            try {
                Files.move(screenshot, new File("C:/Users/mauga/TestUniversity/TUSelenium/SeleniumReview/src/main/java/resources/screenshots/"
                        + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
  /*  public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    public void selectUrl(String siteName) {
        if (siteName.equals("My Shop")) {
            driver.get(AUTOMATION_URL);
        } else if (siteName.equals("default")) {
            driver.get(THE_INTERNET_URL); // Default URL
        } else {
            driver.get(THE_INTERNET_URL); // Fallback
        }
    }
*/
}
