package login;

import org.junit.Test;
import org.openqa.selenium.By;
import base.BaseTestCase;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTestCase {

    @Override
    public void setUp() {
        super.setUp();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void loginSuccessfully() {
        // Given user is already registered (as a precondition)
        // When
        driver.findElement(By.id("email")).sendKeys(LoginTestHelpers.STATIC_EMAIL);
        driver.findElement(By.id("passwd")).sendKeys(LoginTestHelpers.PASSWORD);

        // And
        driver.findElement(By.id("SubmitLogin")).click();

        // Then
        assertEquals("MY ACCOUNT", driver.findElement(By.className("page-heading")).getText());
    }
}
