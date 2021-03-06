package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class SearchPageObject extends MainPageObject{

     protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_CANCEL_RESULT,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMTY_RESULT_ELEMENT;


    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}",substring);
    }
    /* TEMPLATES METHODS */

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON,"cannot find search cancel button",5);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON,"Search cancel button is still present",5);
    }

    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,"cannot find and click search init element",5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT,"cannot find search input after clicking search init element");
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON,"cannot find and click cancel button",5);
    }

    public void typeSearchLine(String search_line)
    {
       this.waitForElementAndSendKeys(SEARCH_INPUT, search_line,"cannot find and type into serarch input",10);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath,"Cannot find search result with substring" + substring);
    }
    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath,"Cannot find and click search result with substring" + substring,10);
    }
    public int getAmountOfFoundArticle()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                15
        );

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);

    }
    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(
                SEARCH_EMTY_RESULT_ELEMENT,
                "Cannot find empty result element",
                15);


    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT,"We supposed not to find any result");
    }

    public void assertCancelSearchInput()
    {
        this.waitForElementPresent(
                SEARCH_CANCEL_RESULT,
                "Cannot find empty result element",
                15);


    }
}
