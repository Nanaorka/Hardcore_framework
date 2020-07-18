package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import models.Calculator;
import service.CalculatorCreator;
import service.GeneratorXpath;

import java.util.ArrayList;

import static util.MethodWait.waitElementToBeClickable;
import static util.MethodWait.waitPresenceOfElementLocated;

public class CalculatorPage extends AbstractPage {

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    private Calculator calculator= CalculatorCreator.withCredentialsFromProperty();
    private GeneratorXpath generatorXpath=new GeneratorXpath();
    private static final By COMPUTER_ENGINE_BUTTON = By.xpath("//md-tab-item/*[@title='Compute Engine']");
    private static final By FRAME = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");
    private static final By EMAIL_INPUT_BOX = By.xpath("//input[@type='email']");
    private static final By SEND_EMAIL_BUTTON = By.xpath("//*[@aria-label='Send Email']");
    private static final By COST_FROM_ESTIMATE = By.xpath("//h2[@class='md-title']/b[@class='ng-binding']");
    private By VALUE_OF_OPERATING_SYSTEM_BUTTON = By.xpath(generatorXpath.getXpathForOperatingSystemValue());
    private By VALUE_OF_MACHINE_CLASS_BUTTON = By.xpath(generatorXpath.getXpathForMachineClass());
    private By VALUE_OF_MACHINE_TYPE_BUTTON = By.xpath(generatorXpath.getXpathForMachineType());
    private By VALUE_OF_NUMBER_OF_GPUS_BUTTON = By.xpath(generatorXpath.getXpathForNumberOfGpus());
    private By VALUE_OF_GPU_TYPE_BUTTON = By.xpath(generatorXpath.getXpathForGpuType());
    private By VALUE_OF_LOCAL_SSD_BUTTON = By.xpath(generatorXpath.getXpathForLocalSSD());
    private By VALUE_OF_DATACENTER_LOCATION_BUTTON = By.xpath(generatorXpath.getXpathForDatacenterLocation());
    private By VALUE_OF_COMMITTED_USAGE_BUTTON = By.xpath(generatorXpath.getXpathForCommitedUsage());
    private static final By VALUE_OF_VM_TYPE_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'VM class')]");
    private static final By VALUE_OF_INSTANCE_TYPE_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Instance type:')]");
    private static final By VALUE_OF_REGION_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Region:')]");
    private static final By VALUE_OF_LOCAL_SSD_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Total available')]");
    private static final By VALUE_OF_COMMITMENT_TERM_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Commitment')]");

    @FindBy(xpath = "//md-tab-item/*[@title='Compute Engine']")
    WebElement computerEngineButton;

    @FindBy(id = "input_60")
    WebElement numberOfInstancesInput;

    @FindBy(id = "select_72")
    WebElement operatingSystemDropDownList;

    @FindBy(id = "select_76")
    WebElement machineClassDropDownList;

    @FindBy(id = "select_85")
    WebElement machineTypeDropDownList;

    @FindBy(xpath = "//md-input-container//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGroupCheckBox;

    @FindBy(id = "select_351")
    WebElement numberOfGroupDropDownList;

    @FindBy(xpath = "//md-select[@id='select_353']//span[@class='md-select-icon']")
    WebElement gpuTypeDropDownList;

    @FindBy(xpath = "//md-select[@id='select_184']//span[@class='md-select-icon']")
    WebElement localSsdDropDownList;

    @FindBy(xpath = "//md-select[@id='select_87']//span[@class='md-select-icon']")
    WebElement datacenterLocationDropDownList;

    @FindBy(xpath = "//md-select[@id='select_94']//span[@class='md-select-icon']")
    WebElement commitedUsageDropDownList;

    @FindBy(xpath = "//*[@id='mainForm']/descendant::button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement addToEstimateButton;

    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding']")
    WebElement costFromEstimate;

    @FindBy(id = "email_quote")
    WebElement emailButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@aria-label='Send Email']")
    WebElement sendEmailButton;

    public CalculatorPage open() {
        driver.get("https://cloud.google.com/products/calculator");
        return this;
    }

    public CalculatorPage switchToComputerEngine() {
        waitPresenceOfElementLocated(driver,FRAME);
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        waitElementToBeClickable(driver,computerEngineButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(computerEngineButton).click().build().perform();
        logger.info("Switching to computer engine was successful");
        return this;
    }

    public CalculatorPage setNumberOfInstances() {
        waitPresenceOfElementLocated(driver,COMPUTER_ENGINE_BUTTON);
        numberOfInstancesInput.sendKeys(calculator.getNumberOfInstances());
        logger.info("Setting of number of instances was successful");
        return this;
    }

    public CalculatorPage setOperatingSystem() {
        waitElementToBeClickable(driver, operatingSystemDropDownList);
        executor.executeScript("arguments[0].click()", operatingSystemDropDownList);
        waitElementToBeClickable(driver, VALUE_OF_OPERATING_SYSTEM_BUTTON);
        executor.executeScript("arguments[0].click()", driver.findElement(VALUE_OF_OPERATING_SYSTEM_BUTTON));
        logger.info("Setting of operating system was successful");
        return this;
    }

    public CalculatorPage setMachineClass() {
        waitElementToBeClickable(driver, machineClassDropDownList);
        executor.executeScript("arguments[0].click()", machineClassDropDownList);
        waitElementToBeClickable(driver, VALUE_OF_MACHINE_CLASS_BUTTON);
        executor.executeScript("arguments[0].click()", driver.findElement(VALUE_OF_MACHINE_CLASS_BUTTON));
        logger.info("Setting of machine class was successful");
        return this;
    }

    public CalculatorPage setMachineType() {
        waitElementToBeClickable(driver,machineTypeDropDownList);
        executor.executeScript("arguments[0].click()", machineTypeDropDownList);
        waitElementToBeClickable(driver, VALUE_OF_MACHINE_TYPE_BUTTON);
        executor.executeScript("arguments[0].click()", driver.findElement(VALUE_OF_MACHINE_TYPE_BUTTON));
        logger.info("Setting of machine type was successful");
        return this;
    }

    public CalculatorPage switchOnAddGroup() {
        waitElementToBeClickable(driver, addGroupCheckBox);
        executor.executeScript("arguments[0].click()", addGroupCheckBox);
        return this;
    }

    public CalculatorPage setNumberOfGpus() {
        waitElementToBeClickable(driver, numberOfGroupDropDownList);
        executor.executeScript("arguments[0].click()", numberOfGroupDropDownList);
        waitElementToBeClickable(driver, VALUE_OF_NUMBER_OF_GPUS_BUTTON);
        executor.executeScript("arguments[0].click()", driver.findElement(VALUE_OF_NUMBER_OF_GPUS_BUTTON));
        logger.info("Setting of number of GPUs was successful");
        return this;
    }

    public CalculatorPage setGPUType() {
        waitElementToBeClickable(driver, gpuTypeDropDownList);
        executor.executeScript("arguments[0].click()", gpuTypeDropDownList);
        waitElementToBeClickable(driver,VALUE_OF_GPU_TYPE_BUTTON);
        executor.executeScript("arguments[0].click()", driver.findElement(VALUE_OF_GPU_TYPE_BUTTON));
        logger.info("Setting of GPU type was successful");
        return this;
    }

    public CalculatorPage setLocalSSD() {
        waitElementToBeClickable(driver, localSsdDropDownList);
        executor.executeScript("arguments[0].click()", localSsdDropDownList);
        waitElementToBeClickable(driver, VALUE_OF_LOCAL_SSD_BUTTON);
        executor.executeScript("arguments[0].click()", driver.findElement(VALUE_OF_LOCAL_SSD_BUTTON));
        logger.info("Setting of local SSD was successful");
        return this;
    }

    public CalculatorPage setDatacenterLocation() {
        waitElementToBeClickable(driver, datacenterLocationDropDownList);
        executor.executeScript("arguments[0].click()", datacenterLocationDropDownList);
        waitElementToBeClickable(driver, VALUE_OF_DATACENTER_LOCATION_BUTTON);
        executor.executeScript("arguments[0].click()", driver.findElement(VALUE_OF_DATACENTER_LOCATION_BUTTON));
        logger.info("Setting of datacenter location was successful");
        return this;
    }

    public CalculatorPage setCommitedUsage() {
        waitElementToBeClickable(driver, commitedUsageDropDownList);
        executor.executeScript("arguments[0].click()", commitedUsageDropDownList);
        waitElementToBeClickable(driver, VALUE_OF_DATACENTER_LOCATION_BUTTON);
        executor.executeScript("arguments[0].click()", driver.findElement(VALUE_OF_COMMITTED_USAGE_BUTTON));
        logger.info("Setting of committed usage was successful");
        return this;
    }

    public CalculatorPage clickAddToEstimate() {
        waitElementToBeClickable(driver, addToEstimateButton);
        executor.executeScript("arguments[0].click()", addToEstimateButton);
        logger.info("Estimate was successfully created");
        return this;
    }

    public void switchToEmailPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
    }

    public CalculatorPage clickEmailEstimate() {
        waitElementToBeClickable(driver, emailButton);
        executor.executeScript("arguments[0].click()", emailButton);
        return this;
    }

    public CalculatorPage inputEmail() {
        waitPresenceOfElementLocated(driver, EMAIL_INPUT_BOX);
        emailInput.sendKeys(Keys.LEFT_CONTROL, "v");
        return this;
    }

    public CalculatorPage sendEmail() {
        waitPresenceOfElementLocated(driver, SEND_EMAIL_BUTTON);
        executor.executeScript("arguments[0].click()", sendEmailButton);
        return this;
    }

    public String getCost() {
        waitPresenceOfElementLocated(driver, COST_FROM_ESTIMATE);
        return costFromEstimate.getText();
    }

    public String getValueOfVMMachine() {
        waitPresenceOfElementLocated(driver, VALUE_OF_VM_TYPE_FROM_ESTIMATE);
        return driver.findElement(VALUE_OF_VM_TYPE_FROM_ESTIMATE).getText();
    }

    public String getValueInstanceType() {
        waitPresenceOfElementLocated(driver, VALUE_OF_INSTANCE_TYPE_FROM_ESTIMATE);
        return driver.findElement(VALUE_OF_INSTANCE_TYPE_FROM_ESTIMATE).getText();
    }

    public String getValueRegion() {
        waitPresenceOfElementLocated(driver, VALUE_OF_REGION_FROM_ESTIMATE);
        return driver.findElement(VALUE_OF_REGION_FROM_ESTIMATE).getText();
    }

    public String getValueLocalSSD() {
       waitPresenceOfElementLocated(driver, VALUE_OF_LOCAL_SSD_FROM_ESTIMATE);
        return driver.findElement(VALUE_OF_LOCAL_SSD_FROM_ESTIMATE).getText();
    }

    public String getCommitmentTerm() {
       waitPresenceOfElementLocated(driver, VALUE_OF_COMMITMENT_TERM_FROM_ESTIMATE);
        return driver.findElement(VALUE_OF_COMMITMENT_TERM_FROM_ESTIMATE).getText();
    }
}
