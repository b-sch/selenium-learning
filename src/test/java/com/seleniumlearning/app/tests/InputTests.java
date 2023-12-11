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
        String stringInputToCheck = "test value";
        textInput.sendKeys(stringInputToCheck);
        assertEquals(stringInputToCheck, textInput.getDomProperty("value"));
        chromeDriver.quit();
    }

    @Test
    public void checkPasswordInput() {
        chromeDriver.get(websiteURL);
        WebElement passwordField = chromeDriver.findElement(InputFields.password);
        String stringInputToCheck = "test value";
        passwordField.sendKeys(stringInputToCheck);
        assertEquals("password",passwordField.getDomAttribute("type"));
        chromeDriver.quit();
    }

}
