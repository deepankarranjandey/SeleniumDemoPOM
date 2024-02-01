package com.qacart.todo.testcases;


import com.qacart.todo.base.BaseTest;

import com.qacart.todo.models.User;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;


import org.testng.Assert;
import org.testng.annotations.Test;



public class TodoTest extends BaseTest {


    @Test
    public void shouldBeAbletoAddTodo()
    {


        User user=new User();
        RegisterPage.getInstance().load(driver);
        RegisterPage.getInstance().registerUsingApi(driver,user);
        TodoPage.getInstance().clickOnPlusButton(driver);
        NewTodoPage.getInstance().addTodo(driver, "Deep Test");
        String todoText= TodoPage.getInstance().getTodotext(driver);
        Assert.assertEquals(todoText,"Deep Test");

    }

    @Test
    public void deleteTodo()
    {


        User user=new User();
        RegisterPage.getInstance().load(driver);
        RegisterPage.getInstance().registerUsingApi(driver,user);
        TodoPage.getInstance().clickOnPlusButton(driver);
        NewTodoPage.getInstance().addTodo(driver, "Deep Test");
        TodoPage.getInstance().deleteTodo(driver);
        boolean isTodosDisplayed = TodoPage.getInstance().isNoTodoDisplayed(driver);
        Assert.assertTrue(isTodosDisplayed);

    }
}
