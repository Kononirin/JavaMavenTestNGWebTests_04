import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Integer.parseInt;

public class HW12 {

    final String BASE_URL = "http://99-bottles-of-beer.net/";
    final String URL_BROWSE_LANG = "http://www.99-bottles-of-beer.net/abc.html";
    final String CHROME_DRIVER = "webdriver.chrome.driver";
    final String DRIVER_PATH = "D:/chromedriver.exe";

    /**
     * TC_12_01 Подтвердите, что в меню BROWSE LANGUAGES, подменю  J,
     * пользователь может найти описание страницы, на которой перечеслены
     * все программные языки, начинающиеся с буквы J, отсортированные
     * по названию
     * Шаги:
     * Открыть базовую страницу
     * Нажать на пункт меню BROWSE LANGUAGES
     * Нажать на подменю J
     * Подтвердить, что пользователь видит текст “All languages starting
     * with the letter J are shown, sorted by Language.”
     */

    @Test
    public void testTitleSubmenuByJ() {

        String expectedResult = "All languages starting with the letter J " +
                "are shown, sorted by Language.";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        WebElement menuBrowseLanguages = driver
                .findElement(
                        By.xpath("//li/a[@href='/abc.html']"));
        menuBrowseLanguages.click();

        WebElement subMenuJ = driver
                .findElement(
                        By.xpath("//li/a[@href='j.html']"));
        subMenuJ.click();

        String actualResult =
                driver
                        .findElement(
                                By.xpath("//div[@id='main']/p"))
                        .getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_12_02 Подтвердите, что в меню BROWSE LANGUAGES, подменю  M, последний
     * программный язык в таблице -  MySQL
     * Шаги:
     * Открыть базовую страницу
     * Нажать на пункт меню BROWSE LANGUAGES
     * Нажать на подменю M
     * Подтвердить, что последний язык программирования на странице - MySQL
     */

    @Test
    public void testSubmenuMLastLangMySQL() {

        String expectedResult = "MySQL";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        WebElement menuBrowseLang = driver
                .findElement(
                        By.xpath("//li/a[@href='/abc.html']")
                );
        menuBrowseLang.click();

        WebElement subMenuM = driver
                .findElement(
                        By.xpath("//a[@href='m.html']")
                );
        subMenuM.click();

        WebElement lastLangMySQL = driver
                .findElement(By.xpath("//tr[last()]/td/a")
                );

        String actualResult = lastLangMySQL.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_12_03 Подтвердите, что в меню BROWSE LANGUAGES существует таблица
     * с заголовками Language, Author, Date, Comments, Rate
     */

    @Test
    public void testHeaderOfTableBrowseLang() {

        String expectedResult = "Language Author Date Comments Rate";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        WebElement menuBrowseLang = driver
                .findElement(
                        By.xpath("//li/a[@href='/abc.html']"));
        menuBrowseLang.click();

        WebElement headerOfTable = driver.findElement(
                By.xpath("//table/tbody/tr"));

        String actualResult = headerOfTable.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_12_04 Подтвердите, что создатель решения на языке Mathematica -
     * Brenton Bostick, дата обновления решения на этом языке - 03/16/06, и
     * что это решение имеет 1 комментарий
     */

    @Test
    public void testInfoOfMathLang() {

        String expectedResultOne = "Brenton Bostick";
        String expectedResultTwo = "03/16/06";
        String expectedResultThree = "1";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL_BROWSE_LANG);

        WebElement subMenuM = driver
                .findElement(
                        By.xpath("//a[@href='m.html']"));
        subMenuM.click();

        WebElement langMathematika = driver.findElement(
                By.xpath("//a[@href='language-mathematica-1090." +
                        "html']"));
        langMathematika.click();

        WebElement tableOfMathemAuthor = driver.findElement(
                By.xpath("//table[@style='margin: 7px; " +
                        "padding: 0;;']/tbody/tr[2]/td[last()]")
        );
        String actualResultOne = tableOfMathemAuthor.getText();

        WebElement tableOfMathemDate = driver.findElement(
                By.xpath("//table[@style='margin: 7px; " +
                        "padding: 0;;']/tbody/tr[1]/td[last()]")
        );
        String actualResultTwo = tableOfMathemDate.getText();

        WebElement tableOfMathemComment = driver.findElement(
                By.xpath("//table[@style='margin: 7px; " +
                        "padding: 0;;']/tbody/tr[4]/td[last()]")
        );

        String actualResultThree = tableOfMathemComment.getText();

        Assert.assertEquals(actualResultOne, expectedResultOne);
        Assert.assertEquals(actualResultTwo, expectedResultTwo);
        Assert.assertEquals(actualResultThree, expectedResultThree);

        driver.quit();
    }

    //тест вариант ирины со скачиванием всей таблицы
    @Test
    public void testInfoOfMathLangIrinasVariant() {

        String languageExpected = "Mathematica";
        String authorExpected = "Brenton Bostick";
        String dateExpected = "03/16/06";
        String commentsExpected = "1";

        StringBuilder expectedResult = new StringBuilder();
        expectedResult
                .append(languageExpected)
                .append(" ")
                .append(authorExpected)
                .append(" ")
                .append(dateExpected)
                .append(" ")
                .append(commentsExpected);

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);
        driver.findElement(By.linkText("Browse Languages")).click();
        driver.findElement(By.linkText("M")).click();

        List<WebElement> trs = driver
                .findElements(
                        By.xpath("//table[@id='category']/tbody/tr")
                );

        List<String> actualResult = new ArrayList<>();

        for (WebElement tr : trs) {
            if (tr.getText().contains("Mathematica")) {
                actualResult.add(tr.getText());
            }
        }

        //подтверждаем, что нам пришла одна строка
        Assert.assertEquals(actualResult.size(), 1);
        //проверяем что пришедшая строка не пустая
        Assert.assertFalse(actualResult.get(0).isEmpty());
        //проверяем что пришедшая строка не пустая
        //Assert.assertTrue(!actualResult.get(0).isEmpty());

        Assert.assertEquals(actualResult.get(0), expectedResult.toString());

        driver.quit();
    }

    /**
     * TC_12_05 Подтвердите, что на сайте существует 10 языков,
     * названия которых начинаются с цифр.
     */

    @Test
    public void testExistTenLangsStartsFromDigit() {

        int expectedResult = 10;

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL_BROWSE_LANG);

        WebElement submenuZeroNine = driver.
                findElement(By.xpath("//ul[@id='submenu']/" +
                        "li/a[@href='0.html']")
                );
        submenuZeroNine.click();

        String[] countLines = new String[10];

        WebElement firstLine = driver.
                findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[2]/td/a")
                );
        countLines[0] = firstLine.getText();

        WebElement secondLine = driver.
                findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[3]/td/a")
                );
        countLines[1] = secondLine.getText();

        WebElement thirdLine = driver.
                findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[4]/td/a")
                );
        countLines[2] = thirdLine.getText();

        WebElement fourthLine = driver.
                findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[5]/td/a")
                );
        countLines[3] = fourthLine.getText();

        WebElement fifthLine = driver.
                findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[6]/td/a")
                );
        countLines[4] = fifthLine.getText();

        WebElement sixthLine = driver.
                findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[7]/td/a")
                );
        countLines[5] = sixthLine.getText();

        WebElement seventhLine = driver.
                findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[8]/td/a")
                );
        countLines[6] = seventhLine.getText();

        WebElement eighthLine = driver.
                findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[9]/td/a")
                );
        countLines[7] = eighthLine.getText();

        WebElement ninethLine = driver.
                findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[10]/td/a")
                );
        countLines[8] = ninethLine.getText();

        WebElement tenthLine = driver.
                findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[11]/td/a")
                );
        countLines[9] = tenthLine.getText();

        Assert.assertEquals(countLines.length, expectedResult);

        driver.quit();
    }

    //второй вариант решения TC_12_05 через лист
    @Test
    public void testExistTenLangsFromDigits() {

        int expectedResult = 10;

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL_BROWSE_LANG);

        WebElement submenuZeroNine = driver.findElement(By.linkText("0-9"));
        submenuZeroNine.click();

        List<WebElement> trs = driver
                .findElements(
                        By.xpath("//table[@id='category']/" +
                                "tbody/tr")
                );

        int actualResult = trs.size() - 1;

        Assert.assertEquals((actualResult), expectedResult);

        driver.quit();
    }

    /**
     * TC_12_06 Подтвердите, что если на странице Sign Guestbook
     * http://www.99-bottles-of-beer.net/signv2.html вы заполните все поля
     * формы, но введете случайно сгенерированное трехзначное число в поле
     * Security Code: , то вы получите сообщение об ошибке
     * Error: Error: Invalid security code.
     */

    public void testIncorrectSecurityCode() {

        String expectedResult = "Error: Error: Invalid security code.";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/signv2.html");


        driver.findElement(
                        By.xpath("//div[@id='main']/form/p/" +
                                "input[@name='name']"))
                .sendKeys("Irina Sh.");

        driver.findElement(
                        By.xpath("//div[@id='main']/form/p/" +
                                "input[@name='location']"))
                .sendKeys("RF");

        driver.findElement(
                        By.xpath("//div[@id='main']/form/p/" +
                                "input[@name='email']"))
                .sendKeys("test@gmail.com");

        driver.findElement(
                        By.xpath("//div[@id='main']/form/p/" +
                                "input[@name='homepage']"))
                .sendKeys("http://test.com");

        String randomDigit = "" + ((int) (Math.random() * 900) + 100);
        driver.findElement(
                        By.xpath("//div[@id='main']/form/p/" +
                                "input[@name='captcha']"))
                .sendKeys(randomDigit);

        driver.findElement(
                        By.xpath("//textarea[@name='comment']"))
                .sendKeys("Frist comment");

        driver.findElement(
                By.xpath("//input[@type='submit']")).click();

        String actualResult = driver.findElement(
                By.xpath("//div[@id='main']/p")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    /**
     * TC_12_07 Выберите любой язык программирования (из меню BROWSE LANGUAGES)
     * и любую версию решения (из раздела Alternative Versions, если такой
     * раздел существует  для выбранного языка)
     * Подтвердите, что пользователь может сделать закладку на это решение
     * на сайте Reddit (нажав на иконку сайта Reddit, пользователь перейдет
     * на Логин страницу сайта Reddit)
     */

    @Test
    public void testIconReddit() {

        String expectedResult = "Log in";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        WebElement menuBrowseLang = driver
                .findElement(
                        By.xpath("//li/a[@href='/abc.html']")
                );
        menuBrowseLang.click();

        WebElement langAssembler = driver
                .findElement(By.xpath("//table[@id='category']/" +
                        "tbody/tr[68]/td/a")
                );
        langAssembler.click();

        WebElement alternativeLangSparc = driver
                .findElement(By.xpath("//div[@id='alternatives']" +
                        "/table/tbody/tr[3]/td/a")
                );
        alternativeLangSparc.click();

        WebElement iconReddit = driver
                .findElement(By.xpath("//div[@id='voting']/p" +
                        "/a[@title='reddit']")
                );
        iconReddit.click();

        String actualResult = driver
                .findElement(
                        By.xpath("//div[@class='Step__content']" +
                                "/h1")).getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_12_08 Подтвердите, что решение на языке Shakespeare входит в топ 20
     * всех решений, в топ 10 решений на Esoteric Languages и в топ 6
     * решений-хитов. Но решение на языке Shakespeare не входит в список
     * топовых решений на реальных языках программирования.
     * (Можно написать одним тестом, но так, чтобы все Asserts
     * были в конце теста. Или можно написать отдельные тесты на каждый
     * requirenment.)
     */

    @Test
    public void testLangShakespeareTopRated() {

        boolean expectedResult = true;

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/toplist.html");

        WebElement numberOfRowOfShakespeareLang =
                driver.findElement(
                        By.xpath("//div[@id='main']/table" +
                                "/tbody/tr[17]/td")
                );
        String numberOfRate = numberOfRowOfShakespeareLang.getText();

        int numOfLasttIndex = numberOfRate.lastIndexOf('.');
        String numberWithoutDot = numberOfRate.substring(0, numOfLasttIndex);
        int numOfRate = parseInt(numberWithoutDot);

        boolean actualResult = false;
        if (numOfRate <= 20) {
            actualResult = true;
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testLangShakespeareTopRatedEsotericLang() {

        boolean expectedResult = true;

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/toplist.html");

        WebElement submenuTopRatedEsotericLang = driver.
                findElement(By.xpath("//li/a[@href='." +
                        "/toplist_esoteric.html']")
                );
        submenuTopRatedEsotericLang.click();

        WebElement numberOfRowOfShakespeareLang =
                driver.findElement(
                        By.xpath("//div[@id='main']/table" +
                                "/tbody/tr[8]/td")
                );

        String numberOfRate = numberOfRowOfShakespeareLang.getText();
        int numOfLastIndex = numberOfRate.lastIndexOf('.');
        String numberWithoutDot = numberOfRate.substring(0, numOfLastIndex);
        int numOfRate = parseInt(numberWithoutDot);

        boolean actualResult = false;
        if (numOfRate <= 10) {
            actualResult = true;
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testLangShakespeareTopRatedTopHits() {

        boolean expectedResult = true;

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/toplist.html");

        WebElement submenuTopRatedTopHits = driver.
                findElement(By.xpath("//a[@href='." +
                        "/tophits.html']")
                );
        submenuTopRatedTopHits.click();

        WebElement numberOfRowOfShakespeareLang =
                driver.findElement(
                        By.xpath("//div[@id='main']" +
                                "/table/tbody/tr[7]/td")
                );

        String numberOfRate = numberOfRowOfShakespeareLang.getText();
        int numOfLasttIndex = numberOfRate.lastIndexOf('.');
        String numberWithoutDot = numberOfRate.substring(0, numOfLasttIndex);
        int numOfRate = parseInt(numberWithoutDot);

        boolean actualResult = false;
        if (numOfRate <= 6) {
            actualResult = true;
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testLangShakespeareTopRatedRealLang() {

        boolean expectedResult = true;

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/toplist.html");

        WebElement submenuTopRatedRealLang = driver.
                findElement(By.xpath("//a[@href='." +
                        "/toplist_real.html']")
                );
        submenuTopRatedRealLang.click();

        String[] tableOfLangsRate = new String[25];
        boolean actualResult = false;

        for (int i = 0; i < tableOfLangsRate.length; i++) {
            int index = i + 2;
            tableOfLangsRate[i] =
                    driver.findElement(By.xpath(
                            "//table[@id='category']" +
                                    "/tbody/tr[" + index + "]")).getText()
            ;
            if (!tableOfLangsRate[i].contains("Shakespeare")) {
                actualResult = true;
            }
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_12_09 Подтвердите, что существует 6 версий решений на языке
     * программирования Java.
     */

    //решение с List
    @Test
    public void testExistSixVersuionsOfJava() {

        int expectedResult = 6;

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL_BROWSE_LANG);

        WebElement submenuJ = driver.
                findElement(By.linkText("J"));
        submenuJ.click();

        WebElement langJava = driver.
                findElement(By.linkText("Java"));
        langJava.click();

        List<WebElement> versionList = driver
                .findElements(
                        By.xpath("//table[@id='category']/" +
                                "tbody/tr")
                );

        int actualResult = versionList.size();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testExistSixVersuionsOfJava1() {

        int expectedResult = 6;
        int actualResult = 0;

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL_BROWSE_LANG);

        WebElement submenuJ = driver.
                findElement(By.xpath("//ul[@id='submenu']" +
                        "/li/a[@href='j.html']")
                );
        submenuJ.click();

        WebElement langJava = driver.
                findElement(By.
                        xpath("//a[@href='language-java-3.html']")
                );
        langJava.click();

        String nameOfVersion = driver.
                findElement(By.xpath("//div[@id='main']" +
                        "/p[@style='padding-top: 0; padding-bottom: 0;']"))
                .getText();

        actualResult++;

        String[] versionArray = new String[5];
        for (int i = 0; i < versionArray.length; i++) {
            int index = i + 2;
            versionArray[i] = driver.
                    findElement(By.xpath("//table" +
                            "[@id='category']/tbody/tr[" + index + "]"))
                    .getText();

            if (!versionArray[i].contains(nameOfVersion)) {
                actualResult++;
            }
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //решение другого ученика, на мой взгляд самое правильное
    @Test
    public void test9SixVersionsJava() {

        int expectedResult = 6;

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(BASE_URL);

        driver.findElement(By.linkText("Search Languages")).click();
        driver.findElement(By.name("search")).sendKeys("Java");
        driver.findElement(By.name("submitsearch")).click();

        int actualResult = 0;
        for (int i = 0; i < 14; i++) {
            int index = i + 2;
            if (driver.findElement(
                            By.xpath("//tr[" + index + "]/td[1]")).
                    getText().contains("Java (")
                    || driver.findElement(
                            By.xpath("//tr[" + index + "]/td[1]")).
                    getText().equals("Java")) {
                actualResult++;
            }
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_12_10 Подтвердите, что самое большое количество комментариев
     * для решений на языке Java имеет версия “object-oriented version”
     */

    @Test
    public void testCountCommentsOfObjOrientVers() {

        int expectedResult = 33;

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL_BROWSE_LANG);

        WebElement submenuJ = driver.
                findElement(By.xpath("//ul[@id='submenu']" +
                        "/li/a[@href='j.html']")
                );
        submenuJ.click();

        WebElement langJava = driver.
                findElement(By.
                        xpath("//a[@href='language-java-3.html']")
                );
        langJava.click();

        WebElement countCommentsOfObjOrientVers = driver
                .findElement(By.xpath("//table" +
                        "[@style='margin: 7px; padding: 0;;']" +
                        "/tbody/tr[4]/td[2]"));
        int actualResult = parseInt(countCommentsOfObjOrientVers.getText());

        int[] countOfAllComments = new int[5];
        for (int i = 0; i < countOfAllComments.length; i++) {
            int index = i + 2;
            countOfAllComments[i] = parseInt(driver.
                    findElement(By.xpath("//table" +
                            "[@id='category']/tbody/tr[" + index + "]/td[4]"))
                    .getText());

            if (countOfAllComments[i] > actualResult) {
                actualResult = countOfAllComments[i];
            }
        }

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
