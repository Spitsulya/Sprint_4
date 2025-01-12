package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class RentAboutPage {
    private WebDriver driver;
    private static final By STATUS_BUTTON_LOCATOR = By.xpath(".//button[text()='Посмотреть статус']");

    // локатор для поля Когда привезти самокат
    private By inputDataWhen = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // локатор, переключающий на следующий месяц
    private By dataNextMonth = (By.xpath(".//button[text()='Next Month']"));
    // локатор даты 15-го числа
    private By dataFifteenth = (By.xpath(".//*[text()='15']"));
    // локатор для поля Срок аренды
    private By inputHowLong = By.xpath(".//div[text()='* Срок аренды']");
    // локатор для поля Цвет самоката черный
    private By inputSamokatColorBlack = By.xpath(".//input[@id='black']");
    // локатор для поля Цвет самоката серый
    private By inputSamokatColorGray = By.xpath(".//input[@id='grey']");
    // локатор для поля Срок аренды: сутки
    private By oneDayRent = By.xpath(".//div[text()='сутки']");


    // локатор для поля Комментарий
    private By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // локатор для кнопки Заказать
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор для кнопки Назад
    private By backButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    // локатор для кнопки Да (всплывающее окно Хотите оформить заказ)
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    // локатор для кнопки Посмотреть статус заказа
    private By statusButton = By.xpath(".//button[text()='Посмотреть статус']");

    public RentAboutPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для заполнения поля Когда
    public void setDataWhen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 секунд ожидания, пока не появится страница
        wait.until(ExpectedConditions.visibilityOfElementLocated(backButton));
        driver.findElement(inputDataWhen).click();
        driver.findElement(dataNextMonth).click();
        driver.findElement(dataFifteenth).click();
    }
    // метод для заполнения поля Срок аренды
    public void setHowlong() {
        driver.findElement(inputHowLong).click();
        driver.findElement(oneDayRent).click();
    }
    // метод для заполнения поля Цвет самоката
    public void setSamokatColor() {
        driver.findElement(inputSamokatColorBlack).click();
    }
    // метод для заполнения поля Комментарий
    public void setComment(String comment) {
        driver.findElement(inputComment).sendKeys(comment);
    }
    // метод, нажимающий на кнопку Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    // метод, нажимающий на кнопку подтверждения заказа - Да - заказ успешный
    public void clickYesButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(yesButton).click();
        driver.findElement(statusButton); // на всплывающем окне с сообщением об успехе
    }


    // метод для заполнения всех полей и оформления заказа
    public void inputAllFieldsAndOrder( String comment) {
        setDataWhen();
        setHowlong();
        setSamokatColor();
        setComment(comment);
        clickOrderButton();
        clickYesButton();
    }

    public void verifyPageHasStatusButton() {
        // Находим кнопку по локатору
        WebElement statusButton = driver.findElement(STATUS_BUTTON_LOCATOR);
        // Проверяем, что кнопка отображается на странице
        assertTrue("Кнопка 'Посмотреть статус' не отображается на странице", statusButton.isDisplayed());
    }

}
