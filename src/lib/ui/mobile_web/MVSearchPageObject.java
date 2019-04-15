package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MVSearchPageObject extends SearchPageObject {

    static {
        //SEARCH_INIT_ELEMENT ="xpath://a[contains(text(),'Open main menu')]";
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";


        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMTY_RESULT_ELEMENT = "css:p.without-results";
        SEARCH_CANCEL_RESULT = "xpath://*[contains(@text, 'Search and read the free encyclopedia in your language')]";
    }

    public MVSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}