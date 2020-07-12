package epam.test.automation.webdriver_tasks.hardcore.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class PageForGenerateEmail extends AbstractPage {
    public PageForGenerateEmail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='copy_address']//span")
    WebElement copyEmailButton;

    @FindBy(xpath = "//span[@class='small_message_icon']")
    WebElement openMailButton;

    @FindBy(xpath = "//h3[contains(.,'USD')]")
    WebElement costFromEmail;

    public PageForGenerateEmail openPage() {
        driver.get("https://10minutemail.com");
        return this;
    }

    public PageForGenerateEmail copyEmail() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(copyEmailButton));
        copyEmailButton.click();
        return this;
    }

    public void switchToCalculator() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public PageForGenerateEmail openMail() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(openMailButton));
        openMailButton.click();
        return this;
    }

    public String getCostFromEmail() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(.,'USD')]")));
        return costFromEmail.getText();
    }
}
