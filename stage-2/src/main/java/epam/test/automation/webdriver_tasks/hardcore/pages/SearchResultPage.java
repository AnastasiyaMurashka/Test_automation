package epam.test.automation.webdriver_tasks.hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends AbstractPage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    WebElement rightResult;

    public CalculatorPage pickRightResult() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")));
        rightResult.click();
        return new CalculatorPage(driver);
    }
}
