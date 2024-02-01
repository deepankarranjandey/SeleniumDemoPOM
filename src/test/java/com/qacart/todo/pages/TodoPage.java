package com.qacart.todo.pages;

import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoPage {

    //constructor




    //elements
    private  final  By welcomeMessage= By.cssSelector("h2[data-testid='welcome']");
    private final By plusButton = By.cssSelector("span.MuiIconButton-label");
    private final By todoItem =By.cssSelector("h2[data-testid='todo-text']");
    private final By deleteIcon =By.xpath("(//span[@class='MuiIconButton-label'])[3]");

    private final By noTodosMessage= By.cssSelector("h4[data-testid='no-todos']");

    private static TodoPage todoPage;


    // constructor

    private  TodoPage()
    {

    }

    public static TodoPage getInstance()
    {

        if(todoPage == null)
        {
            todoPage=new TodoPage();
        }
        return todoPage;

    }



    //methods, steps

    @Step("Check for TODO page")
    public boolean isWelcomeMessageIsDisplayed (WebDriver driver)
    {
        return driver.findElement(welcomeMessage).isDisplayed();
    }

   @Step("Create a TODO")
    public void clickOnPlusButton(WebDriver driver)
    {
          driver.findElement(plusButton).click();
    }

    @Step("Get the TODO text")
    public String getTodotext(WebDriver driver)
    {
        return driver.findElement(todoItem).getText();
    }

    @Step("Deleting the todo page")
    public void deleteTodo(WebDriver driver)
    {
        driver.findElement(deleteIcon).click();

    }

    @Step("Visiting the todo page")
    public void load(WebDriver driver)
    {
        driver.get(ConfigUtils.getInstance().getBaseUrl() +"/todo");
    }

    @Step("verify if no TODO in page")
    public boolean isNoTodoDisplayed(WebDriver driver)
    {
        return driver.findElement(noTodosMessage).isDisplayed();
    }
}
