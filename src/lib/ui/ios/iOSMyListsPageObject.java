package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;


public class iOSMyListsPageObject extends MyListsPageObject {

    static {
        SYNCH = "id:places auth close";
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
        ARTICLI_BY_TITLE_TPL_ID ="id:{TITLE}";

    }

    public iOSMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
