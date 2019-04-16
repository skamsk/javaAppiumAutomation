package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject{

    protected static String
    TITLE_ARTICLE_IN_LIST,
    TITLE,
    TITLE2,
    FOOTER_ELEMENT,
    OPTIONS_BUTTON,
    OPTIONS_ADD_TO_MY_LIST_BUTTON,
    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
    ADD_TO_MY_LIST_OVERLAY,
    MY_LIST_NAME_INPUT,
    MY_LIST_OK_BUTTON,
    CLOSE_ARTICLE_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver)
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
        } if (Platform.getInstance().isIOS()){
        return title_element.getAttribute("name");
        }   else { return title_element.getText();
        }
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
        } else if(Platform.getInstance().isIOS()){
            this.swipeUpTitleElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    60);
        } else {
            this.scrollWebPageElementNotVisible(
                    FOOTER_ELEMENT,
                    "cannot find the end of the article",
                    40
            );
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

    public void addArticleToMySaved()
    {
        if (Platform.getInstance().isMW())
        {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,"Cannot find button add to reading list",10);
    }

    public void removeArticleFromSavedIfItAdded()
    {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "cant click button to remove an article from saved",
                    1
            );
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before"
            );
        }

    }


    public void closeArticle()
    {
        if(Platform.getInstance().isIOS()||Platform.getInstance().isAndroid()){
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find x link",
                    5
            );
        } else {
            System.out.println("Metod close article do nothing this platform");
        }

    }


}
