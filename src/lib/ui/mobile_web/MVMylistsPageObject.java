package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MVMylistsPageObject extends MyListsPageObject {
    static {
        SYNCH = "id:places auth close";
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]";
        ARTICLI_BY_TITLE_TPL_ID ="id:{TITLE}";
        CONTAINS_TEXT_LOCATOR ="xpath://*[contains(text(),'{TEXT}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]/../../div[contains(@class,'watched')]";
    }

    public MVMylistsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}


