package epam.test.automation.webdriver_tasks.hurt_me_plenty.test;

import epam.test.automation.webdriver_tasks.hurt_me_plenty.pages.CalculatorPage;
import epam.test.automation.webdriver_tasks.hurt_me_plenty.pages.HomePageCloudGoogle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestHurtMePlenty {
    private WebDriver driver;
    private CalculatorPage calculatorPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        calculatorPage = new HomePageCloudGoogle(driver).openHomePage()
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
    }

    @Test
    public void checkCorrectFieldsFilling() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(calculatorPage.getValueOfVMMachine().contains("regular"), "value of VM is incorrectly set");
        softAssert.assertTrue(calculatorPage.getValueInstanceType().contains("n1-standard-8"),
                "value of instance type is incorrectly set");
        softAssert.assertTrue(calculatorPage.getValueRegion().contains("Frankfurt"),
                "value of region is incorrectly set");
        assertTrue(calculatorPage.getValueLocalSSD().contains("2x375"),
                "value of local SSD is incorrectly set");
        softAssert.assertTrue(calculatorPage.getCommitmentTerm().contains("1 Year"),
                "value of commitment term is incorrectly set");
        softAssert.assertTrue(calculatorPage.getCost().contains("1,082.77"),
                "cost from estimate is calculate incorrectly");
        softAssert.assertAll();
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
