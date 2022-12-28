package dev.mallory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Matrix
{
    public WebDriver driver;
    public Matrix(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/button")
    public WebElement matrixButton;
    @FindBy(xpath = "//*[@id=\"root\"]/input")
    public WebElement matrixTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/table/tbody/tr/td[1]/input")
    public WebElement userStory;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/table/tbody/tr/td[2]/select")
    public WebElement priority;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/table/tbody/tr/td[3]/input")
    public WebElement note;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/button")
    public WebElement addReq;

    @FindBy(xpath = "//*[@id=\"root\"]/button")
    public WebElement createButton;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[1]")
    public WebElement matrixPage;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/span/button")
    public WebElement showMatrix;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/table/tbody/tr[1]/td[6]/button")
    public WebElement editButton;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[1]/li[2]/input")
    public WebElement testCase;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[1]/li[2]/button")
    public WebElement testCaseAdd;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[2]/li/input")
    public WebElement defectInput;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[2]/li/button")
    public WebElement defectAdd;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/button")
    public WebElement saveChangesButton;
}
