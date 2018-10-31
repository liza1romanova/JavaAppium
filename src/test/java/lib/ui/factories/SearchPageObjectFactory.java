package lib.ui.factories;

import lib.Platform;
import lib.ui.SearchPageObject;
import lib.ui.android.androidSearchPageObject;
import lib.ui.ios.iosSearchPageObject;
import lib.ui.mobile_web.MWSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory {
    public static SearchPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new androidSearchPageObject(driver);
        }
        else if(Platform.getInstance().isIOS()){
            return new iosSearchPageObject(driver);
        } else {
            return new MWSearchPageObject(driver);
        }
    }
}
