package page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    // локатор верхней кнопки «Заказать»
    private By topOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // локатор нижней кнопки «Заказать»
    private By bottomOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    private By cookieConfirmButton = By.id("rcc-confirm-button");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopOrderButton(){
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton(){
        driver.findElement(bottomOrderButton).click();
    }
    public void clickCookieConfirmButton(){
        driver.findElement(cookieConfirmButton).click();
    }

    public void waitForLoad(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(cookieConfirmButton));
    }

    public void clickByAccordeonItem(String buttonText, String displayedText){
        driver.findElement(By.xpath(".//div[@class='accordion__button' and text()='"+buttonText+"']/../..")).click();
        Assert.assertTrue(driver.findElement(By.xpath(".//div[@class='accordion__panel']/p[text()='"+displayedText+"']")).isDisplayed());
    }

}
