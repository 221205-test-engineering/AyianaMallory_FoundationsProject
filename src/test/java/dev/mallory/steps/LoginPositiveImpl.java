package dev.mallory.steps;

import dev.mallory.pages.LogIn;
import dev.mallory.runners.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginPositiveImpl
{
    public static WebDriver driver = MainRunner.driver;
    LogIn logIn = new LogIn(driver);
    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page()
    {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=27"); //website with my dev number
    }

    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String string)
    {
        //It takes a string parameter, seemingly from the example in the feature file
        logIn.userName.sendKeys(string);
    }

    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String string)
    {
        //It takes a string parameter, seemingly from the example in the feature file
        logIn.passWord.sendKeys(string);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button()
    {
        logIn.logInButton.click();
    }

    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String string)
    {
        // assert that the user is on the home page but how?
        //need correction in logIn.title
        String titleActual = logIn.title.getText();
        if(titleActual.equals("Tester Home"))
        {
            assertEquals("Tester Home", titleActual);
        }
        else if(titleActual.equals("Manager Home"))
        {
            assertEquals("Manager Home", titleActual);
        }
    }

    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String string, String string2)
    {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/nav/p")));
        String name = logIn.name.getText();
        assertEquals(name, ("Welcome " + string + " " + string2));
    }
}
