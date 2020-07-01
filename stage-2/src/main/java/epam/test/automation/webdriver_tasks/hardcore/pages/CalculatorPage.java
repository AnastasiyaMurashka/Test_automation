package epam.test.automation.webdriver_tasks.hardcore.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CalculatorPage extends AbstractPage {
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//md-tab-item/*[@title='Compute Engine']")
    WebElement computerEngine;

    @FindBy(id = "input_58")
    WebElement numberOfInstances;

    @FindBy(id = "select_70")
    WebElement operatingSystem;

    @FindBy(xpath = "//md-option[@value='free']/div[@class='md-text']")
    WebElement valueOfOperatingSystem;

    @FindBy(id = "select_74")
    WebElement machineClass;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[text()='Regular']")
    WebElement valueMachineClass;

    @FindBy(id = "select_83")
    WebElement machineType;

    @FindBy(css = "md-option[value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8'] div")
    WebElement valueOfMachineType;

    @FindBy(xpath = "//md-input-container//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGroupCheckBox;

    @FindBy(id = "select_337")
    WebElement numberOfGroup;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")
    WebElement valueOfNumberOfGroup;

    @FindBy(xpath = "//md-select[@id='select_339']//span[@class='md-select-icon']")
    WebElement gpuType;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    WebElement valueOfGPUType;

    @FindBy(xpath = "//md-select[@id='select_170']//span[@class='md-select-icon']")
    WebElement localSSD;

    @FindBy(xpath = "//div[@id='select_container_171']//md-option[@value='2']")
    WebElement valueOfLocalSSD;

    @FindBy(xpath = "//md-select[@id='select_85']//span[@class='md-select-icon']")
    WebElement datacenterLocation;

    @FindBy(xpath = "//div[@id='select_container_86']//md-option[@value='europe-west3']")
    WebElement valueOfDatacenterLocation;

    @FindBy(xpath = "//md-select[@id='select_92']//span[@class='md-select-icon']")
    WebElement commitedUsage;

    @FindBy(xpath = "//*[@id='select_option_90']/div[@class='md-text']")
    WebElement valueOfCommitedUsage;

    @FindBy(xpath = "//*[@id='mainForm']/descendant::button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement buttonAddToEstimate;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(.,'regular')]")
    WebElement estimateVMType;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(.,'Instance type:')]")
    WebElement estimateInstanceType;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(.,'Region:')]")
    WebElement estimateRegion;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(.,'Total available')]")
    WebElement estimateLocalSSD;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(.,'Commitment')]")
    WebElement estimateCommitmentTerm;

    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding']")
    WebElement estimateCost;

    @FindBy(id = "email_quote")
    WebElement emailButton;

    @FindBy(id = "input_404")
    WebElement fieldForEmail;

    @FindBy(xpath = "//*[@aria-label='Send Email']")
    WebElement buttonSendEmail;

    public CalculatorPage open() {
        driver.get("https://cloud.google.com/products/calculator");
        return this;
    }

    public CalculatorPage switchToComputerEngine() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-tab-item/*[@title='Compute Engine']")));
        computerEngine.click();
        return this;
    }

    public CalculatorPage setNumberOfInstances() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-tab-item/*[@title='Compute Engine']")));
        numberOfInstances.sendKeys("4");
        return this;
    }

    public CalculatorPage setOperatingSystem() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(operatingSystem));
        executor.executeScript("arguments[0].click()", operatingSystem);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfOperatingSystem));
        executor.executeScript("arguments[0].click()", valueOfOperatingSystem);
        return this;
    }

    public CalculatorPage setMachineClass() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(machineClass));
        executor.executeScript("arguments[0].click()", machineClass);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueMachineClass));
        executor.executeScript("arguments[0].click()", valueMachineClass);
        return this;
    }

    public CalculatorPage setMachineType() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(machineType));
        executor.executeScript("arguments[0].click()", machineType);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfMachineType));
        executor.executeScript("arguments[0].click()", valueOfMachineType);
        return this;
    }

    public CalculatorPage switchOnAddGroup() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addGroupCheckBox));
        executor.executeScript("arguments[0].click()", addGroupCheckBox);
        return this;
    }

    public CalculatorPage setNumberOfGroup() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(numberOfGroup));
        executor.executeScript("arguments[0].click()", numberOfGroup);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfNumberOfGroup));
        executor.executeScript("arguments[0].click()", valueOfNumberOfGroup);
        return this;
    }

    public CalculatorPage setGPUType() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(gpuType));
        executor.executeScript("arguments[0].click()", gpuType);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfGPUType));
        executor.executeScript("arguments[0].click()", valueOfGPUType);
        return this;
    }

    public CalculatorPage setLocalSSD() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(localSSD));
        executor.executeScript("arguments[0].click()", localSSD);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfLocalSSD));
        executor.executeScript("arguments[0].click()", valueOfLocalSSD);
        return this;
    }

    public CalculatorPage setDatacenterLocation() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(datacenterLocation));
        executor.executeScript("arguments[0].click()", datacenterLocation);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfDatacenterLocation));
        executor.executeScript("arguments[0].click()", valueOfDatacenterLocation);
        return this;
    }

    public CalculatorPage setCommitedUsage() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(commitedUsage));
        executor.executeScript("arguments[0].click()", commitedUsage);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(valueOfDatacenterLocation));
        executor.executeScript("arguments[0].click()", valueOfCommitedUsage);
        return this;
    }

    public CalculatorPage clickAddToEstimate() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonAddToEstimate));
        executor.executeScript("arguments[0].click()", buttonAddToEstimate);
        return this;
    }

    public void switchToEmailPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(" https://10minutemail.com");
    }

    public CalculatorPage clickEmailEstimate() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(emailButton));
        executor.executeScript("arguments[0].click()", emailButton);
        return this;
    }

    public CalculatorPage inputEmail() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("input_404")));
        fieldForEmail.sendKeys(Keys.LEFT_CONTROL, "v");
        return this;
    }

    public CalculatorPage sendEmail() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label='Send Email']")));
        executor.executeScript("arguments[0].click()", buttonSendEmail);
        return this;
    }

    public String getCost() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//h2[@class='md-title']/b[@class='ng-binding']")));
        return estimateCost.getText();
    }
}
