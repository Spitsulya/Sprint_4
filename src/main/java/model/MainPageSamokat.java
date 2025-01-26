package model;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    // Переменная-локатор для всех вопросов
    private static final String ALL_QUESTIONS_ABOUT = (".//div[@id='accordion__heading-%d']");
    // Переменная-локатор для всех ответов
    private static final String ALL_ANSWERS_ABOUT = ("//div[@id='accordion__panel-%d']/p");

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
    // Находит каждый вопрос по его индексу (0-8)
    public WebElement getQuestionByIndex(int indexQ) {
        By locator = By.xpath(String.format(ALL_QUESTIONS_ABOUT, indexQ));
        return driver.findElement(locator);
    }
    // Находит каждый ответ по его индексу (0-8)
    public WebElement getAnswerByIndex(int indexA) {
        By locator = By.xpath(String.format(ALL_ANSWERS_ABOUT, indexA));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
    // Скроллит до конкретного вопроса из рубрики "Вопросы о важном"
    public void scrollToQuestions(int index) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", getQuestionByIndex(index));
    }
    // Раскрывает каждый вопрос
    public void сlickQuestions(int index) {
        getQuestionByIndex(index).click();
    }
    // Возвращает фактический текст ответа
    public String getTextAnswerAbout(int indexA) {
       return getAnswerByIndex(indexA).getText();
    }
    // Кликает по верхней кнопке заказать
    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }
    // Кликает по нижней кнопке заказать
    public void сlickOrderButtonBottom() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonBottom));
        driver.findElement(orderButtonBottom).click();
    }
}
