package com.qacart.todo.testcases;

import com.github.javafaker.Faker;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TodoTest extends BaseTest {


    @Test
    public void shouldBeAbletoAddTodo()
    {
        Faker faker=new Faker();
        String  firstName=faker.name().firstName();
        String  lastName=faker.name().lastName();
        String email=faker.internet().safeEmailAddress();

        User user=new User(firstName,lastName,email,"Test@123");

        driver.get("https://todo.qacart.com/signup");
        driver.findElement(By.cssSelector("input[data-testid='first-name']")).sendKeys(user.getFirstName());
        driver.findElement(By.cssSelector("input[data-testid='last-name']")).sendKeys(user.getLastName());
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(user.getEmail());
        driver.findElement(By.cssSelector("input[data-testid='password']")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("input[data-testid='confirm-password']")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("button[type='button']")).click();
        boolean isWelcomeDisplayed = driver.findElement(By.cssSelector("h2[data-testid='welcome']")).isDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
        driver.findElement(By.cssSelector(".MuiIconButton-label")).click();
        driver.findElement(By.cssSelector("input[data-testid='new-todo']")).sendKeys("Deep Test");
        driver.findElement(By.cssSelector("button[data-testid='submit-newTask']")).click();
        String todoText= driver.findElement(By.cssSelector("h2[data-testid='todo-text']")).getText();
        Assert.assertEquals(todoText,"Deep Test");

    }

    @Test
    public void deleteTodo()
    {
        Faker faker=new Faker();
        String  firstName=faker.name().firstName();
        String  lastName=faker.name().lastName();
        String email=faker.internet().safeEmailAddress();

        User user=new User(firstName,lastName,email,"Test@123");

        driver.get("https://todo.qacart.com/signup");
        driver.findElement(By.cssSelector("input[data-testid='first-name']")).sendKeys(user.getFirstName());
        driver.findElement(By.cssSelector("input[data-testid='last-name']")).sendKeys(user.getLastName());
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(user.getEmail());
        driver.findElement(By.cssSelector("input[data-testid='password']")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("input[data-testid='confirm-password']")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("button[type='button']")).click();
        boolean isWelcomeDisplayed = driver.findElement(By.cssSelector("h2[data-testid='welcome']")).isDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
        driver.findElement(By.cssSelector(".MuiIconButton-label")).click();
        driver.findElement(By.cssSelector("input[data-testid='new-todo']")).sendKeys("Deep Test");
        driver.findElement(By.cssSelector("button[data-testid='submit-newTask']")).click();
        String todoText= driver.findElement(By.cssSelector("h2[data-testid='todo-text']")).getText();
        Assert.assertEquals(todoText,"Deep Test");
        driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[3]")).click();
        String checkTodo = driver.findElement(By.cssSelector("h4[data-testid='no-todos']")).getText();
        Assert.assertEquals(checkTodo,"No Available Todos");

    }
}
