import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.EmployeePage;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class TestWithPageObject {
    private WebDriver driver;
    private HomePage homePage;
    private EmployeePage employeePage;
    private WebDriverWait wait;

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://verstandqa.com/login-employee-v2/");
        wait = new WebDriverWait(driver, 10);
        homePage = new HomePage(driver);
    }

    @Test
    public void testLogin() {
        employeePage = homePage.login("admin", "admin123");
        wait.until(ExpectedConditions.titleIs("Add Employee v2 – Verstand QA"));
        //Thread.sleep(12000);

        Assert.assertTrue(employeePage.textoPaginaIsDisplayed() &&
                employeePage.textoPaginaContainsText("Add Employee"));
        driver.quit();
    }

    @Test
    public void employee() throws InterruptedException {
        Thread.sleep(10000);
        employeePage = homePage.login("admin", "admin123");
        wait.until(ExpectedConditions.titleIs("Add Employee v2 – Verstand QA"));


        WebElement buttonAdd = driver.findElement(By.id("addButton"));
        Assert.assertTrue(buttonAdd.isDisplayed());

        employeePage.addEmployed("juan","Abayuba","Montevideo","Montevideo","1180","aaa@aaaa.com","099");

        ExpectedConditions.visibilityOfElementLocated(By.id("success-alert"));




    }
}
