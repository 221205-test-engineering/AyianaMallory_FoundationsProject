package dev.mallory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    public WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //THESE ARE ELEMENTS PERTAINING TO THE MANAGER HOMEPAGE
    @FindBy(xpath = "//*[@id='root']/h1")
    public WebElement managerHome;

    @FindBy(xpath = "//h3")
    public WebElement pendingDefects;

    @FindBy(xpath = "//table/tbody/tr[1]/td[3]/button")
    public WebElement selectDefectButton;

    @FindBy(xpath = "//*[@id=\"root\"]/table/tbody/tr[1]/td[2]")
    public WebElement defectDesc;
    @FindBy(xpath = "//*[@id=\"root\"]/div/h4")
    public WebElement defectDescBold;

    @FindBy(xpath = "//*[@id=\"root\"]/div/button")
    public WebElement assignButton;

    @FindBy(xpath = "//*[@id=\"root\"]/table/tbody/tr[1]/td[2]")
    public WebElement newDefectDesc;

    @FindBy(xpath = "//div/input")
    public WebElement assignTester;

    //THESE ARE THE ELEMENTS PERTAINING TO THE TESTER HOMEPAGE
    @FindBy(xpath = "//*[@id=\"root\"]/h3[1]")
    public WebElement myDefects;

    @FindBy(xpath = "//ul/li[1]/div/span/p/b[2]")
    public WebElement seeTheStatus;

    @FindBy(xpath = "//li[1]//span/button[text()='Change Status']")
    public WebElement changeStatusButton;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[1]")
    public WebElement acceptedButton;
}
