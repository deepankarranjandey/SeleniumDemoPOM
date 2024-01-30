package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTodoPage {

    //elements

    private final By newTodoInput = By.cssSelector("input[data-testid='new-todo']");
    private final By newTodoSubmit = By.cssSelector("button[data-testid='submit-newTask']");

    //methods

    public void addTodo(WebDriver driver, String item)
    {
        driver.findElement(By.cssSelector("input[data-testid='new-todo']")).sendKeys(item);
        driver.findElement(By.cssSelector("button[data-testid='submit-newTask']")).click();
    }

}
