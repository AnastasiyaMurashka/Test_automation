package epam.test.automation.webdriver_tasks.hurt_me_plenty.test;

import epam.test.automation.webdriver_tasks.hurt_me_plenty.pages.CalculatorPage;
import epam.test.automation.webdriver_tasks.hurt_me_plenty.pages.HomePageCloudGoogle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHurtMePlenty {
    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testChecksCorrectFieldsFilling() {
        CalculatorPage calculatorPage;
        HomePageCloudGoogle homePageCloudGoogle = new HomePageCloudGoogle(driver);
        calculatorPage = homePageCloudGoogle.openHomePage()
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
        Assert.assertTrue(calculatorPage.getValueOfVMMachine().contains("regular"));
        Assert.assertTrue(calculatorPage.getValueInstanceType().contains("n1-standard-8"));
        Assert.assertTrue(calculatorPage.getValueRegion().contains("Frankfurt"));
        Assert.assertTrue(calculatorPage.getValueLocalSSD().contains("2x375"));
        Assert.assertTrue(calculatorPage.getCommitmentTerm().contains("1 Year"));
        Assert.assertTrue(calculatorPage.getCost().contains("1,082.77"));
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
