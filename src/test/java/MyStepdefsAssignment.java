import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class MyStepdefsAssignment {

    WebDriver driver;

    @Given("I have opened the {string} browser")
    public void iHaveOpenedTheBrowser(String browser) {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/new/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        
    }

    @Given("I write an Email {string}")
    public void iWriteAnEmail(String mail) {
        WebElement Email = driver.findElement(By.id("email"));
        Email.sendKeys(mail);
    }

    @Given("I write a username {string}")
    public void iWriteAUsername(String username) {
        WebElement Username = driver.findElement(By.id("new_username"));
        Username.sendKeys(username);
    }

    @Given("I write a password {string}")
    public void iWriteAPassword(String password) {
        WebElement Password = driver.findElement(By.id("new_password"));
        Password.sendKeys(password);
    }

    @When("I click the sign up button")
    public void iClickTheSignUpButton() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.id("create-account")).click();
    }

    @Then("I get the result {string} when I sign up")
    public void theAccountISucessfullyCreated(String Text) {

        assertEquals(Text, driver.findElement(By.xpath("//*[@id=\"signup-content\"]/div/div/div/h1")).getText());
        driver.quit();
    }

    @Then("I get the result {string}")
    public void iGetTheResult(String result) {
        String expected = "resultat:Enter a value less than 100 characters long";

        assertEquals(result, driver.findElement(By.className("invalid-error")).getText());
        driver.quit();
    }




}


