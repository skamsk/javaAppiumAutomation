package lib.ui.factories;

import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.android.AndroidArticlePageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.ios.iOSArticlePageObject;
import lib.ui.ios.iOSSearchPageObject;
import lib.ui.mobile_web.MVArticlePageObject;
import lib.ui.mobile_web.MVSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ArticlePageObjectFactory {
    public  static ArticlePageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidArticlePageObject(driver);
        }
        else if(Platform.getInstance().isIOS())
             return new iOSArticlePageObject(driver);
        else
             return new MVArticlePageObject(driver);
    }
}
