import model.MainPageSamokat;
import model.RentAboutPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import model.ForWhoSamokatPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderBottomButtonTest {

    private static final String SAMOKAT_URL = "https://qa-scooter.praktikum-services.ru/";
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

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(SAMOKAT_URL);
        MainPageSamokat mainPageSamokat2 = new MainPageSamokat(driver);
        mainPageSamokat2.сlickOrderButtonBottom();
        forWhoSamokatPage = new ForWhoSamokatPage(driver);

    }

    @Parameterized.Parameters
    public static Collection<Object[]> loginFor() {
        return Arrays.asList(new Object[][]{
                {"Элина", "Спицына", "г. Домодедово", "Арбатская", "+79854707022"},
                {"Руслан", "Тимонин", "г. Домодедово", "Домодедовская", "+79852146729"}
        });
    }

    @Test
    public void testFillOrderForm() {
        forWhoSamokatPage.inputAllFieldsAndGoNext(name, surname, address, metroStation, phoneNumber);
        forWhoSamokatPage.clickNextButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 секунд ожидания, пока не появится следующая страница
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']")));

        RentAboutPage rentAboutPage = new RentAboutPage(driver);
        rentAboutPage.inputAllFieldsAndOrder("25.01.2025", "ЮЮЮЮЮЮЮХУ");

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
