package com.qacart.todo.testcases;


import com.qacart.todo.base.BaseTest;

import com.qacart.todo.models.User;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;



public class UserTest extends BaseTest {


    @Test
    public void userRegistrationfunctionality()
    {


        User user=new User();

        driver.get("https://todo.qacart.com/signup");
        driver.findElement(By.cssSelector("input[data-testid='first-name']")).sendKeys(user.getFirstName());
        driver.findElement(By.cssSelector("input[data-testid='last-name']")).sendKeys(user.getLastName());
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(user.getEmail());
        driver.findElement(By.cssSelector("input[data-testid='password']")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("input[data-testid='confirm-password']")).sendKeys("Test@123");
        driver.findElement(By.cssSelector("button[type='button']")).click();
        boolean isWelcomeDisplayed = driver.findElement(By.cssSelector("h2[data-testid='welcome']")).isDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
        driver.quit();
    }

}
