package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static util.MethodWait.waitElementToBeClickable;
import static util.MethodWait.waitPresenceOfElementLocated;

public class PageForGenerateEmail extends AbstractPage {
    public PageForGenerateEmail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='copy_address']//span")
    WebElement copyEmailButton;

    @FindBy(xpath = "//span[@class='small_message_icon']")
    WebElement openMailButton;

    @FindBy(xpath = "//h3[contains(.,'USD')]")
    WebElement costFromEmail;

    private static final By MAIL_ICON = By.xpath("//h3[contains(.,'USD')]");

    public PageForGenerateEmail openPage() {
        driver.get("https://10minutemail.com");
        return this;
    }

    public PageForGenerateEmail copyEmail() {
        waitPresenceOfElementLocated(driver, By.xpath("//input[@id='mail_address']"));
        waitElementToBeClickable(driver, copyEmailButton);
        Actions builder = new Actions(driver);
        builder.moveToElement(copyEmailButton).click(copyEmailButton).build().perform();
        //copyEmailButton.click();
        return this;
    }

    public void switchToCalculator() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public PageForGenerateEmail openMail() {
        waitElementToBeClickable(driver, openMailButton);
        openMailButton.click();
        return this;
    }

    public String getCostFromEmail() {
        waitPresenceOfElementLocated(driver, MAIL_ICON);
        return costFromEmail.getText();
    }
}
