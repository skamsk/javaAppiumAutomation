package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class MyListsPageObject extends MainPageObject{

    protected static String
        SYNCH,
        FOLDER_BY_NAME_TPL,
        ARTICLI_BY_TITLE_TPL_ID,
        REMOVE_FROM_SAVED_BUTTON,
        ARTICLE_BY_TITLE_TPL,
        CONTAINS_TEXT_LOCATOR;


    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);
    }

    private static String getRemoveButtonByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    private static String getSaveArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    private static String getSaveArticleIdByTitle(String article_title)
    {
        return ARTICLI_BY_TITLE_TPL_ID.replace("{TITLE}", article_title);
    }

    private static String getSaveTextLoactor(String text)
    {
        return CONTAINS_TEXT_LOCATOR.replace("{TEXT}", text);
    }



    public MyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder byname "+name_of_folder,
                15
        );
    }

    public void waitForArticleToAappearByTitle(String article_title)
    {
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath,"Cannot find saved article by title "+ article_title,15);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_xpath,"Saved article still present with title "+article_title,15);
    }

    public void waitForArticleToDisappearByID(String article_title)
    {
        String article_id = getSaveArticleIdByTitle(article_title);
        this.waitForElementNotPresent(article_id,"Saved article still present with title "+ article_title,15);
    }

    public void waitForElementWithText(String text)
    {
        String text_locator = getSaveTextLoactor(text);

        this.waitForElementPresent(text_locator, "Not found element with text"+text);
    }

    public void swipeByArticleToDelete(String article_title)
    {
        if(Platform.getInstance().isIOS()){
            this.waitForElementAndClick(SYNCH,"Cannot find element Synh", 10);
       }

        this.waitForArticleToAappearByTitle(article_title);
        String article_xpath = getSaveArticleXpathByTitle(article_title);

        if(Platform.getInstance().isIOS()||Platform.getInstance().isAndroid()){
            this.swipeElementToLeft(
                    article_xpath,
                    "Cannot find saved article"
            );
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(remove_locator,
                    "cannot find button to remove",
                    10);
        }



        if(Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_xpath,"Cannot find saved article");
        }
        if (Platform.getInstance().isMW()){
            driver.navigate().refresh();
        }

        this.waitForElementWithText("JavaScript");
        //this.waitForArticleToDisappearByID(article_title);
    }

}
