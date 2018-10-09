package ru.gotoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Muflikhunov Roman
 */
public class GotoQaHomePage extends PageObject {

    @FindBy(xpath = "//*[@id='menu-item-1517']/a")
    WebElement titleGotoQa;

    public String getTextTitleHomePage() {
        return titleGotoQa.getText();
    }

    public GotoQaHomePage(WebDriver driver) {
        super(driver);
    }

}
