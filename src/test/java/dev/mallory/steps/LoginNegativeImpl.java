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

public class LoginNegativeImpl
{
    public static WebDriver driver = MainRunner.driver;
    LogIn logIn = new LogIn(driver);

    /*@Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page()
    {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=27"); //website with my dev number
    }*/

    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input()
    {
        logIn.userName.sendKeys("g8tor");
    }

    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input()
    {
        logIn.passWord.sendKeys("chomp!!");
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        assertEquals("Wrong password for User", alertText);
    }

    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input()
    {
        logIn.userName.sendKeys("sicEmDawgs");
    }

    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input()
    {
        logIn.passWord.sendKeys("natchamps");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        assertEquals("Username not found", alertText);
    }
}
