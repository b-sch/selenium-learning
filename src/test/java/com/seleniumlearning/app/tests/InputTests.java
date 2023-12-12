package com.seleniumlearning.app.tests;

import com.seleniumlearning.app.pageobjects.InputFields;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InputTests {

    private WebDriver chromeDriver = new ChromeDriver();
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
        assertNotNull(textInput);
        assertNotNull(passwordField);
        assertNotNull(textArea);
        assertNotNull(disabledInput);
        assertNotNull(readonlyInput);
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

}
