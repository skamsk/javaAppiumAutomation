package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class SearchPageObject extends MainPageObject{

private static final String
    SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]",
    SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]",
    SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
    SEARCH_CANCEL_RESULT ="xpath://*[contains(@text, 'Search and read the free encyclopedia in your language')]",
    SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
    SEARCH_EMTY_RESULT_ELEMENT = "xpath://*[contains(@text, 'No results found')]";


    public SearchPageObject(AppiumDriver driver)
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
       this.waitForElementAndSendKeys(SEARCH_INPUT, search_line,"cannot find and type into serarch input",5);
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
