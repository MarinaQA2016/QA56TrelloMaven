package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardsPageHelper extends PageBase {
    @FindBy(xpath = "//button[@data-test-id='header-boards-menu-button']/span[2]")
    WebElement boardsIcon;

    @FindBy(xpath = "//button[@data-test-id = 'header-member-menu-button']")
    WebElement upperRight;

    public BoardsPageHelper(WebDriver driver) {
        super(driver);
    }


    public void waitUntilPageIsLoaded() {
        log4j.info("-- Class BoardsPageHelper, method waitUntilPageIsLoaded() was started");
        log4j.info("Wait until board icon is clickable");
        waitUntilElementIsClickable(boardsIcon,40);
        log4j.info("Wait until upper right menu is clickable");
        waitUntilElementIsClickable(upperRight,20);
    }

    public String getButtonBoardsText(){
        return boardsIcon.getText();
    }
}
