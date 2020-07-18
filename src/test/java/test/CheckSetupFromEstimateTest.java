package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CalculatorPage;
import service.TestDataReader;

import static org.testng.Assert.assertTrue;

public class CheckSetupFromEstimateTest extends CommonConditions {
    @Test
    public void checkCorrectFieldsFilling() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new CalculatorPage(driver).getValueOfVMMachine().contains(TestDataReader.getTestData("testData.valueOfMachineClass").toLowerCase()),
                "value of VM is incorrectly set");
        softAssert.assertTrue(new CalculatorPage(driver).getValueInstanceType().contains(TestDataReader.getTestData("testData.valueOfMachineType")),
                "value of instance type is incorrectly set");
        softAssert.assertTrue(new CalculatorPage(driver).getValueRegion().contains(TestDataReader.getTestData("testData.valueOfDatacenterLocation")),
                "value of region is incorrectly set");
        assertTrue(new CalculatorPage(driver).getValueLocalSSD().contains(TestDataReader.getTestData("testData.valueOfLocalSSD")),
                "value of local SSD is incorrectly set");
        softAssert.assertTrue(new CalculatorPage(driver).getCommitmentTerm().contains(TestDataReader.getTestData("testData.valueOfCommittedUsage")),
                "value of commitment term is incorrectly set");
        softAssert.assertTrue(new CalculatorPage(driver).getCost().contains(TestDataReader.getTestData("testData.cost")),
                "cost from estimate is calculate incorrectly");
        softAssert.assertAll();
    }
}
