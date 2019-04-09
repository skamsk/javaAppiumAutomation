package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;

abstract public class ArticlePageObject extends MainPageObject{

    protected static String
    TITLE_ARTICLE_IN_LIST,
    TITLE,
    TITLE2,
    FOOTER_ELEMENT,
    OPTIONS_BUTTON,
    OPTIONS_ADD_TO_MY_LIST_BUTTON,
    ADD_TO_MY_LIST_OVERLAY,
    MY_LIST_NAME_INPUT,
    MY_LIST_OK_BUTTON,
    CLOSE_ARTICLE_BUTTON;

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE,"Cannot find article title on page!",15);
    }

    public WebElement waitForTitle2Element()
    {
        return this.waitForElementPresent(TITLE2,"Cannot find article title on page!",15);
    }
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if(Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        }
        return title_element.getAttribute("name");
    }

    public String getArticleTitle2()
    {
        WebElement title_element = waitForTitle2Element();
        if(Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        }
        return title_element.getAttribute("name");
    }

    public String getArticleTitleInMyList()
    {
        WebElement title_element = waitForTitleElementInMyList();
        return title_element.getAttribute("text");
    }

    public WebElement waitForTitleElementInMyList()
    {
        return this.waitForElementPresent(TITLE_ARTICLE_IN_LIST,"Cannot find article in my list!",15);
    }

    public void swipeToFooter()
    {
        if(Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    60);
        } else {
            this.swipeUpTitleElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    60);
        }
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find Add to reading list",
                5
        );
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find GOT IT",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot clear title reading list title",
                5
        );


        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "can not input title",
                5
        );
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK",
                5
        );
    }

    public void addArticleToexistingList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find Add to reading list",
                5
        );
    }

    public void addArticleToMySaved(){
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,"Cannot find button add to reading list",10);
    }


    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find x link",
                5
        );
    }


}
