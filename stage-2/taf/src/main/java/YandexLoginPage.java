import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexLoginPage {
    private WebDriver driver;
    private static final By LOGIN_BOX = By.id("passp-field-login");
    private static final String LOGIN = "TAFepam";
    private static final By PASSWORD_BOX = By.id("passp-field-passwd");
    private static final String PASSWORD = "epamautomation";
    private static final By ENTER_BUTTON = By.xpath(("//button[@type='submit']"));

    public YandexLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YandexLoginPage inputLogin() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(LOGIN_BOX));
        driver.findElement(LOGIN_BOX).sendKeys(LOGIN);
        return this;
    }

    public YandexLoginPage clickEnterAfterLoginInput() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(ENTER_BUTTON));
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }

    public YandexLoginPage inputPassword() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(PASSWORD_BOX));
        driver.findElement(PASSWORD_BOX).sendKeys(PASSWORD);
        return this;
    }

    public YandexDiskClientPage clickEnterAfterPasswordInput() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(ENTER_BUTTON));
        driver.findElement(ENTER_BUTTON).click();
        return new YandexDiskClientPage(driver);
    }
}

