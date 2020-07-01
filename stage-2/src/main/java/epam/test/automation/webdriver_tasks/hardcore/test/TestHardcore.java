package epam.test.automation.webdriver_tasks.hardcore.test;

import epam.test.automation.webdriver_tasks.hardcore.pages.CalculatorPage;
import epam.test.automation.webdriver_tasks.hardcore.pages.HomePageCloudGoogle;
import epam.test.automation.webdriver_tasks.hardcore.pages.PageForGenerateEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHardcore {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void checkEmail() {
        PageForGenerateEmail pageForGenerateEmail = new PageForGenerateEmail(driver);
        HomePageCloudGoogle homePageCloudGoogle = new HomePageCloudGoogle(driver);
        CalculatorPage calculatorPage = homePageCloudGoogle.openHomePage()
                .startSearch()
                .inputSearchEnquiry()
                .pickRightResult()
                .switchToComputerEngine()
                .setNumberOfInstances()
                .setOperatingSystem()
                .setMachineClass()
                .setMachineType()
                .switchOnAddGroup()
                .setNumberOfGroup()
                .setGPUType()
                .setLocalSSD()
                .setDatacenterLocation()
                .setCommitedUsage()
                .clickAddToEstimate();
        String costEstimate = calculatorPage.getCost();
        calculatorPage.switchToEmailPage();
        new PageForGenerateEmail(driver).copyEmail().switchToCalculator();
        calculatorPage.switchToComputerEngine().clickEmailEstimate().inputEmail().sendEmail().switchToEmailPage();
        new PageForGenerateEmail(driver).openMail();
        Assert.assertTrue(costEstimate.contains(pageForGenerateEmail.getCostFromEmail()));
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
