package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject{
        public MWSearchPageObject(RemoteWebDriver driver)
        {
            super(driver);
        }

        static {
            SEARCH_INIT_ELEMENT = "css:button#searchIcon";
            SEARCH_INPUT = "css:form>input[type='search']";
            SEARCH_CANCEL_BUTTON = "css:button.cancel";
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
            SEARCH_RESULT_ELEMENT = "css://ul.page-list>li.page-summary";
            SEARCH_RESULT_TITLE = "xpath://XCUIElementTypeCell/XCUIElementTypeLink";
            SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
            SEARCH_RESULT_BY_TITLE_AND_DESC_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']/*[./*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='{SUBSTRING_TITLE}'] and ./*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='{SUBSTRING_DESCRIPTION}']]";
        }
}
