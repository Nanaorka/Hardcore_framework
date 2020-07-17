package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class PageForGenerateEmail extends AbstractPage {
    public PageForGenerateEmail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn-rds icon-btn bg-theme click-to-copy']")
    WebElement copyEmailButton;

    @FindBy(xpath = "//a[text()='Google Cloud Platform Price Estimate']")
    WebElement openMailButton;

    @FindBy(xpath = "//h3[contains(.,'USD')]")
    WebElement costFromEmail;

    public PageForGenerateEmail openPage() {
        driver.get("https://10minemail.com/ru/");
        return this;
    }

    public PageForGenerateEmail copyEmail() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(copyEmailButton));
        copyEmailButton.click();
        return this;
    }

    public void switchToCalculator() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public PageForGenerateEmail openMail() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(openMailButton));
        openMailButton.click();
        return this;
    }

    public String getCostFromEmail() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(.,'USD')]")));
        return costFromEmail.getText();
    }

}
