package createaccount;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CreateAccountTest extends BaseTestCase {

    @Test
    public void createAccount() {
        //Given
        driver.findElement(By.className("login")).click();
        CreateAccountTestHelpers.executor.executeScript("document.getElementById('email_create').value='" + CreateAccountTestHelpers.EMAIL + "';");
        driver.findElement(By.id("SubmitCreate")).click();

        //When
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-creation_form")));

        //Then
        driver.findElement(By.id("id_gender1")).click();

        int i = 0;
        String [] dobCatergories = {"days", "months", "years"};
        String [] dropDownDOBEntry = {
                CreateAccountTestHelpers.DAY_OF_BIRTH,
                CreateAccountTestHelpers.MONTH_OF_BIRTH,
                CreateAccountTestHelpers.YEAR_OF_BIRTH
        };
        for (String dobEntry: dropDownDOBEntry) {
            driver.findElement(By.id(dobCatergories[i])).sendKeys(dobEntry);
            i++;
        }

        driver.findElement(By.id("customer_firstname")).sendKeys(CreateAccountTestHelpers.FIRSTNAME);
        driver.findElement(By.id("customer_lastname")).sendKeys(CreateAccountTestHelpers.LASTNAME);
        driver.findElement(By.id("passwd")).sendKeys(CreateAccountTestHelpers.PASSWORD);
        driver.findElement(By.id("address1")).sendKeys(CreateAccountTestHelpers.ADDRESS_LINE_1);
        driver.findElement(By.id("city")).sendKeys(CreateAccountTestHelpers.CITY);
        driver.findElement(By.id("id_state")).sendKeys(CreateAccountTestHelpers.STATE);
        driver.findElement(By.id("postcode")).sendKeys(CreateAccountTestHelpers.ZIPCODE);
        driver.findElement(By.id("id_country")).sendKeys(CreateAccountTestHelpers.COUNTRY);
        driver.findElement(By.id("phone_mobile")).sendKeys(CreateAccountTestHelpers.MOBILE_NUMBER);
        driver.findElement(By.id("submitAccount")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("info-account")));

        assertThat(driver.findElement(By
                .className("info-account"))
                .getText(), is("Welcome to your account. " +
                "Here you can manage all of your personal information and orders."
                )
        );
    }
}