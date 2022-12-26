import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.net.URL;

public class Appium {

    AndroidDriver<AndroidElement> driver;

    WebDriverWait wait;

    @BeforeClass
    void setup() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.google.android.deskclock");
        capabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("automationName", "UIAutomator2");
        URL url = new URL("http://127.0.0.1:4723/wd/hub/");
        driver = new AndroidDriver<>(url, capabilities);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    void addWorldClock(){
        MobileElement citiesBtn = driver.findElementById(K.CLOCK + "id/fab");
        citiesBtn.click();
        MobileElement searchBtn = (MobileElement)wait.until(ExpectedConditions.presenceOfElementLocated(By.id(K.CLOCK + "id/search_button")));
        searchBtn.click();
        MobileElement searchField = driver.findElementById(K.CLOCK + "id/search_src_text");
        searchField.sendKeys("New");
        MobileElement cityName = driver.findElementById(K.CLOCK + "id/city_name");
        MobileElement checkbox = driver.findElementById(K.CLOCK + "id/city_onoff");
        checkbox.click();
        System.out.println(cityName.getText() + " added to clock screen");
        MobileElement backBtn = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
        backBtn.click();
    }
}
