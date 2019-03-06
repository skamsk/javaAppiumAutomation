import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
//    public void TestEx3()
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

           @Test
    public void TestEx3()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "cannot Find Search Wikipedia",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "QA",
                "Cannot find 'Object-oriented programming language' topic searching by Java1",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@class='android.widget.LinearLayout']//*[@index='3']"),
                "Cannot find any elements",
                15
        );
        waitForElementAndClick(
                    By.id("org.wikipedia:id/search_close_btn"),
                    "не найден элемент X",
                    15
            );
        waitForElementPresent(
                By.xpath("//*[contains(@text, 'Search…')]"),
                    "список не пропал",
                    5
            );
        waitForElementNotPresent(
                    By.id("org.wikipedia:id/page_list_item_title"),
                    "непропал список",
                    5
            );

       }





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

//    private WebElement waitForElementPresentById(String id, String error_message, long timeoutInSeconds)
//    {
//        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//        wait.withMessage(error_message + "\n");
//        By by = By.id(id);
//        return  wait.until(ExpectedConditions.presenceOfElementLocated(by));
//    }
//
//    private WebElement waitForElementByIdAndClick(String id, String error_message, long timeoutInSeconds)
//    {
//        WebElement element = waitForElementPresentById(id, error_message, timeoutInSeconds);
//        element.click();
//        return element;
//    }
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


}
