package com.arzhov;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyJunitTest {
    private static WebDriver DRIVER;

    @BeforeAll
    public static void setup(){
        String pathToChromeDriver = "D:\\ProgramFiles\\chromedriver_win32";
        System.setProperty("webdriver.chrome.DRIVER", pathToChromeDriver);
        DRIVER = new ChromeDriver();
    }

    @Test
    public void openGoogle() {
        DRIVER.navigate().to("https://www.google.com/");
        String title = DRIVER.getTitle();

        Assertions.assertEquals(title, "Google");
    }

    @Test
    public void searchGoogle() {
        DRIVER.navigate().to("https://www.google.com/");

        WebElement searchInputElement = DRIVER.findElement(By.xpath("//input[@name='q']"));
        searchInputElement.sendKeys("selenium");
        searchInputElement.sendKeys(Keys.ENTER);

        String title = DRIVER.getTitle();

        Assertions.assertTrue(title.contains("selenium"));
    }

    @AfterAll
    public static void teardown(){
        DRIVER.close();
    }
}
