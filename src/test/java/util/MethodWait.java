package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodWait {
    public static void waitPresenceOfElementLocated(WebDriver driver, By by) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementToBeClickable(WebDriver driver, By by) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(by));
    }
}
