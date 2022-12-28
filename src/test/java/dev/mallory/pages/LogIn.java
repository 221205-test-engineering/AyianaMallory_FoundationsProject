package dev.mallory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn
{
    public WebDriver driver;
    public LogIn(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//fieldset/input[1]")
    public WebElement userName;

    @FindBy(xpath = "//fieldset/input[2]")
    public WebElement passWord;

    @FindBy(xpath = "//fieldset/button")
    public WebElement logInButton;

    @FindBy(xpath = "//title")
    public WebElement title;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/p")
    public WebElement name;
}
