package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MVArticlePageObject extends ArticlePageObject {

    static {

        TITLE = "css:#content H1";

        FOOTER_ELEMENT = "xpath://*[@class='minerva-footer']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@class='mw-ui-icon mw-ui-icon-element mw-ui-icon-minerva-watch watch-this-article jsonly mw-ui-icon-mf-watch view-border-box']";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON ="xpath://*[@class='mw-ui-icon mw-ui-icon-element mw-ui-icon-minerva-watch watch-this-article jsonly view-border-box mw-ui-icon-mf-watched watched']";
    }

    public MVArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}


