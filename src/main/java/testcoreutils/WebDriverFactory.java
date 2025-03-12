package testcoreutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private WebDriver driver;

    public WebDriverFactory(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Creates and returns a WebDriver instance based on the browser type.
     *
     * @param browser The name of the browser ("chrome", "firefox", "edge").
     * @return A WebDriver instance for the specified browser.
     * @throws IllegalArgumentException if the browser type is unsupported.
     */
    public static WebDriver createDriver(String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

}
