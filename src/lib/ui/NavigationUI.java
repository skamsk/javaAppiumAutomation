package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUI extends MainPageObject{

     protected static String
        MY_LISTS_LINK,
        OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void OpenNavigation(){

        if(Platform.getInstance().isMW()){
            this.waitForElementAndClick(OPEN_NAVIGATION,
                    "cannot find and click navigation button",10);
            } else {
            System.out.println("Method openNavigation do nothing this Platform");
        }
    }

    public void clickMyLists()
    {
        if(Platform.getInstance().isMW()){
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My lists",
                    15
            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My lists",
                    5
            );
        }
    }
}
