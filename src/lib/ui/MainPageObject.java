package lib.ui;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lib.Platform;

import javax.xml.bind.Element;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {
    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver)
    {
        this.driver = driver;
    }
    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }



    public WebElement waitForElementPresent(String locator, String error_message, long timeout_InSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeout_InSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresent(String locator, String error_message)
    {
        return waitForElementPresent(locator, error_message, 5);
    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeout_InSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeout_InSeconds);

        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeout_InSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeout_InSeconds);
        element.sendKeys(value);
        return  element;
    }

    public boolean isElementPresent(String locator){
        return getAmountOfElements(locator)>0;
    }

    public void tryClickElementWithFewAttempts(String locator, String error_message, int amount_of_attemps){
        int current_attemps = 0;
        boolean need_more_attempts = true;

        while (need_more_attempts){
            try{
                this.waitForElementAndClick(locator,error_message,1);
                need_more_attempts = false;
            } catch (Exception e) {
                if (current_attemps>amount_of_attemps){
                    this.waitForElementAndClick(locator,error_message,1);
                }
            }
            ++ current_attemps;
        }
    }


    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void swipeUp(int timeOfSwipe)
    {
        if (driver instanceof AppiumDriver)
        {
            TouchAction action = new TouchAction((AppiumDriver) driver);
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
        } else System.out.println("Method swipeUp does nothing this platform " +Platform.getInstance().getPlatformVar());
    }

    public void swipeUpQuick()
    {
        swipeUp(400);
    }

    public void swipeUpToFindElement(String locator, String error_message, int max_swipes)
    {
        By by = this.getLocatorByString(locator);
        int already_swiped = 0;

        while (driver.findElements(by).size() == 0)
        {
            if (already_swiped>max_swipes){
                waitForElementPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }

            swipeUpQuick();
            ++already_swiped;
        }
    }

    public void swipeUpTitleElementAppear(String locator, String eror_message, int max_swipes)
    {
        int already_swiped = 0;
        while (!this.isElementLocatedOnTheScreen(locator))
        {
            if(already_swiped>max_swipes)
            {
                Assert.assertTrue(eror_message,this.isElementLocatedOnTheScreen(locator));
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public void scrollWebPageUp(){
        if(Platform.getInstance().isMW()){
            JavascriptExecutor JExecutor = (JavascriptExecutor)driver;
            JExecutor.executeScript("window.scrollBy(0,250)");
        } else {
            System.out.println("Metod scrollWebPageUp does nothing for Platforms  "+ Platform.getInstance().getPlatformVar());
        }
    }
    public void scrollWebPageElementNotVisible(String locator, String error_message, int maxSwipes){
        int alreadySwipe =0;
        WebElement element = this.waitForElementPresent(locator, error_message);
        while (!this.isElementLocatedOnTheScreen(locator)){
            scrollWebPageUp();
            ++alreadySwipe;
            if(alreadySwipe>maxSwipes){
                Assert.assertTrue(error_message,element.isDisplayed());
            }
        }
    }

    public boolean isElementLocatedOnTheScreen(String locator)
    {
        int element_location_by_y = this.waitForElementPresent(locator,"cannot find element",1).getLocation().getY();
        if (Platform.getInstance().isMW()){
           JavascriptExecutor JExecutor = (JavascriptExecutor) driver;
           Object JSresult = JExecutor.executeScript("return window.pageYOffset");
           element_location_by_y -= Integer.parseInt(JSresult.toString());
        }
        int screen_size_by_y = driver.manage().window().getSize().getHeight();
        return element_location_by_y<screen_size_by_y;
    }

    public void clickElementToTheRightUpperCorner(String locator , String error_message)
    {
        if (driver instanceof AppiumDriver){
        WebElement element = this.waitForElementPresent(locator+ "/..",error_message);

        int right_x = element.getLocation().getX();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;
        int width = element.getSize().getWidth();

        int point_to_click_x = (right_x + width)-3;
        int point_to_click_y = middle_y;
        TouchAction action = new TouchAction((AppiumDriver)driver);
        action.tap(point_to_click_x,point_to_click_y).perform();
        } else System.out.println("Method clickElementToTheRightUpperCorner does nothing this platform " +Platform.getInstance().getPlatformVar());



    }

    public void swipeElementToLeft(String locator, String error_message) {
        if (driver instanceof AppiumDriver) {
            WebElement element = waitForElementPresent(locator, error_message, 10);

            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;

            TouchAction action = new TouchAction((AppiumDriver)driver);
            action.press(right_x, middle_y);
            action.waitAction(300);

            if (Platform.getInstance().isAndroid()) {
                action.moveTo(left_x, middle_y);
            } else {
                int ofset_x = (-1 * element.getSize().getWidth());
                action.moveTo(ofset_x, 0);
            }

            action.release();
            action.perform();
        } else System.out.println("Method clickElementToTheRightUpperCorner does nothing this platform " +Platform.getInstance().getPlatformVar());
    }

    public int getAmountOfElements(String locator)
    {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return  elements.size();
    }

    public void assertElementPresent(String locator, String error_message)
    {

        int amount_of_titles = getAmountOfElements(locator);
        Assert.assertTrue("We not found titles",amount_of_titles ==1 );
    }

    public void assertElementNotPresent(String locator, String error_message)
    {
        int amount_of_titles = getAmountOfElements(locator);
        Assert.assertTrue("We found titles",amount_of_titles ==0 );
    }

    public void assertTitlePresent(String locator) {
        this.assertElementPresent(locator,
                "Title not found"
        );
    }

    private By getLocatorByString(String locator_with_type)
    {
        String[] exploded_locator=locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        }  else if (by_type.equals("css")) {
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("cannot get type locator, Locator ="+locator_with_type);
        }
    }

}
