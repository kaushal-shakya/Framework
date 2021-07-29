package endtoend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageobjects.LandingPagePOP;
import pageobjects.LoginPagePOP;
import resources.base;

import java.io.IOException;

public class HomePage extends base {
    public static Logger log = LogManager.getLogger(HomePage.class.getName());
    public WebDriver driver;
    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @Test(dataProvider = "dataGettr")
    public void basePageNavigation(String username, String password) throws IOException {
        driver.get(p.getProperty("url"));
        LandingPagePOP lp = new LandingPagePOP(driver);
        lp.getLogin().click();

        LoginPagePOP loginPage = new LoginPagePOP(driver);
        loginPage.getUserName().sendKeys(username);
        loginPage.getPasswd().sendKeys(password);
        loginPage.getLoginBtn().click();
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

    @DataProvider
    public Object[][] dataGettr(){

        //Row stands for how many different data types test should run
        //Column stands  how may values per each test

        Object[][] data = new Object[2][2];

        data[0][0] = "nonrestricteduser@qw.com";
        data[0][1] = "123456";

        data[1][0] = "restricteduser@qw.com";
        data[1][1] = "123456";

        return data;
    }

}
