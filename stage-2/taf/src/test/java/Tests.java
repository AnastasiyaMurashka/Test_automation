import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Tests {
    WebDriver driver = new ChromeDriver();
    YandexDiskMainPage yandexDiskMainPage = new YandexDiskMainPage(driver);

    @BeforeTest
    public void openPage() {
        driver.get("https://disk.yandex.by/");
        driver.manage().window().maximize();
        yandexDiskMainPage.clickEntryButton().inputLogin().clickEnterAfterLoginInput().inputPassword().clickEnterAfterPasswordInput();
    }

    @Test
    public void checkRecent() {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToRecent().getTitle().contains("Последние"));
    }

    @Test
    public void checkFiles() {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToFiles().getTitle().contains("Файлы"));
    }

    @Test(priority = 1)
    public void checkPhoto() {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToPhoto().getTitle().contains("Все фотографии"));
    }

    @Test
    public void checkAlbums() {
        Assert.assertEquals(new YandexDiskClientPage(driver).switchToAlbums().getTitle(), "Альбомы");
    }

    @Test(priority = 1)
    public void checkPublished() {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToPublished().getTitle().contains("Публичные ссылки"));
    }

    @Test
    public void checkJournal() {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToJournal().getTitle().contains("История"));
    }

    @Test
    public void checkArchive() {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToArchive().getTitle().contains("Архив"));
    }

    @Test
    public void checkTrash() {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToTrash().getTitle().contains("Корзина"));
    }

    @Test(priority = 1)
    public void checkCreationOfFolder() {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToFiles().createNewFolder("Epam")
                .checkCreateNewFolder("Epam"));
    }

    @Test(priority = 2)
    public void checkVisitNewFolder() {
        Assert.assertEquals(new YandexDiskClientPage(driver).switchToFiles().goIntoFolder().getTitle(), "Epam");
    }

    @Test(priority = 3)
    public void checkCreateTExtFile() throws InterruptedException {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToFiles().goIntoFolder()
                .createTextFile("Text").checkCreateNewTextFie());
    }

    @Test(priority = 5)
    public void checkFileIsAbsentInFiles() throws InterruptedException {
        Assert.assertFalse(new YandexDiskClientPage(driver).switchToFiles().goIntoFolder().deleteFile()
                .findFileInFiles());
    }

    @Test(priority = 6)
    public void checkDeleteFile() {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToTrash().findFileInTrash());
    }

    @Test(priority = 7)
    public void checkClearTrash() {
        Assert.assertFalse(new YandexDiskClientPage(driver).switchToTrash().clearTrash().checkTrash());
    }

    @Test(priority = 4)
    public void getTextFromFile() {
        Assert.assertTrue(new YandexDiskClientPage(driver).switchToFiles().goIntoFolder().getTextFromFile().equals(" Hi my name is EVA"));
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
        driver = null;
    }
}

