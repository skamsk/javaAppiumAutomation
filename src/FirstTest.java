import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;


public class FirstTest extends CoreTestCase {






    //    @Test
//    public void testEx1() {
//           MainPageObject.waitForElementAndClick(
//                   By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                   "cannot Find Search Wikipedia",
//                   5
//           );
//           WebElement title_element = MainPageObject.waitForElementPresent(
//                   By.id("org.wikipedia:id/search_src_text"),
//                   "Cannot Article Java programming language",
//                   15
//           );
//           String article_title = title_element.getAttribute("text");
//
//           assertEquals(
//                   "we see unexpected title!",
//                   "Search…",
//                   article_title
//           );
//       }

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

//           @Test
//    public void testEx4() {
//               MainPageObject.waitForElementAndClick(
//                       By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                       "cannot Find Search Wikipedia",
//                       5
//               );
//               MainPageObject.waitForElementAndSendKeys(
//                       By.xpath("//*[contains(@text, 'Search…')]"),
//                       "Java",
//                       "Cannot find 'Object-oriented programming language' topic searching by Java1",
//                       5
//               );
//               MainPageObject.waitForElementPresent(
//                       By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                       "Cannot Article Java programming language",
//                       15
//               );
//                    List<WebElement> rows = driver.findElements(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and contains(@text,'Java')]"));
//
//                    // print the total number of elements
//                    //System.out.println("Total selected rows are " + rows.size());
//                    //assert (rows.size() == 7);
//                    assertEquals(
//                            "we see not 7 titles with Java",
//                            7,
//                            rows.size()
//                    );
//
//
//           }
//

    @Test
    public void testEx5()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        MainPageObject MainPageObject = new MainPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");


        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();
        String article_title2 = "Programming language";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(article_title2);
        ArticlePageObject.waitForTitleElement();

        ArticlePageObject.addArticleToexistingList(name_of_folder);
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();


        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);

        int amount_of_articles = MainPageObject.getAmountOfElements(
                "id:org.wikipedia:id/page_list_item_container"
        );
        assertTrue(
                "We found >1 articles",
                amount_of_articles ==1
        );
        String article_title_before_open = ArticlePageObject.getArticleTitleInMyList();
        SearchPageObject.clickByArticleWithSubstring(article_title_before_open);
        String article_title_after_open = ArticlePageObject.getArticleTitle();

        assertEquals(
                "we see unexpected title!",
                article_title_before_open,
                article_title_after_open
        );

    }

    @Test
    public void testEx6() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        //ArticlePageObject.waitForTitleElement();
        ArticlePageObject.assertElementPresent("id:org.wikipedia:id/view_page_title_text","Not not found title");

    }
}
