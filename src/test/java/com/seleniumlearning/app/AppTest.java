package com.seleniumlearning.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private WebDriver chromeDriver = new ChromeDriver();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void checkWebsiteTitle()
    {
        chromeDriver.get("https://www.selenium.dev/selenium/web/web-form.html");
        assertEquals("Web form", chromeDriver.getTitle());
        chromeDriver.quit();
    }

    @Test
    public void checkTextInput()
    {
        chromeDriver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement textBox = chromeDriver.findElement(By.id("my-text-id"));
        textBox.sendKeys("test");
        chromeDriver.quit();
    }

    @Test
    public void checkTextInputLabel()
    {
        chromeDriver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement formLabel = chromeDriver.findElement(By.tagName("label"));
        assertEquals("Text input", formLabel.getText());
        chromeDriver.quit();
    }

    @Test
    public void checkIfPasswordFieldExists()
    {
        chromeDriver.get("https://www.selenium.dev/selenium/web/web-form.html");
        List<WebElement> formLabels = chromeDriver.findElements(By.tagName("label"));

        List<String> labelStrings = new ArrayList<>();
        for (WebElement element : formLabels) {
            labelStrings.add(element.getText());
        }

        assertTrue(labelStrings.contains("Password"));

        chromeDriver.quit();
    }
}
