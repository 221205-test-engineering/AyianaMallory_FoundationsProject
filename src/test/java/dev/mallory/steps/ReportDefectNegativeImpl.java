package dev.mallory.steps;

import dev.mallory.pages.DefectReporter;
import dev.mallory.pages.LogIn;
import dev.mallory.runners.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportDefectNegativeImpl
{
    public static WebDriver driver = MainRunner.driver;
    LogIn logIn = new LogIn(driver);
    DefectReporter defectReporter = new DefectReporter(driver);
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page()
    {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=27");
        logIn.userName.sendKeys("ryeGuy");
        logIn.passWord.sendKeys("coolbeans");
        logIn.logInButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/nav/a[3]")));
        defectReporter.defectCaseReporter.click();
    }

    @When("The employee selects todays date")
    public void the_employee_selects_todays_date()
    {
        defectReporter.todayDate.sendKeys("12262022");
    }

    @When("The employee types in description with")
    public void the_employee_types_in_description_with(String docString)
    {
        defectReporter.description.sendKeys(docString);
    }

    @When("The employee types in Steps with")
    public void the_employee_types_in_steps_with(String docString)
    {
        defectReporter.steps.sendKeys(docString);
    }

    @When("The employee selects high priority")
    public void the_employee_selects_high_priority()
    {
        int maxValue = 3;
        int curValue = 3;
        while (curValue != maxValue)
        {
            defectReporter.priority.sendKeys(Keys.RIGHT);
            curValue++;
        }
    }

    @When("The employee selects low severity")
    public void the_employee_selects_low_severity()
    {
        int minValue = 1;
        int curValue = 3;
        while (curValue != minValue)
        {
            defectReporter.priority.sendKeys(Keys.LEFT);
            curValue--;
        }
    }

    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button()
    {
        defectReporter.reportButton.click();
    }

    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears()
    {
        try
        {
            driver.switchTo().alert();
        }
        catch (NoAlertPresentException a)
        {
            String alertPresent = null;
            Assert.assertNull(alertPresent);
        }
    }

    @When("The employee types in steps with")
    public void the_employee_types_in_steps_with2(String docString)
    {
        defectReporter.steps.sendKeys(docString);
    }
}
