package com.example.fedel.restapi;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MySeleniumSecondTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fedel\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); 
        driver = new ChromeDriver(options);

        Dimension windowSize = new Dimension(1200, 768);
        driver.manage().window().setSize(windowSize);
    }

    @Test
    public void testApplication() throws InterruptedException {
        driver.get("http://localhost:8081/#/"); 

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("second-navbar-item")));

        Thread.sleep(1000);

        element.click();

        Thread.sleep(1000);

        waitUntilURLContains("http://localhost:8081/#/balls-catalog");

        // np. assertTrue(driver.getCurrentUrl().contains("oczekiwanyAdresURL"));

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.endsWith("http://localhost:8081/#/balls-catalog"));
    
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private void waitUntilURLContains(String expectedURLPart) {
        try {
            while (!driver.getCurrentUrl().contains(expectedURLPart)) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
