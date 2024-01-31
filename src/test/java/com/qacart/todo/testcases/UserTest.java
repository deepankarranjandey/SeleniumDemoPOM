package com.qacart.todo.testcases;


import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.User;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class UserTest extends BaseTest {


    @Test
    public void userRegistrationfunctionality()
    {
        User user=new User();
        RegisterPage.getInstance().load(driver);
        RegisterPage.getInstance().register(driver,user);
        boolean isWelcomeDisplayed =TodoPage.getInstance().isWelcomeMessageIsDisplayed(driver);
        Assert.assertTrue(isWelcomeDisplayed);
    }

}
