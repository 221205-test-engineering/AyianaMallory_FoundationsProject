package dev.mallory.steps;

import dev.mallory.pages.Matrix;
import dev.mallory.runners.MainRunner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationImpl
{
    public static WebDriver driver = MainRunner.driver;
    Matrix matrix = new Matrix(driver);

    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview()
    {
        String matricesText = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/a[1]")).getText();
        String testCasesText = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/a[2]")).getText();
        String defectReportingText = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/a[3]")).getText();
        String defectOverviewText = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/a[4]")).getText();

        Assert.assertEquals("Matrices", matricesText);
        Assert.assertEquals("Test Cases", testCasesText);
        Assert.assertEquals("Report a Defect", defectReportingText);
        Assert.assertEquals("Defect Overview", defectOverviewText);
    }

    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices()
    {
        matrix.matrixPage.click();
    }

    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page()
    {
        Assert.assertEquals("Matrix Dashboard", driver.getTitle());
    }

    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button()
    {
        driver.navigate().back();
    }

    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home()
    {
        Assert.assertEquals("Manager Home", driver.getTitle());
    }

    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases()
    {
        driver.findElement(By.xpath("//*[@id=\"root\"]/nav/a[2]")).click();
    }

    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String string)
    {
        driver.findElement(By.linkText(string)).click();
    }

    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String string)
    {
        Assert.assertEquals(string, driver.getTitle());
    }

}
