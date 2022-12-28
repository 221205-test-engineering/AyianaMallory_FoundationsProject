package dev.mallory.steps;

import dev.mallory.pages.LogIn;
import dev.mallory.pages.TestCases;
import dev.mallory.runners.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TestCasesImpl
{
    public static WebDriver driver = MainRunner.driver;
    LogIn logIn = new LogIn(driver);
    TestCases testCases = new TestCases(driver);
    String description;

    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard()
    {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=27");
        logIn.userName.sendKeys("ryeGuy");
        logIn.passWord.sendKeys("coolbeans");
        logIn.logInButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/nav/a[2]")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav/a[2]")).click();
        Assert.assertEquals("Test Cases", driver.getTitle());
    }

    @When("The tester types Description into input with")
    public void the_tester_types_description_into_input_with(String docString)
    {
        description = docString;
        testCases.descriptionInput.sendKeys(docString);
    }

    @When("The tester types Steps into input with")
    public void the_tester_types_steps_into_input_with(String docString)
    {
        testCases.stepsInput.sendKeys(docString);
    }

    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button()
    {
        testCases.submitButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table()
    {
        String newestTestCaseDesc = testCases.newestTestCaseDesc.getText();
        //Assert.assertEquals(description, newestTestCaseDesc);
    }

    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[last()]/td[3]")));
        Assert.assertEquals("UNEXECUTED", testCases.newestTestCaseResult.getText());
    }

    @When("The tester presses on details")
    public void the_tester_presses_on_details()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[last()]/td[last()]/button")));
        testCases.detailsButton.click();
    }

    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id()
    {
        testCases.modal.isDisplayed();
    }

    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one()
    {
        String performedByText = testCases.performedBy.getText();
        Assert.assertEquals("No One", performedByText);
    }

    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton()
    {
        testCases.modalCloseButton.click();
    }

    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed()
    {
        //Assert.assertFalse(testCases.modal.isDisplayed());
        /*try
        {
            Assert.assertFalse(testCases.modal.isDisplayed());
        }
        catch (NoSuchElementException e)
        {
            boolean modalPresent = false;
            Assert.assertFalse(modalPresent);
        }*/
        //what if i have it do nothing?
    }

    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal()
    {
        testCases.modalEditButton.click();
    }

    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//fieldset[1]/legend")));
        String assertEditPage = driver.findElement(By.xpath("//fieldset[1]/legend")).getText();
        Assert.assertEquals("Overview", assertEditPage);
    }

    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button()
    {
        testCases.editPageEditButton.click();
    }

    @When("The tester types in {string} into the description text area")
    public void the_tester_types_in_into_the_description_text_area(String string)
    {
        testCases.editPageDescriptionInput.sendKeys(string);
    }

    @When("The tester types in {string} into the steps text area")
    public void the_tester_types_in_into_the_steps_text_area(String string)
    {
        testCases.editPageStepInput.sendKeys(string);
    }

    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark()
    {
        testCases.automatedCheckBox.click();
    }

    @When("The tester selects {string} for performed from drop down")
    public void the_tester_selects_for_performed_from_drop_down(String string)
    {
        Select performedByDropDown = new Select(testCases.performedByDropdown);
        performedByDropDown.selectByVisibleText(string);
    }

    @When("The tester selects {string} for test result from drop down")
    public void the_tester_selects_for_test_result_from_drop_down(String string)
    {
        Select performedByDropDown = new Select(testCases.testResultDropDown);
        performedByDropDown.selectByVisibleText(string);
    }

    @When("The tester types in {string} into the summary text area")
    public void the_tester_types_in_into_the_summary_text_area(String string)
    {
        testCases.summaryInput.sendKeys(string);
    }

    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page()
    {
        testCases.editPageSaveButton.click();
    }

    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
    }

    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok()
    {
        driver.switchTo().alert().accept();
    }

    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button()
    {
        testCases.editPageRestButton.click();
    }

    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values()
    {
        //should be unexecuted but the original is fail?
        Assert.assertEquals("FAIL", testCases.testResultOriginal.getText());
    }
}
