package com.seleniumlearning.app.tests;

import com.seleniumlearning.app.pageobjects.InputFields;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class InputTests {

    private ChromeOptions chromeOptions = new ChromeOptions();
    private WebDriver chromeDriver = new ChromeDriver(chromeOptions);
    private String websiteURL = "https://www.selenium.dev/selenium/web/web-form.html";
    private String stringInputToCheck = "test value";

    @Test
    public void checkIfAllInputFieldsExist() {
        chromeDriver.get(websiteURL);
        WebElement textInput = chromeDriver.findElement(InputFields.textInput);
        WebElement passwordField = chromeDriver.findElement(InputFields.password);
        WebElement textArea = chromeDriver.findElement(InputFields.textArea);
        WebElement disabledInput = chromeDriver.findElement(InputFields.disabledInput);
        WebElement readonlyInput = chromeDriver.findElement(InputFields.readonlyInput);
        WebElement dropdown = chromeDriver.findElement(InputFields.dropdown);
        assertNotNull(textInput);
        assertNotNull(passwordField);
        assertNotNull(textArea);
        assertNotNull(disabledInput);
        assertNotNull(readonlyInput);
        assertNotNull(dropdown);
        chromeDriver.quit();
    }

    @Test
    public void checkTextInput() {
        chromeDriver.get(websiteURL);
        WebElement textInput = chromeDriver.findElement(InputFields.textInput);
        textInput.sendKeys(stringInputToCheck);
        assertEquals(stringInputToCheck, textInput.getDomProperty("value"));
        chromeDriver.quit();
    }

    @Test
    public void checkPasswordInput() {
        chromeDriver.get(websiteURL);
        WebElement passwordField = chromeDriver.findElement(InputFields.password);
        passwordField.sendKeys(stringInputToCheck);
        assertEquals("password",passwordField.getDomAttribute("type"));
        chromeDriver.quit();
    }

    @Test
    public void checkTextarea() {
        chromeDriver.get(websiteURL);
        WebElement textArea = chromeDriver.findElement(InputFields.textArea);
        assertNotNull(textArea);
        textArea.sendKeys(stringInputToCheck);
        assertEquals(stringInputToCheck, textArea.getDomProperty("value"));
        chromeDriver.quit();
    }

    @Test
    public void checkDisabledInput() {
        chromeDriver.get(websiteURL);
        WebElement disabledInput = chromeDriver.findElement(InputFields.disabledInput);
        assertFalse(disabledInput.isEnabled());
        chromeDriver.quit();
    }

    @Test
    public void checkReadonlyInput() {
        chromeDriver.get(websiteURL);
        WebElement readonlyInput = chromeDriver.findElement(InputFields.readonlyInput);
        assertTrue(Boolean.parseBoolean(readonlyInput.getDomAttribute("readonly")));
        chromeDriver.quit();
    }

    @Test
    public void checkDropdown() {
        chromeDriver.get(websiteURL);
        WebElement dropdown = chromeDriver.findElement(InputFields.dropdown);
        List<WebElement> dropdownOptions = chromeDriver.findElements(InputFields.dropdownOptions);
        for (Integer i = 1; i <= 3; i++) {
            assertEquals(i,  Integer.valueOf(dropdownOptions.get(i).getDomAttribute("value")));
        }
        chromeDriver.quit();
    }
}
