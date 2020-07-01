package epam.test.automation.webdriver_tasks.i_can_win.test;

import epam.test.automation.webdriver_tasks.i_can_win.pages.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestForTaskICanWin {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "This test checks successful creation of the new Paste")
    public void checkSuccessfulCreateNewPost() {
        Assert.assertTrue(new PastebinHomePage(driver).openPage()
                .inputCode()
                .setPasteExpiration()
                .setPasteName()
                .createPastebinNewPastePage().checkSuccessfulCreateNewPaste());
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
