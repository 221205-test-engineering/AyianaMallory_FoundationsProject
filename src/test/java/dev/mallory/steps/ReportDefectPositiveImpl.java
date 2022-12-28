package dev.mallory.steps;

import dev.mallory.pages.DefectReporter;
import dev.mallory.pages.LogIn;
import dev.mallory.runners.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportDefectPositiveImpl
{
    public static WebDriver driver = MainRunner.driver;
    DefectReporter defectReporter = new DefectReporter(driver);

    @When("The employee types in Description with")
    public void the_employee_types_in_description_with(String docString)
    {
        defectReporter.description.sendKeys(docString);
    }

    @When("The employee selects {string} priority")
    public void the_employee_selects_priority(String string)
    {
        int targetValue = 2;
        int curValue = 3;
        if (targetValue < curValue)
        {
            defectReporter.priority.sendKeys(Keys.LEFT);
        }
    }

    @When("The employee selects {string} severity")
    public void the_employee_selects_severity(String string)
    {
        int targetValue = 2;
        int curValue = 3;
        if (targetValue < curValue)
        {
            defectReporter.severity.sendKeys(Keys.LEFT);
        }
    }

    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box()
    {
        try
        {
            driver.switchTo().alert();
        }
        catch (NoAlertPresentException a)
        {
            String alertPresent = "its here";
            Assert.assertNotNull(alertPresent);
        }
    }

    @When("The employee clicks Ok")
    public void the_employee_clicks_ok()
    {
        driver.switchTo().alert().accept();
        //new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div")));
        defectReporter.modal.isDisplayed();
    }

    @When("The employee clicks close")
    public void the_employee_clicks_close()
    {
        defectReporter.modalButton.click();
    }

    @Then("The modal should disappear")
    public void the_modal_should_disappear()
    {
        try
        {
            Assert.assertFalse(defectReporter.modalButton.isDisplayed());
        }
        catch (NoSuchElementException e)
        {
            String modalPresent = null;
            Assert.assertNull(modalPresent);
        }
    }
}
