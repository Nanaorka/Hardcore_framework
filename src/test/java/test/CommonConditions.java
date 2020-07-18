package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.HomePageCloudGoogle;
import util.TestListener;
import driver.DriverSingleton;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeClass()
    public void setUpBrowser() {
        driver = DriverSingleton.getDriver();
        new HomePageCloudGoogle(driver).openHomePage()
                .startSearch()
                .inputSearchEnquiry()
                .pickRightResult()
                .switchToComputerEngine()
                .setNumberOfInstances()
                .setOperatingSystem()
                .setMachineClass()
                .setMachineType()
                .switchOnAddGroup()
                .setNumberOfGpus()
                .setGPUType()
                .setLocalSSD()
                .setDatacenterLocation()
                .setCommitedUsage()
                .clickAddToEstimate();
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        DriverSingleton.closeDriver();
    }
}