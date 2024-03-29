package com.qacart.todo.pages;

import com.qacart.todo.apis.TodoApi;
import com.qacart.todo.models.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTodoPage {

    private static NewTodoPage newTodoPage;

    //elements

    private final By newTodoInput = By.cssSelector("input[data-testid='new-todo']");
    private final By newTodoSubmit = By.cssSelector("button[data-testid='submit-newTask']");


    // constructor

    private NewTodoPage() {

    }

    public static NewTodoPage getInstance() {
        if (newTodoPage == null) {
            newTodoPage = new NewTodoPage();
        }

        return newTodoPage;

    }


    //methods

    @Step("create a new TODO using UI")
    public void addTodo(WebDriver driver, String item) {
        driver.findElement(By.cssSelector("input[data-testid='new-todo']")).sendKeys(item);
        driver.findElement(By.cssSelector("button[data-testid='submit-newTask']")).click();
    }

    @Step("create a new TODO using API")
    public void addTodoUsingApi(User user, String item) {
        TodoApi.getInstance().addTodo(user, item);
    }

}
