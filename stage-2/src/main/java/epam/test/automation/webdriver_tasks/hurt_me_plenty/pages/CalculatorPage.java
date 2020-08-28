package epam.test.automation.webdriver_tasks.hurt_me_plenty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input_59")
    WebElement numberOfInstancesInput;

    @FindBy(id = "select_71")
    WebElement operatingSystemDropDownList;

    @FindBy(xpath = "//md-option[@value='free']/div[@class='md-text']")
    WebElement valueOfOperatingSystemButton;

    @FindBy(id = "select_75")
    WebElement machineClassDropDownList;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[text()='Regular']")
    WebElement valueMachineClassButton;

    @FindBy(id = "select_84")
    WebElement machineTypeDropDownList;

    @FindBy(css = "md-option[value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8'] div")
    WebElement valueOfMachineTypeButton;

    @FindBy(xpath = "//md-input-container//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGroupCheckBox;

    @FindBy(id = "select_338")
    WebElement numberOfGroupDropDownList;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")
    WebElement valueOfNumberOfGroupButton;

    @FindBy(xpath = "//md-select[@id='select_340']//span[@class='md-select-icon']")
    WebElement gpuTypeDropDownList;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    WebElement valueOfGPUTypeButton;

    @FindBy(xpath = "//md-select[@id='select_171']//span[@class='md-select-icon']")
    WebElement localSsdDropDownList;

    @FindBy(xpath = "//div[@id='select_container_172']//md-option[@value='2']")
    WebElement valueOfLocalSsdButton;

    @FindBy(xpath = "//md-select[@id='select_86']//span[@class='md-select-icon']")
    WebElement datacenterLocationDropDownList;

    @FindBy(xpath = "//div[@id='select_container_87']//md-option[@value='europe-west3']")
    WebElement valueOfDatacenterLocationButton;

    @FindBy(xpath = "//md-select[@id='select_93']//span[@class='md-select-icon']")
    WebElement commitedUsageDropDownList;

    @FindBy(xpath = "//*[@id='select_option_91']/div[@class='md-text']")
    WebElement valueOfCommitedUsageButton;

    @FindBy(xpath = "//*[@id='mainForm']/descendant::button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement addToEstimateButton;

    private static final By VALUE_OF_VM_TYPE_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'regular')]");
    private static final By VALUE_OF_INSTANCE_TYPE_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Instance type:')]");
    private static final By VALUE_OF_REGION_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Region:')]");
    private static final By VALUE_OF_LOCAL_SSD_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Total available')]");
    private static final By VALUE_OF_COMMITMENT_TERM_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Commitment')]");
    private static final By COST_FROM_ESTIMATE = By.xpath("//h2[@class='md-title']/b[@class='ng-binding']");
    private static final By FRAME = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");
    private static final By COMPUTER_ENGINE_BUTTON = By.xpath("//md-tab-item/*[@title='Compute Engine']");

    public CalculatorPage switchToComputerEngine() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(FRAME));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(COMPUTER_ENGINE_BUTTON));
        driver.findElement(COMPUTER_ENGINE_BUTTON).click();
        return this;
    }

    public CalculatorPage setNumberOfInstances() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(COMPUTER_ENGINE_BUTTON));
        numberOfInstancesInput.sendKeys("4");
        return this;
    }

    public CalculatorPage setOperatingSystem() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(operatingSystemDropDownList));
        executor.executeScript("arguments[0].click()", operatingSystemDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfOperatingSystemButton));
        executor.executeScript("arguments[0].click()", valueOfOperatingSystemButton);
        return this;
    }

    public CalculatorPage setMachineClass() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(machineClassDropDownList));
        executor.executeScript("arguments[0].click()", machineClassDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueMachineClassButton));
        executor.executeScript("arguments[0].click()", valueMachineClassButton);
        return this;
    }

    public CalculatorPage setMachineType() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(machineTypeDropDownList));
        executor.executeScript("arguments[0].click()", machineTypeDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfMachineTypeButton));
        executor.executeScript("arguments[0].click()", valueOfMachineTypeButton);
        return this;
    }

    public CalculatorPage switchOnAddGroup() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addGroupCheckBox));
        executor.executeScript("arguments[0].click()", addGroupCheckBox);
        return this;
    }

    public CalculatorPage setNumberOfGroup() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(numberOfGroupDropDownList));
        executor.executeScript("arguments[0].click()", numberOfGroupDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfNumberOfGroupButton));
        executor.executeScript("arguments[0].click()", valueOfNumberOfGroupButton);
        return this;
    }

    public CalculatorPage setGPUType() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(gpuTypeDropDownList));
        executor.executeScript("arguments[0].click()", gpuTypeDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfGPUTypeButton));
        executor.executeScript("arguments[0].click()", valueOfGPUTypeButton);
        return this;
    }

    public CalculatorPage setLocalSSD() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(localSsdDropDownList));
        executor.executeScript("arguments[0].click()", localSsdDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfLocalSsdButton));
        executor.executeScript("arguments[0].click()", valueOfLocalSsdButton);
        return this;
    }

    public CalculatorPage setDatacenterLocation() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(datacenterLocationDropDownList));
        executor.executeScript("arguments[0].click()", datacenterLocationDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfDatacenterLocationButton));
        executor.executeScript("arguments[0].click()", valueOfDatacenterLocationButton);
        return this;
    }

    public CalculatorPage setCommitedUsage() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(commitedUsageDropDownList));
        executor.executeScript("arguments[0].click()", commitedUsageDropDownList);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfDatacenterLocationButton));
        executor.executeScript("arguments[0].click()", valueOfCommitedUsageButton);
        return this;
    }

    public CalculatorPage clickAddToEstimate() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
        executor.executeScript("arguments[0].click()", addToEstimateButton);
        return this;
    }

    public String getValueOfVMMachine() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated
                        (VALUE_OF_VM_TYPE_FROM_ESTIMATE));
        return driver.findElement(VALUE_OF_VM_TYPE_FROM_ESTIMATE).getText();
    }

    public String getValueInstanceType() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated
                        (VALUE_OF_INSTANCE_TYPE_FROM_ESTIMATE));
        return driver.findElement(VALUE_OF_INSTANCE_TYPE_FROM_ESTIMATE).getText();
    }

    public String getValueRegion() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated
                        (VALUE_OF_REGION_FROM_ESTIMATE));
        return driver.findElement(VALUE_OF_REGION_FROM_ESTIMATE).getText();
    }

    public String getValueLocalSSD() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated
                        (VALUE_OF_LOCAL_SSD_FROM_ESTIMATE));
        return driver.findElement(VALUE_OF_LOCAL_SSD_FROM_ESTIMATE).getText();
    }

    public String getCommitmentTerm() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated
                        (VALUE_OF_COMMITMENT_TERM_FROM_ESTIMATE));
        return driver.findElement(VALUE_OF_COMMITMENT_TERM_FROM_ESTIMATE).getText();
    }

    public String getCost() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated
                        (COST_FROM_ESTIMATE));
        return driver.findElement(COST_FROM_ESTIMATE).getText();
    }
}
