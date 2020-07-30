package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Register {


    static WebDriver driver;

    public static void sleep(int a) {
        try {
            Thread.sleep(a * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickOnElement(By by) {

        driver.findElement(by).click();

    }

    public static String getTextFromElement(By by) {

        return driver.findElement(by).getText();

    }

    public static void waitUntilElementClickable(By by, int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static void waitUntilElementToBeVisible(By by, int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    public static void selectFromDropDownByVisibleText(By by, String text) {

        new Select(driver.findElement(by)).deselectByVisibleText(text);

    }

    public static void selectFromDropDownByIndex(By by, int index) {

        new Select(driver.findElement(by)).deselectByIndex(index);

    }

    public static void selectFromDropDownByValu(By by, String value) {

        new Select(driver.findElement(by)).deselectByValue(value);

    }

    public static long timeStamp() {
        return (System.currentTimeMillis());
    }


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\CromeDriver\\83\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        clickOnElement(By.xpath("//li/a[contains(@class, \"ico\") and contains(@href,\"reg\")]"));//Click On Register Link Text
            clickOnElement(By.xpath("//span[@class=\"male\"]/input"));//Click On Gender (Male)
            typeText(By.xpath("//div[@class=\"fieldset\"]//div[2]/div[2]/input\t\n"), "User");//Type Text First Name
            typeText(By.xpath("//div[@class=\"fieldset\"]//div[2]/div[3]/input"), "Testing");//Type Text Last Name
            typeText(By.xpath("//div[@class=\"fieldset\"]//div[2]/div[5]/input"), "testing+" + timeStamp() + "@gmail.com");//Type Text Email
            //waitUntilElementClickable(By.xpath(""), 10);
            // waitUntilElementToBeVisible(By.xpath(""), 20);
            // String print1 = getTextFromElement(By.xpath(""));selectFromDropDownByIndex(By.xpath("//select[@name=\"DateOfBirthDay\"]"), 2);selectFromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), "November");
            selectFromDropDownByValu(By.xpath("//select[@name=\"DateOfBirthYear\"]"), "1990");// System.out.println(print1);

    }

}



