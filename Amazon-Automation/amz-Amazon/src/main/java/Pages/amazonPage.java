package Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import BasicPackage.BaseClass;
import io.qameta.allure.Step;

public class amazonPage {
    WebDriver driver;
    public amazonPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Wait For Page Fully Loaded")
            public amazonPage waitForPagLoad()
        throws IOException {
        BaseClass.waitForPageLoad();
        BaseClass.captureScreenshot();
        System.out.println("Page has fully loaded");
        return this;
    }

    By Amazon_MainPage_SignIn_id = By.id("nav-link-accountList");
    @Step("Mouse Hover to the Account List Section")
    public amazonPage MouseHoverAccountList()
        throws IOException {
        System.out.println("User Mouse Hover to Account List Header");
        BaseClass.mouseHover(Amazon_MainPage_SignIn_id);
        BaseClass.captureScreenshot();
        return this;
    }

    By Amazon_MainPage_SignInButton_xpath = By.xpath("//span[@class='nav-action-inner']");
    @Step("Click Sign In Button in Amazon Main Page")
    public amazonPage clickSignButton()
        throws IOException {
        System.out.println("User click Sign in button");
        BaseClass.click(Amazon_MainPage_SignInButton_xpath);
        BaseClass.captureScreenshot();
        return this;
    }

    By Amazon_LoginPage_emailMobileNumberField_id = By.id("ap_email_login");
    @Step("Enter Mobile Number Or Email user")
    public amazonPage enterMobileNumberOrEmail(String emailUser)
        throws IOException {
        System.out.println("User input Mobile Number or Emails user in login field");
        BaseClass.enterText(Amazon_LoginPage_emailMobileNumberField_id, emailUser);
        BaseClass.captureScreenshot();
        return this;
    }

    By Amazon_LoginPage_ContinueButton_id = By.id("continue-announce");
    @Step("Click Continue Button")
    public amazonPage clickContinueButton()
        throws IOException {
        System.out.println("User Click Continue Button After Input Email");
        BaseClass.click(Amazon_LoginPage_ContinueButton_id);
        BaseClass.captureScreenshot();
        return this;
    }

    By Amazon_LoginPage_PasswordField_id = By.id("ap_password");
    @Step("Enter Password")
    public amazonPage enterPassword(String pass)
        throws IOException {
        System.out.println("User input password in password field");
        BaseClass.enterText(Amazon_LoginPage_PasswordField_id, pass);
        BaseClass.captureScreenshot();
        return this;
    }

    By Amazon_LoginPage_SignInButton_id = By.id("signInSubmit");
    @Step("Click Sign In Button")
    public amazonPage clickSignInButton()
        throws IOException {
        System.out.println("User Click Sign In Button");
        BaseClass.click(Amazon_LoginPage_SignInButton_id);
        BaseClass.captureScreenshot();
        return this;
    }

    By Amazon_MainPage_SignOutButton_id = By.id("nav-item-signout");
    @Step("Click Sign Out Button")
    public amazonPage clickSignOutButton()
        throws IOException {
        System.out.println("User Click Sign Out Button");
        BaseClass.click(Amazon_MainPage_SignOutButton_id);
        BaseClass.captureScreenshot();
        return this;
    }

}
