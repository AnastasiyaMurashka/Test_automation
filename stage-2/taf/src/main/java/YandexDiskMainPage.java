import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexDiskMainPage {
    private WebDriver driver;
    private static final By ENTRY_BUTTON = By.xpath("//a[text()='Войти']");

    public YandexDiskMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YandexLoginPage clickEntryButton() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(ENTRY_BUTTON));
        driver.findElement(ENTRY_BUTTON).click();
        return new YandexLoginPage(driver);
    }
}

