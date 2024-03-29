package com.qacart.todo.pages;

import com.qacart.todo.apis.UserAPI;
import com.qacart.todo.models.User;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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

    @Step("Visit Sign up page")

    public void load(WebDriver driver)
    {
        driver.get(ConfigUtils.getInstance().getBaseUrl() +"/signup");
    }

    @Step("Registration on UI")
    public void register(WebDriver driver, User user) {
        driver.findElement(firstNameInput).sendKeys(user.getFirstName());
        driver.findElement(lastNameInput).sendKeys(user.getLastName());
        driver.findElement(emailInput).sendKeys(user.getEmail());
        driver.findElement(passwordInput).sendKeys(user.getPassword());
        driver.findElement(confirmPasswordInput).sendKeys(user.getPassword());
        driver.findElement(submitButton).click();
    }
    @Step("Registration using API")
    public void registerUsingApi(WebDriver driver, User user)
    {
        Response res= UserAPI.getInstance().register(user);
        String access_token=res.path("access_token");
        String userID=res.path("userID");
        String firstName=res.path("firstName");
        user.setAccessToken(access_token);

        Cookie accessTokenCookie= new Cookie("access_token", access_token);
        Cookie userIDCookie= new Cookie("userID", userID);
        Cookie firstNameCookie= new Cookie("firstName", firstName);

        RegisterPage.getInstance().load(driver);
        driver.manage().addCookie(accessTokenCookie);
        driver.manage().addCookie(userIDCookie);
        driver.manage().addCookie(firstNameCookie);
        RegisterPage.getInstance().load(driver);




    }

}
