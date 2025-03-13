package testcoreutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class WaitUtils {

    private static WebDriver driver;

    public WaitUtils(WebDriver driver){
        this.driver = driver;


    }

    /**
     * Explicit Wait: Wait until element is clickable
     */
    public WebElement waitForElementToBeClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }



    /**
     * Explicit Wait: Wait until element is visible
     * @param locator the element locator
     * @param timeout the time to wait before it times out
     * @return returns the WebElement
     */
    public WebElement waitForElementToBeVisibleByLocator(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeVisibleByWebElement(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This explicit wait will wait until the element is no longer in the DOM.
     * @param locator This passes the element locator
     * @param timeout This passes the time in seconds to wait until.
     */
    public void waitForElementToDisappear(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Explicit wait to wait for Alert to be display
     * @param timeout the time to wait before it times out
     */
    public void waitForAlertToBeDisplay( int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
    }


    /**
     * Fluent Wait: Wait until element is present
     * @param locator The WebElement locator
     * @param timeout the time to wait before it times out
     * @param pollingTime how often to retry
     * @return WebElement
     */
    public WebElement fluentWaitForElement(By locator, int timeout, int pollingTime) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingTime))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Fluent Wait: Wait until all elements are present
     * @param locator The WebElement locator
     * @param timeout the time to wait before it times out
     * @param pollingTime how often to retry
     * @return List of Elements
     */
    public List<WebElement> fluentWaitForElements(By locator, int timeout, int pollingTime) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingTime))
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }


    /**
     * Fluent Wait: Wait until the element is no longer in the DOM
     * @param locator The WebElement locator
     * @param timeout the time to wait before it times out
     * @param pollingTime how often to retry
     * @return boolean
     */
    public boolean fluentWaitForElementToDisappear(By locator, int timeout, int pollingTime) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingTime))
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}
