package com.qacart.todo.pages;

import org.openqa.selenium.By;

public class TodoPage {

    //elements
    private  final  By welcomeMessage= By.cssSelector("h2[data-testid='welcome']");
    private final By plusButton = By.cssSelector("input[data-testid='new-todo']");
    private final By todoItem =By.cssSelector("h2[data-testid='todo-text']");
    private final By deleteIcon =By.xpath("(//span[@class='MuiIconButton-label'])[3]");


}
