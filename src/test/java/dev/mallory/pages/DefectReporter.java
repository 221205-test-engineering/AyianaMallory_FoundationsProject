package dev.mallory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectReporter
{
    public WebDriver driver;
    public DefectReporter(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[3]")
    public WebElement defectCaseReporter;

    @FindBy(xpath = "//*[@id=\"defectReport\"]/input[1]")
    public WebElement todayDate;

    @FindBy(xpath = "//*[@id=\"defectReport\"]/textarea[1]")
    public WebElement description;

    @FindBy(xpath = "//*[@id=\"defectReport\"]/textarea[2]")
    public WebElement steps;

    @FindBy(xpath = "//*[@id=\"defectReport\"]/textarea[2]")
    public WebElement severity;

    @FindBy(xpath = "//*[@id=\"defectReport\"]/textarea[2]")
    public WebElement priority;

    @FindBy(xpath = "//*[@id=\"defectReport\"]/button")
    public WebElement reportButton;

    @FindBy(xpath = "/html/body/div[3]/div/div")
    public WebElement modal;

    @FindBy(xpath = "/html/body/div[3]/div/div/button")
    public WebElement modalButton;
}
