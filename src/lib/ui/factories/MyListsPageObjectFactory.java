package lib.ui.factories;

import lib.Platform;
import lib.ui.MyListsPageObject;
import lib.ui.android.AndroidMyListsPageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.ios.iOSMyListsPageObject;
import lib.ui.ios.iOSSearchPageObject;
import lib.ui.mobile_web.MVMylistsPageObject;
import lib.ui.mobile_web.MVSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;


public class MyListsPageObjectFactory {
    public  static MyListsPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        }
        else if(Platform.getInstance().isIOS())
        { return new iOSMyListsPageObject(driver);}
        else
        {return new MVMylistsPageObject(driver);}
    }
}

