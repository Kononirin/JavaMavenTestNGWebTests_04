import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        //expectedResult = expectedResult.toLowerCase();

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubmitNewLang = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']"
                                + "/ul[@id='menu']/li/"
                                        + "a[@href='/submitnewlanguage.html']")
                );

        String actualResult = menuSubmitNewLang.getText().toLowerCase();

        Assert.assertEquals(actualResult, expectedResult);

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

    /**
     * TC_11_07 Придумайте и автоматизируйте свой собственный тест кейс
     * на сайте http://www.99-bottles-of-beer.net/
     *
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
     *
     */




}
