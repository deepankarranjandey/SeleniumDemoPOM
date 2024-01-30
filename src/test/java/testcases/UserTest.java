package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserTest {


    @Test
    public void userRegistrationfunctionality()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://todo.qacart.com/signup");
        driver.findElement(By.cssSelector("input[data-testid='first-name']")).sendKeys("Deepankar");
        driver.findElement(By.cssSelector("input[data-testid='last-name']")).sendKeys("Dey");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("deepankar2@yopmail.com");
        driver.findElement(By.cssSelector("input[data-testid='password']")).sendKeys("Test@123");
        driver.findElement(By.cssSelector("input[data-testid='confirm-password']")).sendKeys("Test@123");
        driver.findElement(By.cssSelector("button[type='button']")).click();
        boolean isWelcomeDisplayed = driver.findElement(By.cssSelector("h2[data-testid='welcome']")).isDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
        driver.quit();
    }

}
