package ru.gotoqa;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Muflikhunov Roman
 */

public class GotoQaLoginPage extends PageObject{

    @FindBy(name = "log")
    WebElement authorUserName;

    @FindBy(name = "pwd")
    WebElement authorPassword;

    @FindBy(xpath = "//*[@id='login']/h1/a")
    WebElement currentText;

    @FindBy(name = "rememberme")
    WebElement rememberMe;

    @FindBy(name = "wp-submit")
    WebElement loginButton;

    @FindBy(id = "nav")
    WebElement forgetPassword;

    @FindBy(id = "backtoblog")
    WebElement backGotoQa;

    @FindBy(id = "login_error")
    WebElement errorMessage;

    public GotoQaLoginPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(currentText.isDisplayed());
    }

    //input user name
    public void setUserName(String txtUserName) {
        authorUserName.sendKeys(txtUserName);
    }

    //input password
    public void setPassword(String txtPassword) {
        authorPassword.sendKeys(txtPassword);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickBackToQa() {
        backGotoQa.click();
    }

    public String getErrorAuthorizationMessage(){
        return errorMessage.getText();
    }

    public String getTextLoginPage() {
        return currentText.getText();
    }

    public void authorizationGotoQa(String txtUserName,String txtPassword){
        this.setUserName(txtUserName);
        this.setPassword(txtPassword);
        this.clickLoginButton();
    }


}
