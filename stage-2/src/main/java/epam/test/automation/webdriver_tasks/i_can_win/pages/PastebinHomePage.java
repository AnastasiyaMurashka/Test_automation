package epam.test.automation.webdriver_tasks.i_can_win.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PastebinHomePage {
    private static final String PAGE_URL = "https://pastebin.com";
    private static final String CODE_TEXT = "Hello from WebDriver";
    private static final String PASTE_NAME = "helloweb";
    private static final String PASTE_EXPIRATION = "10 Minutes";
    private WebDriver driver;

    @FindBy(id = "paste_code")
    private WebElement pasteTextArea;

    @FindBy(name = "paste_expire_date")
    private WebElement pasteExpirationSpan;

    @FindBy(name = "paste_name")
    private WebElement pasteNameInput;

    @FindBy(id = "submit")
    private WebElement createNewPasteButton;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public PastebinHomePage inputCode() {
        pasteTextArea.sendKeys(CODE_TEXT);
        return this;
    }

    public PastebinHomePage setPasteExpiration() {
        Select select = new Select(pasteExpirationSpan);
        select.selectByVisibleText(PASTE_EXPIRATION);
        return this;
    }

    public PastebinHomePage setPasteName() {
        pasteNameInput.sendKeys(PASTE_NAME);
        return this;
    }

    public PastebinNewPastePage createPastebinNewPastePage() {
        createNewPasteButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("success")));
        return new PastebinNewPastePage(driver);
    }
}
