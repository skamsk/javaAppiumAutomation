package lib;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
//import io.appium.java_client.ios.IOSDriver;

public class CoreTestCase extends TestCase {


    protected RemoteWebDriver driver;
    //protected Platform Platform;


    @Override
    protected void setUp() throws Exception {
        super.setUp();


        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomeForIOSApp();
        this.openWikiHomePageForMobileWeb();
    }


    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait() {
        if (driver instanceof AppiumDriver)
        {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPortrait() does nothing this platform " +Platform.getInstance().getPlatformVar());
        }


    }

    protected void rotateScreenLandscape() {
        if (driver instanceof AppiumDriver)
    {
        AppiumDriver driver = (AppiumDriver) this.driver;
        driver.rotate(ScreenOrientation.LANDSCAPE);
    } else {
        System.out.println("Method rotateScreenLandscape does nothing this platform " +Platform.getInstance().getPlatformVar());
    }


    }

    protected void backgroundApp(int seconds) {
        if (driver instanceof AppiumDriver)
        {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(seconds);
        } else {
            System.out.println("Method backgroundApp does nothing this platform " +Platform.getInstance().getPlatformVar());
        }
    }

    protected void openWikiHomePageForMobileWeb()
    {
        if(Platform.getInstance().isMW()){
            driver.get("https://en.m.wikipedia.org");
        } else System.out.println("Method backgroundApp does nothing this platform " +Platform.getInstance().getPlatformVar());
    }

    private void skipWelcomeForIOSApp() {
        if (Platform.getInstance().isIOS()) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }

    }
}

