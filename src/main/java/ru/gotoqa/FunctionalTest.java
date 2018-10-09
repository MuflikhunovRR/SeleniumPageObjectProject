package ru.gotoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author Muflikhunov Roman
 */

public class FunctionalTest {
    protected static WebDriver driver;
    protected static Properties prop;

    @BeforeEach
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        prop = new Properties();
        InputStream input = new FileInputStream("src/main/resources/config.properties");
        prop.load(input);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
