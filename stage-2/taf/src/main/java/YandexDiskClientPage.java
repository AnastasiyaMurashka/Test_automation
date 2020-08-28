import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class YandexDiskClientPage {
    private WebDriver driver;
    private static final By RECENT = By.xpath("//a[@title='Последние']");
    private static final By FILES = By.xpath("//a[@title='Файлы']");
    private static final By PHOTO = By.xpath("//a[@title='Фото']");
    private static final By ALBUMS = By.xpath("//a[@title='Альбомы']");
    private static final By PUBLISHED = By.xpath("//a[@title='Общий доступ']");
    private static final By JOURNAL = By.xpath("//a[@title='История']");
    private static final By ARCHIVE = By.xpath("//a[@title='Архив']");
    private static final By TRASH = By.xpath("//a[@title='Корзина']");
    private static final By TITLE = By.xpath("//h1");
    private static final By BUTTON_FOR_CREATE = By.xpath("//span[@class='create-resource-popup-with-anchor']//button");
    private static final By BUTTON_FOR_CREATE_FOLDER = By.xpath("//span[text()='Папку']/parent::button");
    private static final By BUTTON_FOR_CREATE_TEXT_FILE = By.xpath("//span[text()='Текстовый документ']/parent::button");
    private static final By FOLDER_NAME_INPUT = By.xpath("//input[@value='Новая папка']");
    private static final By BUTTON_SAVE = By.xpath("//span[text()='Сохранить']/parent::button");
    private static final By FILE_NAME = By.id("documentTitle");
    private static final By FILE_NAME_INPUT = By.id("CommitNewDocumentTitle");
    private static final By TEXT_BOX = By.xpath("//p[@class='Paragraph']");
    private static final By BUTTON_FILE = By.id("id__1");
    private static final By BUTTON_ESCAPE = By.xpath("//span[text()='Выход']");
    private static final By FRAME = By.xpath("//iframe[@class='editor-doc__iframe']");
    private static final By TEXT_FILE = By.xpath("//div[@class='listing-item__fields']");
    private static final By TEXT_FILE_NAME = By.xpath("//span[text()='Text.docx']");
    private static final By BUTTON_CLEAR_TRASH = By.xpath("//div[@class='listing-head__additional-actions']//button");
    private static final By BUTTON_CLEAR = By.xpath("//span[text()='Очистить']/..");

    public YandexDiskClientPage(WebDriver driver) {
        this.driver = driver;
    }

    public YandexDiskClientPage switchToRecent() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(RECENT));
        driver.findElement(RECENT).click();
        return this;
    }

    public String getTitle() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }

    public YandexDiskClientPage switchToFiles() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(FILES));
        driver.findElement(FILES).click();
        return this;
    }

    public YandexDiskClientPage switchToPhoto() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(PHOTO));
        driver.findElement(PHOTO).click();
        return this;
    }

    public YandexDiskClientPage switchToAlbums() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(ALBUMS));
        driver.findElement(ALBUMS).click();
        return this;
    }

    public YandexDiskClientPage switchToJournal() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(JOURNAL));
        driver.findElement(JOURNAL).click();
        return this;
    }

    public YandexDiskClientPage switchToPublished() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(PUBLISHED));
        driver.findElement(PUBLISHED).click();
        return this;
    }

    public YandexDiskClientPage switchToArchive() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(ARCHIVE));
        driver.findElement(ARCHIVE).click();
        return this;
    }

    public YandexDiskClientPage switchToTrash() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(TRASH));
        driver.findElement(TRASH).click();
        return this;
    }

    public YandexDiskClientPage createNewFolder(String nameOfFolder) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(BUTTON_FOR_CREATE));
        driver.findElement(BUTTON_FOR_CREATE).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(BUTTON_FOR_CREATE_FOLDER));
        driver.findElement(BUTTON_FOR_CREATE_FOLDER).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(FOLDER_NAME_INPUT));
        driver.findElement(FOLDER_NAME_INPUT).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(FOLDER_NAME_INPUT).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
        driver.findElement(FOLDER_NAME_INPUT).sendKeys(nameOfFolder);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(BUTTON_SAVE));
        driver.findElement(BUTTON_SAVE).click();
        return this;
    }

    public boolean checkCreateNewFolder(String nameOfFolder) {
        try {
            new WebDriverWait(driver, 10).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='" + nameOfFolder + "']")));
            driver.findElement(By.xpath("//span[text()='" + nameOfFolder + "']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public YandexDiskClientPage goIntoFolder() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='listing-item__fields']")));
        Actions builder = new Actions(driver);
        WebElement folder = driver.findElement(By.xpath("//div[@class='listing-item__fields']"));
        builder.moveToElement(folder).doubleClick().build().perform();
        return this;
    }

    public YandexDiskClientPage createTextFile(String fileName) throws InterruptedException {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(BUTTON_FOR_CREATE));
        driver.findElement(BUTTON_FOR_CREATE).click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(BUTTON_FOR_CREATE_TEXT_FILE));
        String originalWindow = driver.getWindowHandle();
        Set<String> oldWindowsSet = driver.getWindowHandles();

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(BUTTON_FOR_CREATE_TEXT_FILE)).click(driver.findElement(BUTTON_FOR_CREATE_TEXT_FILE))
                .build().perform();
        String newWindow = (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<String>) webDriver -> {
                            Set<String> newWindowsSet = webDriver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        driver.switchTo().window(newWindow);
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(FILE_NAME));
        driver.findElement(FILE_NAME).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(FILE_NAME_INPUT));
        driver.findElement(FILE_NAME_INPUT).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        driver.findElement(FILE_NAME_INPUT).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
        driver.findElement(FILE_NAME_INPUT).sendKeys(fileName + '\n');
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(TEXT_BOX));
        driver.findElement(TEXT_BOX).sendKeys("Hi my name is EVA");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(BUTTON_FILE));
        driver.findElement(BUTTON_FILE).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(BUTTON_ESCAPE));
        Actions builder1 = new Actions(driver);
        builder1.moveToElement(driver.findElement(BUTTON_ESCAPE)).click().build().perform();
        driver.switchTo().window(originalWindow);
        TimeUnit.SECONDS.sleep(10);
        return this;
    }

    public boolean checkCreateNewTextFie() {
        try {
            new WebDriverWait(driver, 10).
                    until(ExpectedConditions.presenceOfElementLocated(TEXT_FILE_NAME));
            driver.findElement(TEXT_FILE_NAME);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTextFromFile() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(TEXT_FILE_NAME));
        String originalWindow = driver.getWindowHandle();
        Set<String> oldWindowsSet = driver.getWindowHandles();
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(TEXT_FILE_NAME))
                .doubleClick().build().perform();
        String newWindow = (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<String>) webDriver -> {
                            Set<String> newWindowsSet = webDriver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        driver.switchTo().window(newWindow);
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(FRAME));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='WACViewPanel_EditingElement_WrappingDiv']//p//span//span")));
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='WACViewPanel_EditingElement_WrappingDiv']//p//span//span"));
        String text = "";
        for (WebElement e : list) {
            text += e.getAttribute("text");
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(BUTTON_FILE));
        driver.findElement(BUTTON_FILE).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(BUTTON_ESCAPE));
        Actions builder1 = new Actions(driver);
        builder1.moveToElement(driver.findElement(BUTTON_ESCAPE)).click().build().perform();
        driver.switchTo().window(originalWindow);
        return text;
    }

    public YandexDiskClientPage deleteFile() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(TEXT_FILE));
        Actions builder = new Actions(driver);
        builder.clickAndHold(driver.findElement(TEXT_FILE))
                .moveToElement(driver.findElement(TRASH)).release(driver.findElement(TRASH)).build().perform();
        return this;
    }

    public boolean findFileInTrash() {
        try {
            new WebDriverWait(driver, 20).
                    until(ExpectedConditions.presenceOfElementLocated(TEXT_FILE));
            driver.findElement(TEXT_FILE);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean findFileInFiles() {
        try {
            TimeUnit.SECONDS.sleep(5);
            driver.findElement(TEXT_FILE);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public YandexDiskClientPage clearTrash() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.presenceOfElementLocated(BUTTON_CLEAR_TRASH));
        driver.findElement(BUTTON_CLEAR_TRASH).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(BUTTON_CLEAR));
        driver.findElement(BUTTON_CLEAR).click();
        return this;
    }

    public boolean checkTrash() {
        try {
            TimeUnit.SECONDS.sleep(5);
            driver.findElement(TEXT_FILE);
            return true;
        } catch (NoSuchElementException | InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}

