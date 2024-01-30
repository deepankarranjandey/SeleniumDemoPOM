package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoPage {

    //elements
    private  final  By welcomeMessage= By.cssSelector("h2[data-testid='welcome']");
    private final By plusButton = By.cssSelector("span.MuiIconButton-label");
    private final By todoItem =By.cssSelector("h2[data-testid='todo-text']");
    private final By deleteIcon =By.xpath("(//span[@class='MuiIconButton-label'])[3]");

    //methods, steps

    public boolean isWelcomeMessageIsDisplayed (WebDriver driver)
    {
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    public void clickOnPlusButton(WebDriver driver)
    {
          driver.findElement(plusButton).click();
    }

}
