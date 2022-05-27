import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class WebTest {

    //Тест-кейс:
    //1. Открыть страницу "http://99-bottles-of-beer.net/
    //2. Нажать пункт меню BrowseLanguages
    //3. Нажать пункт меню Start
    //4. Подтвердить, что пользователь видит заголовок "Welcome to 99
    //   Bottles of Beer"
    //5. Закрыть бразуер

    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        //открываем страницу

        WebElement menuBrowseLanguages = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']"
                                + "/ul[@id='menu']/li/a[@href='/abc.html']")
                );
        //ищем пункт меню нужный нам
        menuBrowseLanguages.click();
        //кликаем на пункт меню
        //sleep(2000);
        //иногда задержки ставят, чтобы глазами видеть страницу
        //в итоговом коде тестов их убирают обычно

        WebElement menuStart = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']"
                                + "/ul[@id='menu']/li/a[@href='/']"));
        menuStart.click();
        //sleep(2000);

        WebElement h2 = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/h2"));
        String actualResult = h2.getText();
        //sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
        //закрываем страницу
    }

    /**
     * TC_11_01 Подтвердите, что на странице по базовой ссылке в правом
     * верхнем углу пользователь видит заголовок 99 Bottles of Beer
     * 1. Открыть вебсайт на базовой странице
     * 2. Считать заголовок в правом верхнем углу
     * 3. Подтвердить, что текст заголовка соответствует ожидаемому
     * 4. Закрыть браузер
     */

    @Test
    public void testTitleUpperRightCorner() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement titleUpperRightCorner = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='header']/h1")
                );


        String actualResult = titleUpperRightCorner.getText();
        sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_02 Подтвердите, что на странице по базовой ссылке последний
     * пункт меню называется Submit new Language
     * 1. Открыть вебсайт на базовой странице
     * 2. Считать название последнего пункта меню
     * 3. Подтвердить, что название последнего пункта меню соответствует
     * ожидаемому
     * 4. Закрыть браузер
     */

    @Test
    public void testMenuSubmitNewLang() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://99-bottles-of-beer.net/";
        String expectedResult = "Submit new Language";
        expectedResult = expectedResult.toLowerCase();

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubmitNewLang = driver
                .findElement(By
                        .xpath("//a[@href='/submitnewlanguage.html']")
                );

        String actualResult = menuSubmitNewLang.getText().toLowerCase();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testMenuSubmitNewLangShurikG() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://99-bottles-of-beer.net/";
        String expectedResult = "SUBMIT NEW LANGUAGE";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement liLast = driver
                .findElement(By
                        .xpath("//ul[@id='menu']/li[last()]")
                );

        Assert.assertEquals(liLast.getText(), expectedResult);

        driver.quit();
    }

    /**
     * TC_11_03 Подтвердите, что на странице по базовой ссылке последний
     * пункт меню имеет подзаголовок Submit new Language
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на пункт меню Submit new Language
     * 3. Считать название подзаголовка последнего пункта меню
     * 4. Подтвердить, что название подзаголовка последнего пункта меню
     * соответствует ожидаемому
     * 5. Закрыть браузер
     */

    @Test
    public void testSubtitleSubmitNewLang() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubmitNewLang = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']"
                                + "/ul[@id='menu']"
                                + "/li/a[@href='/submitnewlanguage.html']")
                );

        menuSubmitNewLang.click();

        WebElement subtitleSubmitNewLang = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']/"
                                + "ul[@id='submenu']/"
                                + "li/a[@href='./submitnewlanguage.html']")
                );

        String actualResult = subtitleSubmitNewLang.getText();
        System.out.println(actualResult);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_04 Подтвердите, что на странице по ссылке
     * http://www.99-bottles-of-beer.net/abc.html ,
     * первый пункт подменю называется 0-9
     * 1. Открыть вебсайт на странице
     * 2. Считать название первого подзаголовка
     * 3. Подтвердить, что название подменю соответствует ожидаемому
     * 4. Закрыть браузер
     */

    @Test
    public void testSubmenuFirstSubtitleZeroNine() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submenuFirstSubtitle = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']/"
                                + "ul[@id='submenu']/li/a[@href='0.html']")
                );

        String actualResult = submenuFirstSubtitle.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_06 Подтвердите, что имена создателей сайта:
     * Oliver Schade
     * Gregor Scheithauer
     * Stefan Scheler
     * Напишите самостоятельно (найдите информацию о создателях на сайте,
     * и опишите шаги для навигации и исполнения тест кейса)
     * 1. Открыть сайт на странице http://www.99-bottles-of-beer.net/team.html
     * 2. Считать имя первого в списке создателя сайта
     * 3. Считать имя второго в списке создателя сайте
     * 4. Считать имя третьего в списке создателя сайта
     * 5. Подтвердить, что имя первого создателя соответствует ожидаемому
     * 6. Подтвердить, что имя второго создателя соответствует ожидаемому
     * 7. Подтвердить, что имя третьего создателя соответствует ожидаемому
     * 8. Закрыть бразуер
     */

    @Test
    public void testNamesOfTeam() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/team.html";
        String expectedResultOne = "Oliver Schade";
        String expectedResultTwo = "Gregor Scheithauer";
        String expectedResultThree = "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement listOfTeam1 = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/"
                                + "h3[1]")
                );

        WebElement listOfTeam2 = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/"
                                + "h3[2]")
                );

        WebElement listOfTeam3 = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/"
                                + "h3[3]")
                );

        //варианты менее правильных xpath
        //"//*[@id=\"main\"]/h3[1]"
        ///html/body/div/div[3]/h3[1]

        String actualResultOne = listOfTeam1.getText();
        String actualResultTwo = listOfTeam2.getText();
        String actualResultThree = listOfTeam3.getText();

        Assert.assertEquals(actualResultOne, expectedResultOne);
        Assert.assertEquals(actualResultTwo, expectedResultTwo);
        Assert.assertEquals(actualResultThree, expectedResultThree);

        driver.quit();
    }

    @Test
    public void testNamesOfTeamContains() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/team.html";
        String expectedResultOne = "Oliver Schade";
        String expectedResultTwo = "Gregor Scheithauer";
        String expectedResultThree = "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        //в данном случае текст достается два раза, что нелогично, лучше так не делать
        WebElement listOfTeam1 = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/"
                                + "h3[contains(text(), 'Oliver Schade')]")
                );

        WebElement listOfTeam2 = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/"
                                + "h3[contains(text(), 'Gregor Scheithauer')]")
                );

        WebElement listOfTeam3 = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/"
                                + "h3[contains(text(), 'Stefan Scheler')]")
                );

        String actualResultOne = listOfTeam1.getText();
        String actualResultTwo = listOfTeam2.getText();
        String actualResultThree = listOfTeam3.getText();

        Assert.assertEquals(actualResultOne, expectedResultOne);
        Assert.assertEquals(actualResultTwo, expectedResultTwo);
        Assert.assertEquals(actualResultThree, expectedResultThree);

        driver.quit();
    }

    @Test
    public void testNamesOfTeamArray() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/team.html";
        String[] expectedResult = {"Oliver Schade",
                "Gregor Scheithauer",
                "Stefan Scheler"};

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        String[] actualResult = new String[3];

        WebElement listOfTeam1 = driver.findElement(By
                .xpath("//body//h3[text()='Oliver Schade']"));
        actualResult[0] = listOfTeam1.getText();

        WebElement listOfTeam2 = driver.findElement(By
                .xpath("//body//h3[text()='Gregor Scheithauer']"));
        actualResult[1] = listOfTeam2.getText();

        WebElement listOfTeam3 = driver.findElement(By
                .xpath("//body//h3[text()='Stefan Scheler']"));
        actualResult[2] = listOfTeam3.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_07 Придумайте и автоматизируйте свой собственный тест кейс
     * на сайте http://www.99-bottles-of-beer.net/
     * <p>
     * TC_11_07 Подтвердите, что на странице подменю Privacy пользователь
     * видит правильный электронный адрес
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на пункт подменю Privacy
     * 3. Считать электронный адрес
     * 4. Подтвердить, что электронный адрес соответствует ожидаемому
     * 5. Закрыть браузер
     */

    @Test
    public void testEmailAddress() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://99-bottles-of-beer.net/";
        String expectedResult = "os@ls-la.net";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submenuPrivacy = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']/"
                                + "ul[@id='submenu']/"
                                + "li/a[@href='impressum.html']")
                );

        submenuPrivacy.click();

        WebElement emailAddress = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/p")
                );

        String actualResult = emailAddress.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_11 Подтвердите, что если на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html,
     * пользователь нажмет кнопку Submit Language,  не заполнив информацию
     * в обязательных полях, будет показана ошибка
     * Error: Precondition failed - Incomplete Input.
     * Шаги:
     * 1. Открыть вебсайт на странице
     * 2. Нажать на кнопку Submit Language
     * 3. Подтвердить, что на странице показана ошибка
     * 4. Подтвердить, что текст ошибки соответствует ожидаемому
     * 5. Закрыть браузер
     */

    @Test
    public void testTextOfError() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResultOne = "Error:";
        String expectedResultTwo = "Error: Precondition failed - Incomplete"
                + " Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement buttonSubmitLang = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/"
                                + "form[@id='addlanguage']/p/"
                                + "input[@type='submit']")
                );

        buttonSubmitLang.click();

        WebElement styleOfError = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/"
                                + "p[@style='border: 1px solid red; "
                                + "background-color: #ffe0e0; padding: 5px; "
                                + "margin: 5px 10px 5px 10px;']/b/u")
                );

        WebElement textOfError = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/"
                                + "div[@id='main']/p")
                );

        String actualResultOne = styleOfError.getText();
        String actualResultTwo = textOfError.getText();

        Assert.assertEquals(actualResultOne, expectedResultOne);
        Assert.assertEquals(actualResultTwo, expectedResultTwo);

        driver.quit();
    }

    /**
     * TC_11_12 Precondition: Если на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
     * пользователь нажмет кнопку Submit Language,  не заполнив информацию
     * в обязательных полях, будет показана ошибка с текстом
     * Error: Precondition failed - Incomplete Input.
     * Подтвертите, что в тексте ошибки слова Error, Precondition, Incomplete
     * и Input написаны с большой буквы, а слово failed
     * написано  с маленькой буквы.
     * Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .
     * Шаги:
     * 1. Открыть вебсайт на странице
     * 2. Нажать на кнопку Submit Language
     * 3. Считать текст ошибки
     * 4. Подтвердить requirenments
     * 5. Закрыть браузер
     */

    @Test
    public void testWordsOfError() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult1 = "Error";
        String expectedResult2 = "Precondition";
        String expectedResult3 = "Incomplete";
        String expectedResult4 = "Input";
        String expectedResult5 = "failed";
        String expectedResult6 = ":";
        String expectedResult7 = "-";
        String expectedResult8 = ".";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement checkSpelling = driver.findElement(
                By.xpath("//p[@style]"));

        Assert.assertEquals(checkSpelling.getText().substring(0, 5), expectedResult1);
        Assert.assertEquals(checkSpelling.getText().substring(7, 19), expectedResult2);
        Assert.assertEquals(checkSpelling.getText().substring(29, 39), expectedResult3);
        Assert.assertEquals(checkSpelling.getText().substring(40, 45), expectedResult4);
        Assert.assertEquals(checkSpelling.getText().substring(20, 26), expectedResult5);
        Assert.assertEquals(checkSpelling.getText().substring(5, 6), expectedResult6);
        Assert.assertEquals(checkSpelling.getText().substring(27, 28), expectedResult7);
        Assert.assertEquals(checkSpelling.getText().substring(45),
                expectedResult8);

        driver.quit();
    }

    /**
     * TC_11_13 Подтвердите, что на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html
     * в первом пункте списка пользователь видит текст:
     * IMPORTANT: Take your time! The more carefully you fill out this form
     * (especially the language name and description), the easier it will be for
     * us and the faster your language will show up on this page.
     * We don't have the time to mess around with fixing your descriptions etc.
     * Thanks for your understanding.
     */

    @Test
    public void testTextOfWarning() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill "
                + "out this form (especially the language name and description), "
                + "the easier it will be for us and the faster your language will "
                + "show up on this page. We don't have the time to mess around with "
                + "fixing your descriptions etc. Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement wordsOfWarning = driver.findElement(
                By.xpath("//div[@id='main']/ul/li[1]"));

        String actualResult = wordsOfWarning.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_14 Подтвердите, что нажав на пункт меню Browse Languages, пользователь
     * увидит таблицу со следующими названиями для первого и второго столбцов:
     * Language
     * Author
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на пункт меню Browse Languages
     * 3. Считать названия первого и второго столбцов таблицы
     * 3. Подтвердить, что названия соответствует ожидаемым
     * 4. Закрыть браузер
     */

    @Test
    public void testNameOsFirstAndSecondColumn() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";
        String expectedResultOne = "Language";
        String expectedResultTwo = "Author";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLang = driver.findElement(
                By.xpath("//a[@href='/abc.html']"));
        menuBrowseLang.click();

        WebElement firstColumn = driver.findElement(
                By.xpath("//tbody/tr/th[1]"));
        String actualResultOne = firstColumn.getText();

        WebElement secondColumn = driver.findElement(
                By.xpath("//tbody/tr/th[2]"));
        String actualResultTwo = secondColumn.getText();

        Assert.assertEquals(actualResultOne, expectedResultOne);
        Assert.assertEquals(actualResultTwo, expectedResultTwo);

        driver.quit();
    }


    /**
     * TC_11_15 Подтвердите, что на странице по базовой ссылке  пользователь НЕ увидит
     * новые комментарии, если нажмет на пункты меню Top List → New Comments
     * Шаги: Придумать самостоятельно:
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на кнопку меню Top List
     * 3 Нажать на кнопку New Comments
     * 4. Подтвердить что пользователь не видит нове комментарии
     * 5. Закрыть браузер
     */

    @Test
    public void testNewCommentsList() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";
        String expectedResult = "";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement buttonTopList = driver.findElement(
                By.xpath("//li/a[@href='/toplist.html']"));
        buttonTopList.click();

        WebElement buttonNewComments = driver.findElement(
                By.xpath("//li/a[@href='./newcomments.html']"));
        buttonNewComments.click();

        WebElement noComments = driver.findElement(
                By.xpath("//div[@id='main']/p"));

        String actualResult = noComments.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_21 Подтвердите, что на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html пользователь видит
     * предупреждение IMPORTANT:, написанное белыми буквами bold шрифтом на красном фоне,
     * и что все буквы - capital
     * Шаги:
     * 1. Открыть вебсайт на странице
     * 2. Считать слово IMPORTANT: из списка
     * 3. Подтвердить requirenments
     * 4. Закрыть браузер
     */

    @Test
    public void testWordImportant() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT:";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        String bold = driver.findElement( By.xpath(
                "//body//div[@id='wrap']/div[@id='main']/" +
                        "ul/li/span[@style='background-color:red; color: white']/b"))
                .getTagName();

        Assert.assertEquals(bold, "b");

        WebElement important = driver.findElement(
                By.xpath("//body//div[@id='wrap']/div[@id='main']/" +
                        "ul/li/span[@style='background-color:red; color: white']"));

        String actualResult = important.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        String backgrounfColor = important.getCssValue("background-color");

        Assert.assertTrue(Color.fromString("#ff0000").equals(
                Color.fromString(backgrounfColor)));

        String color = important.getCssValue("color");

        Assert.assertTrue(Color.fromString("#ffffff").equals(
                Color.fromString(color)));

        driver.quit();
    }
}
