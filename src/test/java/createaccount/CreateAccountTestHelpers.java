package createaccount;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import base.BaseTestCase;

public class CreateAccountTestHelpers extends BaseTestCase {
    static final String EMAIL = "will@" + RandomStringUtils.randomAlphanumeric(10) + ".com";
    static final String FIRSTNAME = "Will";
    static final String LASTNAME = "Youbemine";
    public static final String PASSWORD = "password123";
    static final String DAY_OF_BIRTH = "20";
    static final String MONTH_OF_BIRTH = "February";
    static final String YEAR_OF_BIRTH = "2012";
    static final String ADDRESS_LINE_1 = "Somewhere-near-You";
    static final String CITY = "Local";
    static final String STATE = "Colorado";
    static final String ZIPCODE = "80022";
    static final String COUNTRY = "United States";
    static final String MOBILE_NUMBER = "07775554443";
    static final JavascriptExecutor executor = (JavascriptExecutor) driver;
}
