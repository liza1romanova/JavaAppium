package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    private static final String
            name_of_folder = "Learning programming",
            login = "liza1romanova",
            password = "qwert1234";
    @Test
    public void testSaveFirstArticleToMyList() throws InterruptedException {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title;
        if(Platform.getInstance().isIOS()){
            ArticlePageObject.waitForKnownTitleElement("bject-oriented programming language");
            article_title = "Java (programming language)";
        } else
        {
            ArticlePageObject.waitForTitleElement();
            article_title = ArticlePageObject.getArticleTitle();
        }
        if (Platform.getInstance().isMW()){
            ArticlePageObject.addArticlesToMySaved();
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();
            Assert.assertEquals( "We are not on the same page after login.",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );
            ArticlePageObject.addArticlesToMySaved();
        } else{
            String name_of_folder = "Learning programming";
            ArticlePageObject.addArticleToNewList(name_of_folder);
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIObjectFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();
        Thread.sleep(2000);
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isMW()){
            MyListsPageObject.swipeByArticleToDelete(article_title);
        } else {
            if (Platform.getInstance().isIOS()) {
                MyListsPageObject.openReadingLists();
            }
            MyListsPageObject.waitForFolderPresent(name_of_folder);
            MyListsPageObject.openFolderByName(name_of_folder);
            if (Platform.getInstance().isAndroid()) {
                MyListsPageObject.swipeByArticleToDelete(article_title);
            } else {
                MyListsPageObject.deleteSavedArticle(article_title);
            }
        }
    }

    @Test
    public void testSavingTwoArticles() throws InterruptedException {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Mozart");
        SearchPageObject.clickByArticleWithSubstring("Austrian composer of the Classical period");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        if(Platform.getInstance().isIOS()){
            ArticlePageObject.waitForKnownTitleElement("Wolfgang Amadeus Mozart");
        } else
        {
            ArticlePageObject.waitForTitleElement();
        }
        if (Platform.getInstance().isMW()){
            ArticlePageObject.addArticlesToMySaved();
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            Thread.sleep(5000);
            ArticlePageObject.addArticlesToMySaved();
        } else {
            String name_of_folder = "Violin";
            ArticlePageObject.addArticleToNewList(name_of_folder);
        }
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.clearSearchInput();
        SearchPageObject.typeSearchLine("Vivaldi");
        SearchPageObject.clickByArticleWithSubstring("Italian composer");
        ArticlePageObject.addArticleToExistingList(name_of_folder);
        ArticlePageObject.closeArticle();
        ArticlePageObject.addArticlesToMySaved();

        NavigationUI NavigationUI = NavigationUIObjectFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();
        Thread.sleep(2000);
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        String delete_article = "Antonio Vivaldi";
        String save_article = "Wolfgang Amadeus Mozart";
        if (Platform.getInstance().isMW()){
            MyListsPageObject.swipeByArticleToDelete(delete_article);
        }else {
            if(Platform.getInstance().isIOS()){
                MyListsPageObject.openReadingLists();
            }
            MyListsPageObject.waitForFolderPresent(name_of_folder);
            MyListsPageObject.openFolderByName(name_of_folder);

            if(Platform.getInstance().isAndroid()) {
                MyListsPageObject.swipeByArticleToDelete(delete_article);
            }
            else {
                MyListsPageObject.deleteSavedArticle(delete_article);
            }
            MyListsPageObject.waitForArticleToDisappearByTitle(delete_article);
        }

        MyListsPageObject.openSavedArticle(save_article);
        if(Platform.getInstance().isIOS()) {
            ArticlePageObject.waitForKnownTitleElement(save_article);
        }
        else{
            String title_found = ArticlePageObject.getArticleTitle();
            assertEquals(
                    "Page title doesn't match saved",
                    save_article,
                    title_found
            );
        }

    }
}
