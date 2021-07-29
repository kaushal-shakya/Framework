package endtoend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.LandingPagePOP;
import resources.base;

import java.io.IOException;

public class ValidateTitle extends base {
    public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

        driver.get(p.getProperty("url"));
        log.info("Navigated to Home page");
    }

    @Test
    public void validateTitle(){
        LandingPagePOP lp = new LandingPagePOP(driver);
        Assert.assertEquals(lp.getCoursesTitle().getText(), "FEATURED COURSES123");
        log.info("Successfully validated Text message");
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
