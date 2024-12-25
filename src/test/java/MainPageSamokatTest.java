import model.MainPageSamokat;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import static model.MainPageSamokat.*;


@RunWith(Parameterized.class)
public class MainPageSamokatTest {

    private final By expectedQuestion;
    private final By expectedAnswer;
    private final String expectedAnswerText;

    private WebDriver driver;

public MainPageSamokatTest(By expectedQuestion, By expectedAnswer, String expectedAnswerText) {
    this.expectedQuestion = expectedQuestion;
    this.expectedAnswer = expectedAnswer;
    this.expectedAnswerText = expectedAnswerText;
}
    @Parameterized.Parameters
    public static Object[][] getLocators() {
    return new Object[][] {
            {COST_AND_HOW_TO_PAY_QUESTION_ABOUT, COST_AND_HOW_TO_PAY_ANSWER, EXPECTED_TEXT_FIRST},
            {QUANTITY_QUESTION_ABOUT, QUANTITY_QUESTION_ABOUT_ANSWER, EXPECTED_TEXT_SECOND},
            {TIME_RENT_QUESTION_ABOUT, TIME_RENT_QUESTION_ABOUT_ANSWER, EXPECTED_TEXT_THIRD},
            {RENT_TODAY_QUESTION_ABOUT, RENT_TODAY_QUESTION_ABOUT_ANSWER, EXPECTED_TEXT_FORTH},
            {RETURN_OR_RENEWAL_QUESTION_ABOUT, RETURN_OR_RENEWAL_QUESTION_ABOUT_ANSWER, EXPECTED_TEXT_FIFTH},
            {CHARGER_QUESTION_ABOUT, CHARGER_QUESTION_ABOUT_ANSWER, EXPECTED_TEXT_SIXTH},
            {CANCELLATION_QUESTION_ABOUT, CANCELLATION_QUESTION_ABOUT_ANSWER, EXPECTED_TEXT_SEVENTH},
            {OUTSIDE_MKAD_QUESTION_ABOUT, OUTSIDE_MKAD_QUESTION_ABOUT_ANSWER, EXPECTED_TEXT_EIGHTH},
    };
    }

    @Test
    public void testClickOnQuestionDisplaysCorrectAnswer() {
        driver = new ChromeDriver();

        MainPageSamokat mainPageSamokat = new MainPageSamokat(driver);
        mainPageSamokat.openSamokatURL(); // переходим на страницу Самокат

        mainPageSamokat.closeCookie(); // закрываем всплывающие куки
        mainPageSamokat.scrollToQuestions(expectedQuestion); // скроллим до нужного вопроса


        mainPageSamokat.сlickQuestions(expectedQuestion); // раскрываем нужный вопрос
        mainPageSamokat.getAnswerAbout(expectedAnswer); // находим нужный ответ

        // получаем фактический текст ответа в переменную actualResultTest и сравниваем ее с ожидаемой expectedAnswerText
        String actualResultText = mainPageSamokat.getTextAnswerAbout(expectedAnswer);
        assertEquals("Текст не соответствует", expectedAnswerText, actualResultText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}