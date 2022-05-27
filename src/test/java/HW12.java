import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW12 {

    /**
     * TC_12_02 Подтвердите, что в меню BROWSE LANGUAGES, подменю  M,
     * последний программный язык в таблице -  MySQL
     * Открыть базовую страницу
     * Нажать на пункт меню BROWSE LANGUAGES
     * Нажать на подменю M
     * Подтвердить, что последний язык программирования на странице - MySQL
     */

    @Test
    public void testLastLangMySQL() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://99-bottles-of-beer.net/";
        String expectedResult = "MySQL";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLang = driver
                .findElement(
                        By.xpath("//li/a[@href='/abc.html']"));
        menuBrowseLang.click();

        WebElement subMenuM = driver
                .findElement(
                        By.xpath("//a[@href='m.html']"));
        subMenuM.click();

        WebElement lastLangMySQL = driver
                .findElement(By.xpath("//tr[last()]/td/a"));

        String actualResult = lastLangMySQL.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     *TC_12_03 Подтвердите, что в меню BROWSE LANGUAGES существует таблица
     * с заголовками Language, Author, Date, Comments, Rate
     * Шаги:
     * Открыть базовую страницу
     * Нажать на пункт меню BROWSE LANGUAGES
     * Подтвердить, что существует таблица с заголовками Language, Author,
     * Date, Comments, Rate
     */

    @Test
    public void testHeaderOfTable() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://99-bottles-of-beer.net/";
        String expectedResult = "Language Author Date Comments Rate";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLang = driver
                .findElement(
                        By.xpath("//li/a[@href='/abc.html']"));
        menuBrowseLang.click();

        WebElement headersOfTable = driver
                .findElement(By.xpath("//table/tbody/tr"));

        String actualResult = headersOfTable.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_12_04 Подтвердите, что создатель решения на языке Mathematica -
     * Brenton Bostick, дата обновления решения на этом языке - 03/16/06,
     * и что это решение имеет 1 комментарий
     */
}
