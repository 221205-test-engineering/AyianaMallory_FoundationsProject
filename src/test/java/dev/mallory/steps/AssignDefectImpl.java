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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AssignDefectImpl
{
    public static WebDriver driver = MainRunner.driver;
    LogIn logIn = new LogIn(driver);
    HomePage homePage = new HomePage(driver);
    public String defectDesc;
    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager()
    {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=27");
        logIn.userName.sendKeys("g8tor");
        logIn.passWord.sendKeys("chomp!");
        logIn.logInButton.click();
    }

    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() throws InterruptedException
    {
        //new WebDriverWait(driver, Duration.ofSeconds(10))
                //.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/h1")));
        Thread.sleep(1000);
        String managerHome = homePage.driver.getTitle();
        Assert.assertEquals("Manager Home", managerHome);
    }

    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects()
    {
        String pendingDefects = homePage.pendingDefects.getText();
        Assert.assertEquals("Assign Defects", pendingDefects);
    }

    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect()
    {
        //Thread.sleep(1000);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[1]/td[3]/button")));
        homePage.selectDefectButton.click();
    }

    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold()
    {
        defectDesc = homePage.defectDesc.getText();
        String defectDescBold = homePage.defectDescBold.getText();
        Assert.assertEquals(defectDesc, defectDescBold);
    }

    @When("The manager selects a tester from the drop down list")
    public void the_manager_selects_a_tester_from_the_drop_down_list()
    {
        homePage.assignTester.sendKeys("cavalier89");
    }

    @When("The manager clicks assign")
    public void the_manager_clicks_assign()
    {
        homePage.assignButton.click();
    }

    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() throws InterruptedException
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[2]")));
        String newDefectDesc = homePage.newDefectDesc.getText();
        Assert.assertNotEquals(defectDesc, newDefectDesc);
    }
}
