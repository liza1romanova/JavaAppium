package lib.ui.factories;

import lib.Platform;
import lib.ui.NavigationUI;
import lib.ui.android.androidNavigationUI;
import lib.ui.ios.iosNavigationUI;
import lib.ui.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIObjectFactory {

    public static NavigationUI get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new androidNavigationUI(driver);
        } else if (Platform.getInstance().isIOS()){
            return new iosNavigationUI(driver);
        } else {
            return new MWNavigationUI(driver);
        }
    }
}