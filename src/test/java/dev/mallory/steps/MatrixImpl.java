package dev.mallory.steps;

import dev.mallory.pages.Matrix;
import dev.mallory.runners.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MatrixImpl
{
    public static WebDriver driver = MainRunner.driver;
    Matrix matrix = new Matrix(driver);

    @When("The manager chooses to create a new matrix")
    public void the_manager_chooses_to_create_a_new_matrix()
    {
        matrix.matrixButton.click();
    }

    @When("The manager creates a title for the matrix")
    public void the_manager_creates_a_title_for_the_matrix()
    {
        matrix.matrixTitle.sendKeys("New Matrix");
    }

    @When("The manager adds requirements to the matrix")
    public void the_manager_adds_requirements_to_the_matrix()
    {
        matrix.userStory.sendKeys("The user had an issue with something.");
        Select priority = new Select(matrix.priority);
        priority.selectByIndex(2);
        matrix.note.sendKeys("A note about additional details.");
        matrix.addReq.click();
    }

    @When("The manager saves the matrix")
    public void the_manager_saves_the_matrix()
    {
        matrix.createButton.click();
    }

    @Then("An alert with a success message should appear")
    public void an_alert_with_a_success_message_should_appear()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Given("The manager is on the matrix homepage")
    public void the_manager_is_on_the_matrix_homepage()
    {
        matrix.matrixPage.click();
    }

    @Given("The manager has selected the matrix")
    public void the_manager_has_selected_the_matrix()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(matrix.showMatrix));
        matrix.showMatrix.click();
    }

    @When("The manager adds a defect")
    public void the_manager_adds_a_defect()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/ul/li[1]/div/div/div/table/tbody/tr[1]/td[6]/button")));
        matrix.editButton.click();
        //new WebDriverWait(driver, Duration.ofSeconds(5));
        matrix.defectInput.sendKeys("123");
        matrix.defectAdd.click();
    }

    @When("The manager confirms their changes")
    public void the_manager_confirms_their_changes()
    {
        matrix.saveChangesButton.click();
    }

    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("Matrix Saved", alertText);
        driver.switchTo().alert().accept();
    }

    @When("The manager adds a Test Cases")
    public void the_manager_adds_a_test_cases()
    {
        matrix.testCase.sendKeys("123");
        matrix.testCaseAdd.click();
    }
}
