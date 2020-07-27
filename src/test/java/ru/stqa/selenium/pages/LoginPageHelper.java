package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase{

    @FindBy(linkText = "Log In")
    WebElement logInIcon;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "user")
    WebElement userField;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "#error>p")
    WebElement noLoginNoPasswordError;


    public LoginPageHelper(WebDriver driver){
        super(driver);
    }

    public void openLoginPage(){
        logInIcon.click();
        waitUntilElementIsClickable(loginButton,10);
    }

    public void enterLoginAtlassianAndClickLogin(String login) {
        log4j.info("-- Class LoginPageHelper, method enterLoginAtlassianAndClickLogin() was started");
        log4j.info("User field filling, value " + login);
        userField.sendKeys(login);
        log4j.info("Wait until text on the button is 'Log in with Atlassian'");
        waitUntilAttributeValueIs(loginButton,"value","Log in with Atlassian",10);
        log4j.info("Click on the login button ");
        loginButton.click();
        log4j.info("Wait until submit button is clickable");
        waitUntilElementIsClickable(loginSubmitButton,15);
    }

    public void enterPasswordAtlassionAndClickLogin(String password) {
        log4j.info("-- Class LoginPageHelper, method enterPasswordAtlassionAndClickLogin() was started");
        log4j.info("Password field is filling, value " + password);
        passwordField.sendKeys(password);
        log4j.info("Submit button was clicked");
        loginSubmitButton.click();

    }

    public void loginAsAtlassian(String login, String password){
        this.enterLoginAtlassianAndClickLogin(login);
        this.enterPasswordAtlassionAndClickLogin(password);
    }


    public void pressLoginButton() {
        //driver.findElement(By.id("login")).click();
        loginButton.click();
    }

    public void waitErrorMessage() {
        waitUntilElementIsVisible(noLoginNoPasswordError,10);

    }

    public String getErrorMessage(){
        //WebElement errorMessage = driver.findElement(By.cssSelector("#error>p"));
        return noLoginNoPasswordError.getText();
    }

    public LoginPageHelper enterLoginNormal(String login) {
        log4j.info("-- Class LoginPageHelper, method enterLoginNormal("+ login +") was started");
        WebElement loginField = driver.findElement(By.id("user"));
        log4j.info("Login field filling, value " + login);
        loginField.sendKeys(login);
        log4j.info(" Click 'Enter'");
        loginField.sendKeys(Keys.ENTER);
        return this;
    }

    public LoginPageHelper clickLoginButtonNormal() {
        log4j.info("-- Class LoginPageHelper, method clickLoginButtonNormal() was started");
        waitUntilElementIsClickable(loginButton,15);
        //System.out.println("Is loginButton is clickable: " + loginButton.isEnabled());
        loginButton.click();
        return this;
    }

    public void waitErrorMessageLoginIncorrect() {
        log4j.info("-- Class LoginPageHelper, method waitErrorMessageLoginIncorrect() was started");
        waitUntilElementIsVisible(By.xpath("(//*[@class= 'error-message'])[1]"),30);
        WebElement errorMessage = driver.findElement(By.xpath("(//*[@class= 'error-message'])[1]"));
        System.out.println("Error message: " + errorMessage.getText());
    }

    public String getErrorMessageloginIncorrect() {
        WebElement errorMessage = driver.findElement(By.xpath("(//*[@class= 'error-message'])[1]"));
        return errorMessage.getText();
    }

    public void waitErrorMessagePasswordIncorrect() {
        WebElement errorMessageIncorrectPassword;
        waitUntilElementIsVisible(By.xpath("//div[@id='login-error']/span"),15);
    }

    public String getIncorrectPassswordMessage(){
        WebElement errorMessageIncorrectPassword = driver.findElement(By.xpath("//div[@id='login-error']/span"));
        return errorMessageIncorrectPassword.getText();
    }

    public LoginPageHelper enterPasswordNormal(String password) {
        log4j.info("-- Class LoginPageHelper, method enterPasswordNormal("+ password +") was started");
        log4j.info("Password field filling, value " + password);
        fillField(passwordField,password);
        return this;

    }
}
