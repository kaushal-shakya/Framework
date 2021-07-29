package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPagePOP {

    public WebDriver driver;

    public LandingPagePOP(WebDriver driver){
        this.driver = driver;
    }

    private By login  = By.linkText("Login");
    private By title = By.xpath("//div[@class='text-center']/h2");
    private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");


    public WebElement getLogin(){
        return driver.findElement(login);
    }
    public WebElement getCoursesTitle(){
        return driver.findElement(title);
    }
    public WebElement getNavBar(){ return driver.findElement(navBar); }
}
