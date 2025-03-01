import model.MainPageSamokat;
import model.RentAboutPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import model.ForWhoSamokatPage;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class OrderSamokatUsingTwoButtonsTest {

    private WebDriver driver;


    // Параметры для теста
    @Parameterized.Parameter(0)
    public String name;
    @Parameterized.Parameter(1)
    public String surname;
    @Parameterized.Parameter(2)
    public String address;
    @Parameterized.Parameter(3)
    public String metroStation;
    @Parameterized.Parameter(4)
    public String phoneNumber;
    @Parameterized.Parameter(5)
    public String comment;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(MainPageSamokat.SAMOKAT_URL);

    }

    @Parameterized.Parameters
    public static Collection<Object[]> loginFor() {
        return Arrays.asList(new Object[][]{
                {"Элина", "Спицына", "г. Домодедово", "Арбатская", "+79854707022", "ВАУ"},
                {"Руслан", "Тимонин", "г. Домодедово", "Домодедовская", "+79852146729", "ВАУ"}
        });
    }

    @Test
    // Оформление заказа с помощью нижней кнопки Заказать
    public void testFillOrderForms1() {
        MainPageSamokat mainPageSamokat = new MainPageSamokat(driver);
        mainPageSamokat.сlickOrderButtonBottom();
        ForWhoSamokatPage forWhoSamokatPage = new ForWhoSamokatPage(driver);
        forWhoSamokatPage.inputAllFieldsAndGoNext(name, surname, address, metroStation, phoneNumber);
        forWhoSamokatPage.clickNextButton();

        RentAboutPage rentAboutPage = new RentAboutPage(driver);
        rentAboutPage.inputAllFieldsAndOrder(comment);
        // Проверка наличия кнопки с помощью assert
        rentAboutPage.verifyPageHasStatusButton();
    }

    @Test
    // Оформление заказа с помощью верхней кнопки Заказать
    public void testFillOrderForms2() {
        MainPageSamokat mainPageSamokat = new MainPageSamokat(driver);
        mainPageSamokat.clickOrderButtonTop();
        ForWhoSamokatPage forWhoSamokatPage = new ForWhoSamokatPage(driver);
        forWhoSamokatPage.inputAllFieldsAndGoNext(name, surname, address, metroStation, phoneNumber);
        forWhoSamokatPage.clickNextButton();

        RentAboutPage rentAboutPage = new RentAboutPage(driver);
        rentAboutPage.inputAllFieldsAndOrder(comment);
        // Проверка наличия кнопки с помощью assert
        rentAboutPage.verifyPageHasStatusButton();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
