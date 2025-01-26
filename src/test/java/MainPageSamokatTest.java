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

    private final int indexQ; // индекс вопроса
    private final int indexA; // индекс ответа
    private final String expectedAnswerText; // ожидаемый текст ответа

    private WebDriver driver;

public MainPageSamokatTest(int indexQ, int indexA, String expectedAnswerText) {
    this.indexQ = indexQ;
    this.indexA = indexA;
    this.expectedAnswerText = expectedAnswerText;
}
    @Parameterized.Parameters
    public static Object[][] getLocators() {
    return new Object[][] {
            {0, 0, EXPECTED_TEXT_FIRST},
            {1, 1, EXPECTED_TEXT_SECOND},
            {2, 2, EXPECTED_TEXT_THIRD},
            {3, 3, EXPECTED_TEXT_FORTH},
            {4, 4, EXPECTED_TEXT_FIFTH},
            {5, 5, EXPECTED_TEXT_SIXTH},
            {6, 6, EXPECTED_TEXT_SEVENTH},
            {7, 7, EXPECTED_TEXT_EIGHTH},
    };
    }

    @Test
    public void testClickOnQuestionDisplaysCorrectAnswer() {
        driver = new ChromeDriver();

        MainPageSamokat mainPageSamokat = new MainPageSamokat(driver);
        // переходим на страницу Самокат
        mainPageSamokat.openSamokatURL();
        // закрываем всплывающие куки
        mainPageSamokat.closeCookie();
        // скроллим до нужного вопроса
        mainPageSamokat.scrollToQuestions(indexQ);
        // раскрываем нужный вопрос
        mainPageSamokat.сlickQuestions(indexQ);
        // находим нужный ответ
        mainPageSamokat.getAnswerByIndex(indexA);
        // получаем фактический текст ответа в переменную actualResultTest и сравниваем ее с ожидаемой expectedAnswerText
        String actualResultText = mainPageSamokat.getTextAnswerAbout(indexA);
        assertEquals("Текст не соответствует", expectedAnswerText, actualResultText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}