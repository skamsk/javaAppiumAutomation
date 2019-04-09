package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;


public class iOSMyListsPageObject extends MyListsPageObject {

    static {
        SYNCH = "id:places auth close";
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";

    }

    public iOSMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
