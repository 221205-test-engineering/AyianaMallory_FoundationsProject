package dev.mallory.steps;

import dev.mallory.pages.HomePage;
import dev.mallory.pages.LogIn;
import dev.mallory.runners.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DefectStatusImpl
{
    public static WebDriver driver = MainRunner.driver;
    LogIn logIn = new LogIn(driver);
    HomePage homePage = new HomePage(driver);
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page()
    {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=27");
        logIn.userName.sendKeys("ryeGuy");
        logIn.passWord.sendKeys("coolbeans");
        logIn.logInButton.click();
    }

    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/h3[1]")));
        String seeDefects = homePage.myDefects.getText();
        Assert.assertEquals("My Defects", seeDefects);
    }

    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status()
    {
        /*Actions ac = new Actions(driver);
        ac.moveToElement(driver.findElement(By.xpath("//li[1]"))).click();
        ac.moveToElement(homePage.changeStatusButton).click();
        ac.moveToElement(homePage.acceptedButton).click();*/
        driver.findElement(By.xpath("//li[1]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]//span/button[text()='Change Status']")));
        homePage.changeStatusButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[1]")));
        homePage.acceptedButton.click();
    }

    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[1]/div/span/p/b[2]")));
        String statusText = homePage.seeTheStatus.getText();
        String buttonText = homePage.acceptedButton.getText();
        Assert.assertEquals(statusText, buttonText);
    }
}
