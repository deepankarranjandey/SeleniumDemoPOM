package com.qacart.todo.testcases;


import com.qacart.todo.base.BaseTest;

import com.qacart.todo.models.User;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;



public class TodoTest extends BaseTest {


    @Test
    public void shouldBeAbletoAddTodo()
    {


        User user=new User();

        driver.get("https://todo.qacart.com/signup");
        new RegisterPage().register(driver,user);
        new  TodoPage().clickOnPlusButton(driver);
        new NewTodoPage().addTodo(driver, "Deep Test");
        String todoText= driver.findElement(By.cssSelector("h2[data-testid='todo-text']")).getText();
        Assert.assertEquals(todoText,"Deep Test");

    }

    @Test
    public void deleteTodo()
    {


        User user=new User();

        driver.get("https://todo.qacart.com/signup");
        new RegisterPage().register(driver,user);
        new TodoPage().clickOnPlusButton(driver);
        new NewTodoPage().addTodo(driver, "Deep Test");
        String todoText= driver.findElement(By.cssSelector("h2[data-testid='todo-text']")).getText();
        Assert.assertEquals(todoText,"Deep Test");
        driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[3]")).click();
        String checkTodo = driver.findElement(By.cssSelector("h4[data-testid='no-todos']")).getText();
        Assert.assertEquals(checkTodo,"No Available Todos");

    }
}
