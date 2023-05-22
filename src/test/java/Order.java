import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.ModalWindow;
import page_objects.OrderPage;

@RunWith(Parameterized.class)
public class Order {

    private WebDriver driver;
    private OrderPage page;

    private String name;
    private String lastname;
    private String address;
    private String metro;
    private String phone;
    private String date;
    private String period;
    private boolean black;
    private boolean grey;
    private String comment;

    public Order(String name, String lastname, String address, String metro, String phone, String date, String period, boolean black, boolean grey, String comment) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.black = black;
        this.grey = grey;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {"Иван","Иванов", "Авиаторов д.1", "Черкизовская","12345678901","01.08.2023","сутки",true,false,"Осторожно злая пенсионерка на входе"},
                {"Маня","Петрова", "Водоплавотелей д.1", "Сокольники","12345678902","01.08.3000","четверо суток",false,false,"Осторожно дружелюбная пенсионерка на выходе"}
        };
    }

    @Before
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        page = new OrderPage(driver);
        page.waitForLoadHeader();
    }

    @Test
    public void Order(){
        page.setName(name);
        page.setLastName(lastname);
        page.setAddress(address);
        page.setMetro(metro);
        page.setPhone(phone);
        page.clickNext();
        page.waitForNextForm("Про аренду");
        page.setDate(date);
        page.setPeriod(period);
        if (black)
            page.clickBlack();
        if (grey)
            page.clickGrey();
        page.setInputComment(comment);
        page.clickOrderButton();

        ModalWindow window = new ModalWindow(driver);
        window.waitForModalWindowsShow();
        window.clickYes();
        window.waitForOrderConfirm();
    }

    @After
    public void close(){
        driver.quit();
    }

}
