package com.qacart.todo.testcases;


import com.qacart.todo.base.BaseTest;

import com.qacart.todo.models.User;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;



public class UserTest extends BaseTest {


    @Test
    public void userRegistrationfunctionality()
    {
        User user=new User();
        driver.get("https://todo.qacart.com/signup");
        new RegisterPage().register(driver,user);
        boolean isWelcomeDisplayed = new TodoPage().isWelcomeMessageIsDisplayed(driver);
        Assert.assertTrue(isWelcomeDisplayed);
        driver.quit();
    }

}
