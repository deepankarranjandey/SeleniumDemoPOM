package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TodoTest {


    @Test(priority = 0)
    public void shouldBeAbletoAddTodo()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://todo.qacart.com/login");
        driver.findElement(By.cssSelector("#email")).sendKeys("deepankar1@yopmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@123");
        driver.findElement(By.cssSelector("button[type='button']")).click();
        String headerText= driver.findElement(By.cssSelector("h2[data-testid='welcome']")).getText().toLowerCase();
        Assert.assertEquals(headerText,"good afternoon deepankar");
        driver.findElement(By.cssSelector(".MuiIconButton-label")).click();
        driver.findElement(By.cssSelector("input[data-testid='new-todo']")).sendKeys("Deep Test");
        driver.findElement(By.cssSelector("button[data-testid='submit-newTask']")).click();
        String todoText= driver.findElement(By.cssSelector("h2[data-testid='todo-text']")).getText();
        Assert.assertEquals(todoText,"Deep Test");
        driver.quit();
    }

    @Test(priority = 1)
    public void deleteTodo()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://todo.qacart.com/login");
        driver.findElement(By.cssSelector("#email")).sendKeys("deepankar1@yopmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@123");
        driver.findElement(By.cssSelector("button[type='button']")).click();
        String headerText= driver.findElement(By.cssSelector("h2[data-testid='welcome']")).getText().toLowerCase();
        Assert.assertEquals(headerText,"good afternoon deepankar");
        driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[3]")).click();
        String checkTodo = driver.findElement(By.cssSelector("h4[data-testid='no-todos']")).getText();
        Assert.assertEquals(checkTodo,"No Available Todos");
        driver.quit();
    }
}
