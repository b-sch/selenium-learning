package com.seleniumlearning.app.pageobjects;

import org.openqa.selenium.By;

public class InputFields {
    public static By textInput = By.id("my-text-id");
    public static By password = By.name("my-password");
    public static By textArea = By.name("my-textarea");
    public static By disabledInput = By.name("my-disabled");
    public static By readonlyInput = By.name("my-readonly");
    public static By dropdown = By.name("my-select");
    public static By dropdownOptions = By.cssSelector("select.form-select[name='my-select'] option");

}
