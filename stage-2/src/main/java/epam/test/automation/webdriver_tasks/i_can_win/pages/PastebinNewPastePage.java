package epam.test.automation.webdriver_tasks.i_can_win.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinNewPastePage {
    private WebDriver driver;


    public PastebinNewPastePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean checkSuccessfulCreateNewPaste(){
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("success")));
        return (driver.findElements(By.id("success")).size()>0);
    }
}
