package com.qacart.todo.pages;

import com.qacart.todo.utils.ConfigUtils;
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

    public boolean isWelcomeMessageIsDisplayed (WebDriver driver)
    {
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    public void clickOnPlusButton(WebDriver driver)
    {
          driver.findElement(plusButton).click();
    }

    public String getTodotext(WebDriver driver)
    {
        return driver.findElement(todoItem).getText();
    }

    public void deleteTodo(WebDriver driver)
    {
        driver.findElement(deleteIcon).click();

    }

    public void load(WebDriver driver)
    {
        driver.get(ConfigUtils.getInstance().getBaseUrl() +"/todo");
    }

    public boolean isNoTodoDisplayed(WebDriver driver)
    {
        return driver.findElement(noTodosMessage).isDisplayed();
    }
}
