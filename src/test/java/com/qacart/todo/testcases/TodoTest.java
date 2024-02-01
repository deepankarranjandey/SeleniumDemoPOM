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
        RegisterPage.getInstance().load(driver.get());
        RegisterPage.getInstance().registerUsingApi(driver.get(),user);
        TodoPage.getInstance().clickOnPlusButton(driver.get());
        NewTodoPage.getInstance().addTodo(driver.get(), "Deep Test");
        String todoText= TodoPage.getInstance().getTodotext(driver.get());
        Assert.assertEquals(todoText,"Deep Test");

    }

    @Test
    public void deleteTodo()
    {


        User user=new User();
        RegisterPage.getInstance().load(driver.get());
        RegisterPage.getInstance().registerUsingApi(driver.get(),user);
        NewTodoPage.getInstance().addTodoUsingApi(user,"Deep Test");
        TodoPage.getInstance().load(driver.get());
        TodoPage.getInstance().deleteTodo(driver.get());
        boolean isTodosDisplayed = TodoPage.getInstance().isNoTodoDisplayed(driver.get());
        Assert.assertTrue(isTodosDisplayed);

    }
}
