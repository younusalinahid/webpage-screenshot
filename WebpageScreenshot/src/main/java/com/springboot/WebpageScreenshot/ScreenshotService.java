package com.springboot.WebpageScreenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;


@Service
public class ScreenshotService {

    @Value("${chrome.driver.path}")
    private String chromeDriverPath;

    public void takeScreenshot(String url, String outputPath) {

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--handless");
        options.addArguments("--window-size=1920x1080");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get(url);
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File outputFile = new File(outputPath);
            FileUtils.copyFile(file, outputFile);
            System.out.println("Screenshot save to: " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
