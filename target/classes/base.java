package resources;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public Properties p = new Properties();

    public WebDriver initializeDriver() throws IOException {
    	
        FileInputStream fis = new FileInputStream( System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
        p.load(fis);

//        String browserName = p.getProperty("browser");
        
        String browserName = System.getProperty("browser");
        
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
            ChromeOptions  options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        }else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testMethodName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}
