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
public class ForWhoSamokatPageTest {

    private WebDriver driver;
    private ForWhoSamokatPage forWhoSamokatPage;


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
    public String dataWhen;
    @Parameterized.Parameter(6)
    public String comment;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        MainPageSamokat mainPageSamokat2 = new MainPageSamokat(driver);
        mainPageSamokat2.openSamokatURL();
        mainPageSamokat2.clickOrderButtonTop();
        forWhoSamokatPage = new ForWhoSamokatPage(driver);

    }

    @Parameterized.Parameters
    public static Collection<Object[]> loginFor() {
        return Arrays.asList(new Object[][]{
                {"Элина", "Спицына", "г. Домодедово", "Арбатская", "+79854707022", "25.12.2024", "ВАУ"},
                {"Руслан", "Тимонин", "г. Домодедово", "Домодедовская", "+79852146729", "25.12.2024", "ВАУ"}
        });
    }

    @Test
    public void testFillOrderForm() {
        forWhoSamokatPage.inputAllFieldsAndGoNext(name, surname, address, metroStation, phoneNumber);
        forWhoSamokatPage.clickNextButton();

        RentAboutPage rentAboutPage = new RentAboutPage(driver);
        rentAboutPage.inputAllFieldsAndOrder(dataWhen, comment);

        rentAboutPage.verifyPageHasStatusButton(); // Проверка наличия кнопки с помощью assert
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}








