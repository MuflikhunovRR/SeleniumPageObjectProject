package ru.gotoqa;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Muflikhunov Roman
 */

public class GotoQaAdminPanelPage extends PageObject {

    @FindBy(xpath = "//*[@id='wp-admin-bar-my-account']/a/span")
    WebElement adminPanelUser;

    @FindBy(xpath = "//*[@id='wp-admin-bar-logout']/a")
    WebElement logOutButton;

    @FindBy(xpath = "//*[@id='menu-posts']/a/div[2]")
    WebElement postLink;

    @FindBy(xpath = "//*[@id='wpbody-content']/div[3]/a")
    WebElement addNewPost;

    @FindBy(name = "post_title")
    WebElement enterTitlePost;

    @FindBy(id = "content-html")
    WebElement buttonText;

    @FindBy(className = "wp-editor-area")
    WebElement enterBodyPost;

    @FindBy(xpath = "//*[@id='save-post']")
    WebElement saveDraftButton;


    public GotoQaAdminPanelPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(adminPanelUser.isDisplayed());
    }

    public String getUserNameAdminPanel() {
        return adminPanelUser.getText();
    }

    public void clickLogOutButton() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", logOutButton);
    }

    public boolean clickPostLink() {
        postLink.click();
        return true;
    }

    public boolean clickAddNewPost() {
        addNewPost.click();
        return true;
    }

    public void setTitlePost(String titlePost) {
        enterTitlePost.sendKeys(titlePost);
    }

    public void clickButtonText() {
        buttonText.click();
    }

    public void setBodyPost(String bodyPost) {
        enterBodyPost.sendKeys(bodyPost);
    }

    public void clickSaveDraftButton() {
        saveDraftButton.click();
    }

    public void createNewPost(String titlePost, String bodyPost){
        this.clickPostLink();
        this.clickAddNewPost();
        this.setTitlePost(titlePost);
        this.clickButtonText();
        this.setBodyPost(bodyPost);
        this.clickSaveDraftButton();
    }

}
