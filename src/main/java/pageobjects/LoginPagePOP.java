package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePOP {

    public WebDriver driver;

    public LoginPagePOP(WebDriver driver){
        this.driver = driver;
    }

    By username = By.cssSelector("#user_email");
    By passwd = By.cssSelector("#user_password");
    By loginBtn = By.cssSelector("input[name='commit']");

    public WebElement getUserName(){
        return driver.findElement(username);
    }
    public WebElement getPasswd(){
        return driver.findElement(passwd);
    }
    public WebElement getLoginBtn(){
        return driver.findElement(loginBtn);
    }
}
