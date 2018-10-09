package ru.gotoqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;


import static ru.gotoqa.Constants.*;

/**
 * @author Muflikhunov Roman
 */

public class GotoQaLoginTest extends FunctionalTest{
    private static GotoQaLoginPage qaLoginPage;
    private static GotoQaAdminPanelPage adminPanelPage;
    private static GotoQaHomePage qaHomePage;

    @DisplayName("Selenium Page Object. Correct Login Test.")
    @Test
    public void correctLoginAdminPanelTest() {
        driver.get(prop.getProperty("gotoQaAdminPanel"));
        qaLoginPage = new GotoQaLoginPage(driver);
        String textLoginPage = qaLoginPage.getTextLoginPage();
        Assertions.assertEquals(WORDPRESS_MESSAGE, textLoginPage);

        //Login
        qaLoginPage.authorizationGotoQa(prop.getProperty("gotoQaUserName"), prop.getProperty("gotoQaPassword"));

        adminPanelPage = new GotoQaAdminPanelPage(driver);
        String userNameAdminPanel = adminPanelPage.getUserNameAdminPanel();
        Assertions.assertEquals("gotoQaTest", userNameAdminPanel);

        adminPanelPage.clickLogOutButton();
    }


    @DisplayName("Selenium Page Object. Error Login Test. Junit 5 ParameterizedTest Example.")
    @ParameterizedTest(name = "Run Test#{index} with UserName = [{arguments}]")
    @ValueSource(strings = { "#&%$#&*%$", "gotoQaTest1", "_gotoQaTest"})
    public void incorrectUserNameLoginAdminPanelTest(String incorUserNameParam) {
        driver.get(prop.getProperty("gotoQaAdminPanel"));
        qaLoginPage = new GotoQaLoginPage(driver);
        qaLoginPage.authorizationGotoQa(incorUserNameParam, prop.getProperty("gotoQaPassword"));
        String errorAuthorizationMessage = qaLoginPage.getErrorAuthorizationMessage();
        Assertions.assertEquals(ERROR_MESSAGE_1, errorAuthorizationMessage);
    }


    @DisplayName("Selenium Page Object. Check gotoQa link.")
    @Test
    public void checkBackToGotoQaTest(){
        driver.get(prop.getProperty("gotoQaAdminPanel"));
        qaLoginPage = new GotoQaLoginPage(driver);
        qaLoginPage.clickBackToQa();
        qaHomePage = new GotoQaHomePage(driver);
        String textTitleHomePage = qaHomePage.getTextTitleHomePage();
        Assertions.assertEquals(HOME, textTitleHomePage);
    }


    @DisplayName("Selenium Page Object. Check Remember me & Remember password links.")
    @Test
    public void checkRememberMeAndRememberPasswordTest(){
        driver.get(prop.getProperty("gotoQaAdminPanel"));
        qaLoginPage = new GotoQaLoginPage(driver);
        Assertions.assertTrue(qaLoginPage.rememberMe.isDisplayed());
        Assertions.assertTrue(qaLoginPage.forgetPassword.isDisplayed());
    }


    @DisplayName("Selenium Page Object. Create new post & check on post list page.")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    public void createNewPostTest(String titlePost, String bodyPost){
        driver.get(prop.getProperty("gotoQaAdminPanel"));
        qaLoginPage = new GotoQaLoginPage(driver);
        //Login
        qaLoginPage.authorizationGotoQa(prop.getProperty("gotoQaUserName"), prop.getProperty("gotoQaPassword"));
        adminPanelPage = new GotoQaAdminPanelPage(driver);

        //create new post
        adminPanelPage.createNewPost(titlePost, bodyPost);
    }

}
