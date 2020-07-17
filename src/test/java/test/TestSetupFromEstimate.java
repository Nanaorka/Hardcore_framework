package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CalculatorPage;

import static org.testng.Assert.assertTrue;

public class TestSetupFromEstimate extends CommonConditions {
    @Test
    public void checkCorrectFieldsFilling() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new CalculatorPage(driver).getValueOfVMMachine().contains("regular"), "value of VM is incorrectly set");
        softAssert.assertTrue(new CalculatorPage(driver).getValueInstanceType().contains("n1-standard-8"),
                "value of instance type is incorrectly set");
        softAssert.assertTrue(new CalculatorPage(driver).getValueRegion().contains("Frankfurt"),
                "value of region is incorrectly set");
        assertTrue(new CalculatorPage(driver).getValueLocalSSD().contains("2x375"),
                "value of local SSD is incorrectly set");
        softAssert.assertTrue(new CalculatorPage(driver).getCommitmentTerm().contains("1 Year"),
                "value of commitment term is incorrectly set");
        softAssert.assertTrue(new CalculatorPage(driver).getCost().contains("1,082.77"),
                "cost from estimate is calculate incorrectly");
        softAssert.assertAll();
    }
}
