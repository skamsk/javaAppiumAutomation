import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import java.util.List;


public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch()
        {
            SearchPageObject SearchPageObject = new SearchPageObject(driver);
            SearchPageObject.initSearchInput();
            SearchPageObject.waitForCancelButtonToAppear();
            SearchPageObject.clickCancelSearch();
            SearchPageObject.waitForCancelButtonToDisappear();


        }

    @Test
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        String article_title = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "we see unexpected title!",
                "Java (programming language)",
                article_title
        );
    }
    @Test
    public void testSwipeArticle() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Appium");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();
      }


       @Test
    public void testEx1() {
           MainPageObject.waitForElementAndClick(
                   By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                   "cannot Find Search Wikipedia",
                   5
           );
           WebElement title_element = MainPageObject.waitForElementPresent(
                   By.id("org.wikipedia:id/search_src_text"),
                   "Cannot Article Java programming language",
                   15
           );
           String article_title = title_element.getAttribute("text");

           Assert.assertEquals(
                   "we see unexpected title!",
                   "Search…",
                   article_title
           );
       }
           @Test
    public void testEx3()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "cannot Find Search Wikipedia",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "QA",
                "Cannot find 'Object-oriented programming language' topic searching by Java1",
                5
        );
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@class='android.widget.LinearLayout']//*[@index='3']"),
                "Cannot find any elements",
                15
        );
        MainPageObject.waitForElementAndClick(
                    By.id("org.wikipedia:id/search_close_btn"),
                    "не найден элемент X",
                    15
            );
        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text, 'Search…')]"),
                    "список не пропал",
                    5
            );
        MainPageObject.waitForElementNotPresent(
                    By.id("org.wikipedia:id/page_list_item_title"),
                    "непропал список",
                    5
            );

       }

           @Test
    public void testEx4() {
               MainPageObject.waitForElementAndClick(
                       By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                       "cannot Find Search Wikipedia",
                       5
               );
               MainPageObject.waitForElementAndSendKeys(
                       By.xpath("//*[contains(@text, 'Search…')]"),
                       "Java",
                       "Cannot find 'Object-oriented programming language' topic searching by Java1",
                       5
               );
               MainPageObject.waitForElementPresent(
                       By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                       "Cannot Article Java programming language",
                       15
               );
                    List<WebElement> rows = driver.findElements(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and contains(@text,'Java')]"));

                    // print the total number of elements
                    //System.out.println("Total selected rows are " + rows.size());
                    //assert (rows.size() == 7);
                    Assert.assertEquals(
                            "we see not 7 titles with Java",
                            7,
                            rows.size()
                    );


           }



    @Test
    public void testsaveFirstArticleToMyList() {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "cannot Find Search Wikipedia",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by Java1",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "cannot Find Search Wikipedia",
                5
        );
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot Article Java programming language",
                15
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find Add to reading list",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find GOT IT",
                5
        );

        MainPageObject.waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot clear title reading list title",
                5
        );

        String name_of_folder = "Learning programming";

        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "can not input title",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find x link",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to My lists",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, '" + name_of_folder + "')]"),
                "Cannot find My reading list",
                5
        );
        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='object-oriented programming language']"),
                "can not swipe"
        );
        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='object-oriented programming language']"),
                "can not delete article",
                5
        );
    }
    @Test
    public void testEx6() {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "cannot Find Search Wikipedia",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by Java",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "cannot Find Search Wikipedia",
                5
        );
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot Article Java programming language",
                15
        );
        MainPageObject.assertElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Title not found"
        );


    }



    @Test
    public void testArticleInRotation() {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "cannot Find Search Wikipedia",
                5
        );
        String search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search_line,
                "Cannot find 'Object-oriented programming language' topic searching by Java",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "cannot find 'Object-oriented programming language' topic searching by " + search_line,
                15
        );
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot Article Java programming language",
                15
        );
        MainPageObject.assertElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Title not found"
        );


        String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                15
        );
        Assert.assertEquals(
                "article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );
    }

@Test
public void testTitleInBackGround() {
    MainPageObject.waitForElementAndClick(
            By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
            "cannot Find Search Wikipedia",
            5
    );
    String search_line = "Java";
    MainPageObject.waitForElementAndSendKeys(
            By.xpath("//*[contains(@text, 'Search…')]"),
            search_line,
            "Cannot find 'Object-oriented programming language' topic searching by Java",
            5
    );
    MainPageObject.waitForElementPresent(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
            "cannot find 'Object-oriented programming language' topic searching by " + search_line,
            15
    );
    driver.runAppInBackground(15);

    MainPageObject.waitForElementPresent(
            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
            "cannot find article after returning from bsckground",
            15
    );
    }

    @Test
    public void testEx5()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "cannot Find Search Wikipedia",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by Java",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "cannot Find Search Wikipedia",
                5
        );
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot Article Java programming language",
                15
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find Add to reading list",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find GOT IT",
                5
        );

        MainPageObject.waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot clear title reading list title",
                5
        );

        String name_of_folder = "Learning programming";

        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "can not input title",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find x link",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "cannot Find Search Wikipedia",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by Java",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Wikimedia list article']"),
                "cannot Find Search Wikipedia",
                5
        );
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Java version history not visible",
                15
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );
        MainPageObject.waitForElementAndClick(
                       By.xpath("//*[contains(@text, 'Add to reading list')]"),
                       "cannot add to reading list2",
                      5
               );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Learning programming')]"),
                "can not add to learning programming",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find x link",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to My lists",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, '"+name_of_folder+"')]"),
                "Cannot find My reading list",
                5
        );
        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='object-oriented programming language']"),
                "can not swipe"
        );
        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='object-oriented programming language']"),
                "can not delete article",
                5
        );
        int amount_of_articles = MainPageObject.getAmountOfElements(
                By.id("org.wikipedia:id/page_list_item_container")
        );
        Assert.assertTrue(
                "We found >1 articles",
                amount_of_articles ==1
        );


        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Java version history']"),
                "Cannot find Java version history",
                5
        );
        WebElement title_element = MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot Article Java version history",
                5
        );
        String article_title = title_element.getAttribute("text");

        Assert.assertEquals(
                "we see unexpected title!",
                "Java version history",
                article_title
        );
    }



}
