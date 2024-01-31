package com.qacart.todo.pages;

import com.qacart.todo.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

private static RegisterPage registerPage;


    // elements

    private final By firstNameInput = By.cssSelector("input[data-testid='first-name']");
    private final By lastNameInput = By.cssSelector("input[data-testid='last-name']");
    private final By emailInput = By.cssSelector("input[type='email']");
    private final By passwordInput = By.cssSelector("input[data-testid='password']");
    private final By confirmPasswordInput = By.cssSelector("input[data-testid='confirm-password']");

    private final By submitButton = By.cssSelector("button[type='button']");


    // constructor
    private RegisterPage()
    {}

    public static RegisterPage getInstance()
    {
        if(registerPage == null) {
            registerPage= new RegisterPage();
        }
        return  registerPage;
    }


    // methods

    public void load(WebDriver driver)
    {
        driver.get("https://todo.qacart.com/signup");
    }
    public void register(WebDriver driver, User user) {
        driver.findElement(firstNameInput).sendKeys(user.getFirstName());
        driver.findElement(lastNameInput).sendKeys(user.getLastName());
        driver.findElement(emailInput).sendKeys(user.getEmail());
        driver.findElement(passwordInput).sendKeys(user.getPassword());
        driver.findElement(confirmPasswordInput).sendKeys(user.getPassword());
        driver.findElement(submitButton).click();
    }

}
