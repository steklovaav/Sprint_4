package page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalWindow {
    private WebDriver driver;
    private By header = By.className("Order_ModalHeader__3FDaJ");
    private By buttonYes = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public ModalWindow(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForModalWindowsShow(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonYes));
    }

    public void clickYes(){
        driver.findElement(buttonYes).click();
    }

    public void waitForOrderConfirm() {
        Assert.assertTrue(new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElementLocated(header,"Заказ оформлен")));
    }


}
