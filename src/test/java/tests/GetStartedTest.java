package tests;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ios.*;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase
{

    @Test
    public void testPassThroughWelcome()
    {
        if (Platform.getInstance().isAndroid()|| (Platform.getInstance().isMW())){
            return;
        }
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWaysToExploreText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOrEditPreferredLangText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreAboutDataCollectedText();
        WelcomePage.clickGetStarted();
    }

    @Test
    public void testSkip()
    {
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);
        WelcomePage.clickSkipButton();
    }
}
