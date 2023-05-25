package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPage {
    private WebDriver driver;

    private By header = By.className("Order_Header__BZXOb");
    private By buttonNext = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");
    private By inputName = By.xpath(".//div[@class='Order_Form__17u6u']/div[1]/input[@placeholder='* Имя']");
    private By inputLastName = By.xpath(".//div[@class='Order_Form__17u6u']/div[2]/input[@placeholder='* Фамилия']");
    private By inputAddress = By.xpath(".//div[@class='Order_Form__17u6u']/div[3]/input[@placeholder='* Адрес: куда привезти заказ']");
    private By inputMetro = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]/div[@class='select-search']/div[@class='select-search__value']/input[@placeholder='* Станция метро']");
    private By selectMetro = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]/div[@class='select-search']/div[@class='select-search__select']");
    private By inputPhone = By.xpath(".//div[@class='Order_Form__17u6u']/div[5]/input[@placeholder='* Телефон: на него позвонит курьер']");
    private By inputDate = By.xpath(".//div[@class='Order_Form__17u6u']/div[@class='Order_MixedDatePicker__3qiay']/div[@class='react-datepicker-wrapper']/div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");
    private By dropdownPeriod = By.xpath(".//div[@class='Order_Form__17u6u']/div[@class='Dropdown-root']/div[@class='Dropdown-control']");
    private By periodOptions = By.xpath(".//div[@class='Order_Form__17u6u']/div[@class='Dropdown-root is-open']/div[@class='Dropdown-menu']/div[@class='Dropdown-option']");
    private By checkBoxBlack = By.id("black");
    private By checkBoxGrey = By.id("grey");
    private By inputComment = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]/input[@placeholder='Комментарий для курьера']");
    private By buttonOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setName(String name) {
        WebElement element = driver.findElement(inputName);
        element.clear();
        element.sendKeys(name);
    }

    public void setLastName(String lastName){
        WebElement element = driver.findElement(inputLastName);
        element.clear();
        element.sendKeys(lastName);
    }

    public void setAddress(String address){
        WebElement element = driver.findElement(inputAddress);
        element.clear();
        element.sendKeys(address);
    }

    public void setPhone(String phone){
        WebElement element=driver.findElement(inputPhone);
        element.clear();
        element.sendKeys(phone);
    }

    public void setMetro(String metro){
        driver.findElement(inputMetro).click();
        driver.findElement(By.xpath(".//*[text()='"+metro+"']")).click();
    }

    public void clickNext(){
        driver.findElement(buttonNext).click();
    }

    // метод ожидания загрузки страницы
    public void waitForLoadHeader(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(header));
    }
    public void waitForNextForm(String formHeader) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElementLocated(header,formHeader));
    }

    public void setDate(String date){
        WebElement element=driver.findElement(inputDate);
        element.clear();
        element.sendKeys(date);
        element.sendKeys(Keys.ENTER);
    }

    private void waitForShowPeriodList(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(periodOptions));
    }

    public void setPeriod(String period) {
        driver.findElement(dropdownPeriod).click();
        waitForShowPeriodList();
        List<WebElement> options = driver.findElements(periodOptions);
        for (WebElement element : options) {
            if (element.getText().equals(period)) {
                element.click();
                break;
            }
        }
    }

    public void clickBlack(){
        driver.findElement(checkBoxBlack).click();
    }

    public void clickGrey(){
        driver.findElement(checkBoxGrey).click();
    }

    public void setInputComment(String comment){
        WebElement element=driver.findElement(inputComment);
        element.clear();
        element.sendKeys(comment);
    }

    public void clickOrderButton(){
        driver.findElement(buttonOrder).click();
    }

}
