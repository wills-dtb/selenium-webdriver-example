package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import login.LoginTestHelpers;

public class BaseTestCase {
    protected static WebDriver driver;

    @org.junit.Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    protected void loginAsDefaultUser() {
        driver.findElement(By.id("email")).sendKeys(LoginTestHelpers.STATIC_EMAIL);
        driver.findElement(By.id("passwd")).sendKeys(LoginTestHelpers.PASSWORD);
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @org.junit.After
    public void tearDown() {
        driver.findElement(By.className("logout")).click();
        driver.quit();
    }
}
