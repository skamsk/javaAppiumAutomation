import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public  void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:\\Users\\1\\Desktop\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public  void tearDown()
    {
        driver.quit();
    }

//    @Test
//    public void FirstTest()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Cannot find 'Object-oriented programming language' topic searching by Java1",
//                 5
//        );
//        waitForElementPresent(
//        By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//         "Cannot find 'Object-oriented programming language' topic searching by Java2",
//                5
//        );
//    }
//    @Test
//    public void testCancelSearch()
//        {
//            waitForElementAndClick(
//                    By.id("org.wikipedia:id/search_container"),
//                    "не найден элемент search_container по ID",
//                    5
//            );
//            waitForElementAndSendKeys(
//                    By.xpath("//*[contains(@text, 'Search…')]"),
//                    "Java",
//                    "Cannot find 'Object-oriented programming language' topic searching by Java1",
//                    5
//            );
//
//            waitForElementAndClear(
//                    By.id("org.wikipedia:id/search_src_text"),
//                    "Не смог отчистить",
//                    5
//            );
//
//            waitForElementAndClick(
//                    By.id("org.wikipedia:id/search_close_btn"),
//                    "не найден элемент search_close_btn по ID",
//                    5
//            );
//            waitForElementNotPresent(
//                    By.id("org.wikipedia:id/search_close_btn"),
//                    "непропал Х по ID",
//                    5
//            );
//        }

//    @Test
//    public void testCompareArticleTitle()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Cannot find 'Object-oriented programming language' topic searching by Java1",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        WebElement title_element = waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot Article Java programming language",
//                15
//        );
//        String article_title = title_element.getAttribute("text");
//
//        Assert.assertEquals(
//                "we see unexpected title!",
//                "Java (programming language)",
//                article_title
//        );
//}
//       @Test
//    public void TestEx1()
//       {
//           waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//           WebElement title_element = waitForElementPresent(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Cannot Article Java programming language",
//                15
//        );
//        String article_title = title_element.getAttribute("text");
//
//        Assert.assertEquals(
//                "we see unexpected title!",
//                "Search…",
//                article_title
//        );

//           @Test
//    public void TestEx3()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "QA",
//                "Cannot find 'Object-oriented programming language' topic searching by Java1",
//                5
//        );
//        waitForElementPresent(
//                By.xpath("//*[@class='android.widget.LinearLayout']//*[@index='3']"),
//                "Cannot find any elements",
//                15
//        );
//        waitForElementAndClick(
//                    By.id("org.wikipedia:id/search_close_btn"),
//                    "не найден элемент X",
//                    15
//            );
//        waitForElementPresent(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                    "список не пропал",
//                    5
//            );
//        waitForElementNotPresent(
//                    By.id("org.wikipedia:id/page_list_item_title"),
//                    "непропал список",
//                    5
//            );
//
//       }
//
//           @Test
//    public void TestEx4() {
//               waitForElementAndClick(
//                       By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                       "cannot Find Search Wikipedia",
//                       5
//               );
//               waitForElementAndSendKeys(
//                       By.xpath("//*[contains(@text, 'Search…')]"),
//                       "Java",
//                       "Cannot find 'Object-oriented programming language' topic searching by Java1",
//                       5
//               );
//               waitForElementPresent(
//                       By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                       "Cannot Article Java programming language",
//                       15
//               );
//                    List<WebElement> rows = driver.findElements(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and contains(@text,'Java')]"));
//
//                    // print the total number of elements
//                    //System.out.println("Total selected rows are " + rows.size());
//                    //assert (rows.size() == 7);
//                    Assert.assertEquals(
//                            "we see not 7 titles with Java",
//                            7,
//                            rows.size()
//                    );
//
//
//           }

//    @Test
//    public void testSwipeArticle() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Appium",
//                "Cannot find 'Object-oriented programming language' topic searching by Java1",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
//                "cannot Find Appium in Search",
//                5
//        );
//        waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot Article Java programming language",
//                15
//        );
//        swipeUpToFindElement(
//                By.xpath("//*[@text='View page in browser']"),
//                "Cannot find the end of the article",
//                20
//        );
//    }

//    @Test
//    public void saveFirstArticleToMyList()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Cannot find 'Object-oriented programming language' topic searching by Java1",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot Article Java programming language",
//                15
//        );
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[@text='Add to reading list']"),
//                "Cannot find Add to reading list",
//                5
//        );
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/onboarding_button"),
//                "Cannot find GOT IT",
//                5
//        );
//
//        waitForElementAndClear(
//                By.id("org.wikipedia:id/text_input"),
//                "Cannot clear title reading list title",
//                5
//        );
//
//        String name_of_folder = "Learning programming";
//
//        waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/text_input"),
//                name_of_folder,
//                "can not input title",
//                5
//         );
//        waitForElementAndClick(
//                By.xpath("//*[@text='OK']"),
//                "Cannot press OK",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot close article, cannot find x link",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
//                "Cannot find navigation button to My lists",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, '"+name_of_folder+"')]"),
//                "Cannot find My reading list",
//                5
//        );
//        swipeElementToLeft(
//                By.xpath("//*[@text='object-oriented programming language']"),
//                        "can not swipe"
//        );
//        waitForElementNotPresent(
//                By.xpath("//*[@text='object-oriented programming language']"),
//                "can not delete article",
//                5
//        );

    @Test
    public void Ex6() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "cannot Find Search Wikipedia",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by Java",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "cannot Find Search Wikipedia",
                5
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot Article Java programming language",
                15
        );
        assertElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Title not found"
        );


    }


//    @Test
//    public void Ex5()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Cannot find 'Object-oriented programming language' topic searching by Java",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot Article Java programming language",
//                15
//        );
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[@text='Add to reading list']"),
//                "Cannot find Add to reading list",
//                5
//        );
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/onboarding_button"),
//                "Cannot find GOT IT",
//                5
//        );
//
//        waitForElementAndClear(
//                By.id("org.wikipedia:id/text_input"),
//                "Cannot clear title reading list title",
//                5
//        );
//
//        String name_of_folder = "Learning programming";
//
//        waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/text_input"),
//                name_of_folder,
//                "can not input title",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[@text='OK']"),
//                "Cannot press OK",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot close article, cannot find x link",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                "Java",
//                "Cannot find 'Object-oriented programming language' topic searching by Java",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Wikimedia list article']"),
//                "cannot Find Search Wikipedia",
//                5
//        );
//        waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Java version history not visible",
//                15
//        );
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                5
//        );
//
//        waitForElementAndClick(
//                       By.xpath("//*[contains(@text, 'Add to reading list')]"),
//                       "cannot add to reading list2",
//                      5
//               );
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Learning programming')]"),
//                "can not add to learning programming",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot close article, cannot find x link",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
//                "Cannot find navigation button to My lists",
//                5
//        );
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, '"+name_of_folder+"')]"),
//                "Cannot find My reading list",
//                5
//        );
//        swipeElementToLeft(
//                By.xpath("//*[@text='object-oriented programming language']"),
//                "can not swipe"
//        );
//        waitForElementNotPresent(
//                By.xpath("//*[@text='object-oriented programming language']"),
//                "can not delete article",
//                5
//        );
//        int amount_of_articles = getAmountOfElements(
//                By.id("org.wikipedia:id/page_list_item_container")
//        );
//        Assert.assertTrue(
//                "We found >1 articles",
//                amount_of_articles ==1
//        );
//
//
//        waitForElementAndClick(
//                By.xpath("//*[@text='Java version history']"),
//                "Cannot find Java version history",
//                5
//        );
//        WebElement title_element = waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot Article Java version history",
//                5
//        );
//        String article_title = title_element.getAttribute("text");
//
//        Assert.assertEquals(
//                "we see unexpected title!",
//                "Java version history",
//                article_title
//        );
//    }





    private WebElement waitForElementPresent(By by, String error_message, long timeout_InSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout_InSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeout_InSeconds)
        {
        WebElement element = waitForElementPresent(by, error_message, timeout_InSeconds);
        element.click();
        return
                element;
        }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeout_InSeconds)
        {
            WebElement element = waitForElementPresent(by, error_message, timeout_InSeconds);
            element.sendKeys(value);
            return    element;
        }


    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    protected void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
    }

    protected void swipeUpQuick()
    {
        swipeUp(200);
    }

    protected void swipeUpToFindElement(By by, String error_message, int max_swipes)
    {
        int already_swiped = 0;

        while (driver.findElements(by).size() == 0)
        {
            if (already_swiped>max_swipes){
                waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }

            swipeUpQuick();
            ++already_swiped;
        }
    }

    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(by,error_message,10 );

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(600)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }

    private int getAmountOfElements(By by)
    {
        List elements = driver.findElements(by);
        return  elements.size();
    }

    private void assertElementPresent(By by, String error_message)
    {
        int amount_of_titles = getAmountOfElements(by);
        Assert.assertTrue("We not found titles",amount_of_titles ==1 );
    }

}
