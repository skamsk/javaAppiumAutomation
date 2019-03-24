import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;


public class FirstTest extends CoreTestCase {






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

           assertEquals(
                   "we see unexpected title!",
                   "Search…",
                   article_title
           );
       }

   // @Test
//    public void TestEx2()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        WebElement title_element = waitForElementPresent(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Cannot Article Java programming language",
//                15
//        );
//        String article_title = title_element.getAttribute("text");
//
//        assertEquals(
//                "we see unexpected title!",
//                "Search…",
//                article_title
   //   );


    @Test
    public void testEx3()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("QA");
        int amount_of_search_result = SearchPageObject.getAmountOfFoundArticle();
        assertTrue(
                "We found too few results",
                amount_of_search_result >0
        );

        SearchPageObject.clickCancelSearch();
        SearchPageObject.assertCancelSearchInput();
        SearchPageObject.assertThereIsNoResultOfSearch();

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
                    assertEquals(
                            "we see not 7 titles with Java",
                            7,
                            rows.size()
                    );


           }


    @Test
    public void testEx5()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");


        ArticlePageObject.waitForTitleElement();


        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot Article Java programming language",
//                15
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='Add to reading list']"),
//                "Cannot find Add to reading list",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/onboarding_button"),
//                "Cannot find GOT IT",
//                5
//        );
//
//        MainPageObject.waitForElementAndClear(
//                By.id("org.wikipedia:id/text_input"),
//                "Cannot clear title reading list title",
//                5
//        );
//
//        String name_of_folder = "Learning programming";
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/text_input"),
//                name_of_folder,
//                "can not input title",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='OK']"),
//                "Cannot press OK",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot close article, cannot find x link",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Cannot find 'Object-oriented programming language' topic searching by Java",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Wikimedia list article']"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Java version history not visible",
//                15
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Add to reading list')]"),
//                "cannot add to reading list2",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Learning programming')]"),
//                "can not add to learning programming",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot close article, cannot find x link",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
//                "Cannot find navigation button to My lists",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, '"+name_of_folder+"')]"),
//                "Cannot find My reading list",
//                5
//        );
//        MainPageObject.swipeElementToLeft(
//                By.xpath("//*[@text='object-oriented programming language']"),
//                "can not swipe"
//        );
//        MainPageObject.waitForElementNotPresent(
//                By.xpath("//*[@text='object-oriented programming language']"),
//                "can not delete article",
//                5
//        );
//        int amount_of_articles = MainPageObject.getAmountOfElements(
//                By.id("org.wikipedia:id/page_list_item_container")
//        );
//        assertTrue(
//                "We found >1 articles",
//                amount_of_articles ==1
//        );
//
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='Java version history']"),
//                "Cannot find Java version history",
//                5
//        );
//        WebElement title_element = MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot Article Java version history",
//                5
//        );
//        String article_title = title_element.getAttribute("text");
//
//        assertEquals(
//                "we see unexpected title!",
//                "Java version history",
//                article_title
//        );
    }



    @Test
    public void testEx6() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        //ArticlePageObject.waitForTitleElement();
        ArticlePageObject.assertTitlePresent();


    }








}
