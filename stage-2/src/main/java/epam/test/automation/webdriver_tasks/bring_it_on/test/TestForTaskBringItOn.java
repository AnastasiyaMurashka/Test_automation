package epam.test.automation.webdriver_tasks.bring_it_on.test;

import epam.test.automation.webdriver_tasks.bring_it_on.pages.HomePagePastebin;
import epam.test.automation.webdriver_tasks.bring_it_on.pages.PageWithNewPaste;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

public class TestForTaskBringItOn {
    private WebDriver driver;
    private PageWithNewPaste pageWithNewPaste;

    @BeforeClass(alwaysRun = true)
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
        assertEquals(pageWithNewPaste.getTitle(), HomePagePastebin.getPasteName(),
                "Title does not equal with given value");
    }

    @Test(description = "This test checks value of syntax")
    public void checkSyntax() {
        assertEquals(pageWithNewPaste.getTextFromSyntaxHighlightingButton()
                , HomePagePastebin.getSyntaxHighlighting(),
                "Syntax does not equal with given value");
    }

    @Test(description = "This test checks code text")
    public void checkCodeText() {
        assertEquals(pageWithNewPaste.getCodeFromNewPage(), HomePagePastebin.getCodeText(),
                "Code does not equal with given value");
    }

    @AfterClass(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
