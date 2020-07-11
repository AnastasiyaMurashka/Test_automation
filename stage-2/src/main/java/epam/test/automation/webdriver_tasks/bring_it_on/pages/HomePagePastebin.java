package epam.test.automation.webdriver_tasks.bring_it_on.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePastebin {
    private WebDriver driver;
    private static final String PAGE_URL = "https://pastebin.com";
    private static final String CODE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String SYNTAX_HIGHLIGHTING = "Bash";
    private static final String PASTE_EXPIRATION = "10 Minutes";
    private static final String PASTE_NAME = "how to gain dominance among developer";

    @FindBy(name = "paste_format")
    private WebElement pasteSyntaxHighlightingSpan;

    @FindBy(id = "paste_code")
    private WebElement pasteTextArea;

    @FindBy(name = "paste_expire_date")
    private WebElement pasteExpirationSpan;

    @FindBy(name = "paste_name")
    private WebElement pasteNameInput;

    @FindBy(id = "submit")
    private WebElement createPasteButton;

    public HomePagePastebin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePagePastebin openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public HomePagePastebin inputCode() {
        pasteTextArea.sendKeys(CODE_TEXT);
        return this;
    }

    public HomePagePastebin setSyntaxHighlighting() {
        Select select = new Select(pasteSyntaxHighlightingSpan);
        select.selectByVisibleText(SYNTAX_HIGHLIGHTING);
        return this;
    }

    public HomePagePastebin setExpiration() {
        Select select = new Select(pasteExpirationSpan);
        select.selectByVisibleText(PASTE_EXPIRATION);
        return this;
    }

    public HomePagePastebin setPasteName() {
        pasteNameInput.sendKeys(PASTE_NAME);
        return this;
    }

    public PageWithNewPaste createPastebinNewPastePage() {
        createPasteButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("success")));
        return new PageWithNewPaste(driver);
    }

    public static String getPasteName() {
        return PASTE_NAME;
    }

    public static String getSyntaxHighlighting() {
        return SYNTAX_HIGHLIGHTING;
    }

    public static String getCodeText() {
        return CODE_TEXT;
    }
}
