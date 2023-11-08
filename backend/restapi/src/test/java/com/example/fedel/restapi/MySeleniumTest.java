package com.example.fedel.restapi;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;

// public class MySeleniumTest {

//     private WebDriver driver;

    
//     @BeforeClass
//     public void setUp() {
//         // Konfiguracja WebDriver
//         System.setProperty("webdriver.chrome.driver", "C:\\Users\\fedel\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
//         ChromeOptions options = new ChromeOptions();
//         options.setBinary("C:\\Users\\fedel\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
//         options.addArguments("--headless"); // Opcjonalnie, uruchamianie w trybie bezgłowym
//         driver = new ChromeDriver(options);
//     }

//     // @BeforeClass
//     // public void setUp() {
//     //     // Set the path to the Chrome browser executable you want to use
//     //     System.setProperty("webdriver.chrome.driver", "C:\\Users\\fedel\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");

//     //     ChromeOptions options = new ChromeOptions();
//     //     options.addArguments("--headless"); // Optional, run in headless mode
//     //     driver = new ChromeDriver(options);
//     // }



//     @Test
//     public void testApplication() {
//         // Otwórz stronę internetową
//         driver.get("http://localhost:8080"); // Zmień na adres swojej aplikacji

//         // Przykładowa interakcja z aplikacją
//         WebElement element = driver.findElement(By.id("itemTile")); // Zmień na odpowiedni selektor
//         element.click();

//         // Dodaj asercję, aby sprawdzić oczekiwane zachowanie
//         // np. assertTrue(driver.getCurrentUrl().contains("oczekiwanyAdresURL"));

//     }

//     @AfterClass
//     public void tearDown() {
//         // Zakończ sesję WebDriver
//         driver.quit();
//     }
// }

import org.openqa.selenium.By;
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

public class MySeleniumTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fedel\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); // Optional, run in headless mode
        driver = new ChromeDriver(options);
    }

    @Test
    public void testApplication() throws InterruptedException {
        // Otwórz stronę internetową
        driver.get("http://localhost:8081/#/"); // Zmień na adres swojej aplikacji

        // Przykładowa interakcja z aplikacją
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("item-tile")));

        Thread.sleep(1000);

        element.click();

        Thread.sleep(1000);

        waitUntilURLContains("http://localhost:8081/#/racket/19");

        // Dodaj asercję, aby sprawdzić oczekiwane zachowanie
        // np. assertTrue(driver.getCurrentUrl().contains("oczekiwanyAdresURL"));

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.endsWith("http://localhost:8081/#/racket/19"));
    }

    @AfterClass
    public void tearDown() {
        // Zakończ sesję WebDriver
        driver.quit();
    }

    private void waitUntilURLContains(String expectedURLPart) {
        // You may need to implement a waiting mechanism to wait for the URL to contain the expected part.
        // You can use WebDriverWait or another mechanism.
        // Here's a simple example using Thread.sleep:
        try {
            while (!driver.getCurrentUrl().contains(expectedURLPart)) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
