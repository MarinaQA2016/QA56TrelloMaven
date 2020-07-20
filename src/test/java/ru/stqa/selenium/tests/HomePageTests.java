package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import ru.stqa.selenium.pages.HomePageHelper;
import org.testng.Assert;

public class HomePageTests extends TestBase {
    HomePageHelper homePage;

    @BeforeMethod
    public void initTests(){
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
    }

    @Test
    public void verifyFooterByCoordinates(){
        homePage.scrollDown(0,10000);
        Assert.assertEquals("About", homePage.getAboutFooter());

    }

    @Test
    public void verifyFooterToViewElement(){
        homePage.scrollDownToViewFooter();
        Assert.assertEquals("About", homePage.getAboutFooter());

    }


}
