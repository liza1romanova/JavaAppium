package lib.ui.ios;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iosArticlePageObject extends ArticlePageObject {

    static {
            TITLE = "id:{SUBSTRING}";
            SUBTITLE = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
            FOOTER_ELEMENT = "id:View article in browser";
            OPTIONS_BUTTON = "xpath://XCUIElementTypeButton[@name=\"Share\"]";
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://XCUIElementTypeOther[@name='ActivityListView']//XCUIElementTypeButton[@name='Add to reading list']";
            ADD_TO_MY_LIST_OVERLAY = "xpath://XCUIElementTypeButton[@name=\"Add\"]";
            MY_LIST_NAME_INPUT = "xpath:(//XCUIElementTypeTextField)[1]";
            MY_LIST_OK_BUTTON = "xpath://XCUIElementTypeButton[@name=\"Create reading list\"]";
            EXISTING_LIST_TPL = "xpath://XCUIElementTypeLink[@label='{SUBSTRING}']/parent::XCUIElementTypeCell";
            CLOSE_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name=\"Back\"]";
    }

    public iosArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
