package com.example.fedel.restapi.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverLibrary {

    @Value("${chrome.browser.binary.path}")
    private String chromeBinaryPath;

    @Bean
    public WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(chromeBinaryPath);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fedel\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }
}
