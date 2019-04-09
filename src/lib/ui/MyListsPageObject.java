package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import lib.Platform;


abstract public class MyListsPageObject extends MainPageObject{

    protected static String
        SYNCH,
        FOLDER_BY_NAME_TPL,
        ARTICLI_BY_TITLE_TPL_ID,
        ARTICLE_BY_TITLE_TPL;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);
    }

    private static String getSaveArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    private static String getSaveArticleIdByTitle(String article_title)
    {
        return ARTICLI_BY_TITLE_TPL_ID.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(AppiumDriver driver)
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


    public void swipeByArticleToDelete(String article_title)
    {
        if(Platform.getInstance().isIOS()){
            this.waitForElementAndClick(SYNCH,"Cannot find element Synh", 10);
       }

        this.waitForArticleToAappearByTitle(article_title);
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
               article_xpath,
                "Cannot find saved article"
        );

        if(Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_xpath,"Cannot find saved article");
        }

        this.waitForArticleToDisappearByID(article_title);
    }

}
