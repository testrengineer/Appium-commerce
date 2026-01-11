package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;

public class BaseTest {

    protected static AndroidDriver driver;

    public void setup() throws Exception {
        UiAutomator2Options option = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setPlatformName("Android")
                .setApp(System.getProperty("user.dir")
                        + "/apps/mda-2.2.0-25.apk")
                .setAppWaitActivity("*");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                option
        );
    }

    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
