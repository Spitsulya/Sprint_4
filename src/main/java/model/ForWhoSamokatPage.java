package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForWhoSamokatPage {
    private WebDriver driver;

    // локатор для поля Имя
    private By inputName = By.xpath(".//div[@id='root']/div/div[2]/div[2]/div[1]/input");
    // локатор для поля Фамилия
    private By inputSurname = By.xpath(".//div[@id='root']/div/div[2]/div[2]/div[2]/input");
    // локатор для поля Адрес
    private By inputAddress = By.xpath(".//div[@id='root']/div/div[2]/div[2]/div[3]/input");
    // локатор для поля Станция метро
    private By inputMetroStation = By.xpath(".//div[@id='root']/div/div[2]/div[2]/div[4]/div/div/input");
    // локатор для поля Телефон
    private By inputPhoneNumber = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");

    // локатор для кнопки Далее
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public ForWhoSamokatPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для заполнения поля Имя
    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }
    // метод для заполнения поля Фамилия
    public void setSurname(String sureName) {
        driver.findElement(inputSurname).sendKeys(sureName);
    }
    // метод для заполнения оля Адрес
    public void setAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }
    // метод для заполнения поля Станция метро
    public void setMetroStation(String metroStation) {
        driver.findElement(inputMetroStation).sendKeys(metroStation);
        driver.findElement(By.xpath(".//div[@class='select-search__select']")).click();
    }
    // метод для заполнения поля Телефон
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }

    // метод, нажимающий на кнопку Далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // метод для заполнения всех полей и перехода на сл.страницу
    public void inputAllFieldsAndGoNext(String name, String sureName, String address, String metroStation, String phoneNumber) {
        setName(name);
        setSurname(sureName);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
        clickNextButton();
    }
}
