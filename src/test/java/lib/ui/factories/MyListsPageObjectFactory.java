package lib.ui.factories;

import lib.Platform;
import lib.ui.MyListsPageObject;
import lib.ui.android.androidMyListsPageObject;
import lib.ui.ios.iosMyListsPageObject;
import lib.ui.mobile_web.MWMyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObjectFactory {

    public static MyListsPageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new androidMyListsPageObject(driver);
        } else  if (Platform.getInstance().isIOS()){
            return new iosMyListsPageObject(driver);
        } else {
            return new MWMyListsPageObject(driver);
        }
    }
}
