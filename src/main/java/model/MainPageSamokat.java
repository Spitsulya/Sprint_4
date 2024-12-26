package model;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


// КЛАСС ГЛАВНОЙ СТРАНИЦЫ САЙТА САМОКАТ
public class MainPageSamokat {
    private WebDriver driver;

    // локатор для кнопки заказать Сверху
    private By orderButtonTop = By.xpath(".//button[@class='Button_Button__ra12g']");
    // локатор для кнопки заказать Снизу
    private By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор для кнопки куки
    private By cookieButton = By.xpath(".//button[@id='rcc-confirm-button']");
    // константа URL
    public static final String SAMOKAT_URL = "https://qa-scooter.praktikum-services.ru/";

    // ЛОКАТОРЫ ВОПРОСОВ (1-8)
    public static final By COST_AND_HOW_TO_PAY_QUESTION_ABOUT = By.xpath(".//div[@id='accordion__heading-0']");
    public static final By QUANTITY_QUESTION_ABOUT = By.xpath(".//div[@id='accordion__heading-1']");
    public static final By TIME_RENT_QUESTION_ABOUT = By.xpath(".//div[@id='accordion__heading-2']");
    public static final By RENT_TODAY_QUESTION_ABOUT = By.xpath(".//div[@id='accordion__heading-3']");
    public static final By RETURN_OR_RENEWAL_QUESTION_ABOUT = By.xpath(".//div[@id='accordion__heading-4']");
    public static final By CHARGER_QUESTION_ABOUT = By.xpath(".//div[@id='accordion__heading-5']");
    public static final By CANCELLATION_QUESTION_ABOUT = By.xpath(".//div[@id='accordion__heading-6']");
    public static final By OUTSIDE_MKAD_QUESTION_ABOUT = By.xpath(".//div[@id='accordion__heading-7']");

    // ЛОКАТОРЫ ОТВЕТОВ (1-8)
    public static final By COST_AND_HOW_TO_PAY_ANSWER = By.xpath(".//div[@id='accordion__panel-0']/p");
    public static final By QUANTITY_QUESTION_ABOUT_ANSWER = By.xpath(".//div[@id='accordion__panel-1']/p");
    public static final By TIME_RENT_QUESTION_ABOUT_ANSWER = By.xpath(".//div[@id='accordion__panel-2']/p");
    public static final By RENT_TODAY_QUESTION_ABOUT_ANSWER = By.xpath(".//div[@id='accordion__panel-3']/p");
    public static final By RETURN_OR_RENEWAL_QUESTION_ABOUT_ANSWER = By.xpath(".//div[@id='accordion__panel-4']/p");
    public static final By CHARGER_QUESTION_ABOUT_ANSWER = By.xpath(".//div[@id='accordion__panel-5']/p");
    public static final By CANCELLATION_QUESTION_ABOUT_ANSWER = By.xpath(".//div[@id='accordion__panel-6']/p");
    public static final By OUTSIDE_MKAD_QUESTION_ABOUT_ANSWER = By.xpath(".//div[@id='accordion__panel-7']/p");

    // ОЖИДАЕМЫЕ ТЕКСТЫ ОТВЕТОВ (1-8)
    public static final String EXPECTED_TEXT_FIRST = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String EXPECTED_TEXT_SECOND = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String EXPECTED_TEXT_THIRD = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String EXPECTED_TEXT_FORTH = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String EXPECTED_TEXT_FIFTH = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String EXPECTED_TEXT_SIXTH = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String EXPECTED_TEXT_SEVENTH = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String EXPECTED_TEXT_EIGHTH = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    // конструктор класса Page Object
    public MainPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    // Открывает сайт Самокат
    public void openSamokatURL() {
        driver.get(SAMOKAT_URL);
    }
    // Закрывает куки
    public void closeCookie () {
        driver.findElement(cookieButton).click();
    }
    // Скроллит до конкретного вопроса из рубрики "Вопросы о важном"
    public void scrollToQuestions(By expectedQuestion) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(expectedQuestion));
    }
    // Раскрывает каждый вопрос
    public void сlickQuestions(By expectedQuestion) {
        driver.findElement(expectedQuestion).click();
    }
    // Находит каждый ответ
    public void getAnswerAbout(By expectedAnswer) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(expectedAnswer));
        driver.findElement(expectedAnswer);
    }
    // Возвращает фактический текст ответа
    public String getTextAnswerAbout(By expectedAnswer) {
       return driver.findElement(expectedAnswer).getText();
    }



    // кликнуть по верхней кнопке заказать
    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }
    // кликнуть по нижней кнопке заказать
    public void сlickOrderButtonBottom() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonBottom));
        driver.findElement(orderButtonBottom).click();
    }
}
