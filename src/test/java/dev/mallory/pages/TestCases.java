package dev.mallory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCases
{
    public WebDriver driver;
    public TestCases(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/form/fieldset/textarea[1]")
    public WebElement descriptionInput;

    @FindBy(xpath = "//*[@id=\"root\"]/form/fieldset/textarea[2]")
    public WebElement stepsInput;

    @FindBy(xpath = "//*[@id=\"root\"]/form/fieldset/button")
    public WebElement submitButton;

    @FindBy(xpath = "//table/tbody/tr[last()]/td[2]")
    public WebElement newestTestCaseDesc;

    @FindBy(xpath = "//table/tbody/tr[last()]/td[3]")
    public WebElement newestTestCaseResult;

    @FindBy(xpath = "//table/tbody/tr[last()]/td[last()]/button")
    public WebElement detailsButton;

    @FindBy(xpath = "/html/body/div[3]/div/div")
    public WebElement modal;

    @FindBy(xpath = "/html/body/div[3]/div/div/p[6]")
    public WebElement performedBy;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[1]")
    public WebElement modalCloseButton;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[2]")
    public WebElement modalEditButton;

    @FindBy(xpath = "//*[@id=\"root\"]/button")
    public WebElement editPageEditButton;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/textarea[1]")
    public WebElement editPageDescriptionInput;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/textarea[2]")
    public WebElement editPageStepInput;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/input")
    public WebElement automatedCheckBox;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/select")
    public WebElement performedByDropdown;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[2]/select")
    public WebElement testResultDropDown;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[2]/textarea")
    public WebElement summaryInput;

    @FindBy(xpath = "//*[@id=\"root\"]/button[2]")
    public WebElement editPageSaveButton;

    @FindBy(xpath = "//*[@id=\"root\"]/button[1]")
    public WebElement editPageRestButton;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[2]/p")
    public WebElement testResultOriginal;
}
