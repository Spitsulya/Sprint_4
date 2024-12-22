package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class RentAboutPage {
    private WebDriver driver;

    // локатор для поля Когда привезти самокат
    private By inputDataWhen = By.xpath(".//div[@id='root']/div/div[2]/div[2]/div[1]/div/div/input");
    // локатор для поля Срок аренды
    private By inputHowLong = By.xpath(".//div[@id='root']/div/div[2]/div[2]/div[2]/div/div[1]");
    // локатор для поля Цвет самоката черный
    private By inputSamokatColorBlack = By.xpath(".//div[@id='root']/div/div[2]/div[2]/div[3]/label[1]");
    // локатор для поля Цвет самоката серый
    private By inputSamokatColorGray = By.xpath(".//div[@id='root']/div/div[2]/div[2]/div[3]/label[2]");


    // локатор для поля Комментарий
    private By inputComment = By.xpath(".//div[@id='root']/div/div[2]/div[2]/div[4]/input");

    // локатор для кнопки Заказать
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор для кнопки Назад
    private By backButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    // локатор для кнопки Да (всплывающее окно Хотите оформить заказ)
    private By yesButton = By.xpath(".//div[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    // локатор для кнопки Посмотреть статус заказа
    private By statusButton = By.xpath(".//button[text()='Посмотреть статус']");

    public RentAboutPage(WebDriver driver) {
        this.driver = driver;
    }


    // метод для заполнения поля Когда
    public void setDataWhen(String dataWhen) {
        driver.findElement(inputDataWhen).sendKeys(dataWhen);
        driver.findElement(By.xpath(".//div[@id='root']/div")).click();
    }
    // метод для заполнения поля Срок аренды
    public void setHowlong() {
        driver.findElement(inputHowLong).click();
        driver.findElement(By.xpath(".//div[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div[1]")).click();
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
    public void inputAllFieldsAndOrder(String dataWhen, String comment) {
        setDataWhen(dataWhen);
        setHowlong();
        setSamokatColor();
        setComment(comment);
        clickOrderButton();
        clickYesButton();

    }
}
