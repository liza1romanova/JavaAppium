package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class androidNavigationUI extends NavigationUI {
        static {
            MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
        }

public androidNavigationUI(RemoteWebDriver driver){
            super(driver);
        }
}
