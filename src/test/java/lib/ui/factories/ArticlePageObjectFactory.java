package lib.ui.factories;

import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.android.androidArticlePageObject;
import lib.ui.ios.iosArticlePageObject;
import lib.ui.mobile_web.MWArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory {

    public static ArticlePageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new androidArticlePageObject(driver);
        } else if (Platform.getInstance().isIOS()){
            return new iosArticlePageObject(driver);
        } else {
            return new MWArticlePageObject(driver);
        }
    }
}
