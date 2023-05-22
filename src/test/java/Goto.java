import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.MainPage;

public class Goto {
    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void init() {
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        mainPage.waitForLoad();
        mainPage.clickCookieConfirmButton();
    }

    @Test
    public void Order1(){
        mainPage.clickBottomOrderButton();
        Assert.assertEquals("https://qa-scooter.praktikum-services.ru/order",driver.getCurrentUrl());
    }
    @Test
    public void Order2(){
        mainPage.clickTopOrderButton();
        Assert.assertEquals("https://qa-scooter.praktikum-services.ru/order",driver.getCurrentUrl());
    }

    @After
    public void close(){
        driver.quit();
    }

}
