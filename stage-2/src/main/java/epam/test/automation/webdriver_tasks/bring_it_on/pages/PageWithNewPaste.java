package epam.test.automation.webdriver_tasks.bring_it_on.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWithNewPaste {
    private WebDriver driver;

    private By syntaxHighlightingOfNewPaste = By.xpath("//a[text()='Bash']");
    private By titleOfNewPaste = By.xpath("//*[@class='paste_box_line1']");
    private By textFromNewPaste = By.id("paste_code");

    @FindBy(xpath = "//a[text()='Bash']")
    private WebElement buttonSyntaxHighlighting;

    @FindBy(xpath = "//*[@class='paste_box_line1']")
    private WebElement title;

    @FindBy(id = "paste_code")
    private WebElement pasteCode;

    public PageWithNewPaste(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextFromSyntaxHighlightingButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(syntaxHighlightingOfNewPaste));
        return buttonSyntaxHighlighting.getText();
    }

    public String getTitle() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(titleOfNewPaste));
        return title.getText();
    }

    public String getCodeFromNewPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(textFromNewPaste));
        return pasteCode.getText();
    }
}
