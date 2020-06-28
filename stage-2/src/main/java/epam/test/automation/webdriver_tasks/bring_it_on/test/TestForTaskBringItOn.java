package epam.test.automation.webdriver_tasks.bring_it_on.test;

import epam.test.automation.webdriver_tasks.bring_it_on.pages.HomePagePastebin;
import epam.test.automation.webdriver_tasks.bring_it_on.pages.PageWithNewPaste;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestForTaskBringItOn {
    private WebDriver driver;
    private PageWithNewPaste pageWithNewPaste;

    @BeforeMethod(alwaysRun = true)
    public void openNewPastePage() {
        driver = new ChromeDriver();
        pageWithNewPaste = new HomePagePastebin(driver).openPage()
                .inputCode()
                .setSyntaxHighlighting()
                .setExpiration()
                .setPasteName()
                .createPastebinNewPastePage();
    }

    @Test(description = "This test checks title")
    public void checkTitle() {
        Assert.assertTrue(pageWithNewPaste.getTitle().equals(HomePagePastebin.getPasteName()),
                "Title does not equal with given value");
    }

    @Test(description = "This test checks value of syntax")
    public void checkSyntax() {
        Assert.assertTrue(pageWithNewPaste.getTextFromSyntaxHighlightingButton()
                        .equals(HomePagePastebin.getSyntaxHighlighting()),
                "Syntax does not equal with given value");
    }

    @Test(description = "This test checks code text")
    public void checkCodeText() {
        Assert.assertTrue(pageWithNewPaste.getCodeFromNewPage().equals(HomePagePastebin.getCodeText()),
                "Code does not equal with given value");
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
