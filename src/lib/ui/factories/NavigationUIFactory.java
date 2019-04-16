package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.NavigationUI;
import lib.ui.android.AndroidNavigationUI;
import lib.ui.ios.iOSNavigationUI;
import lib.ui.ios.iOSSearchPageObject;
import lib.ui.mobile_web.MVNavigationUI;
import lib.ui.mobile_web.MVSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory {
    public  static NavigationUI get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUI(driver);
        } else if(Platform.getInstance().isIOS())
        { return new iOSNavigationUI(driver);}
        else
        {return new MVNavigationUI(driver);}
    }
    }

