package test;

import org.testng.annotations.Test;
import pages.CalculatorPage;
import pages.PageForGenerateEmail;

import static org.testng.Assert.assertTrue;

public class CompareCostsTest extends CommonConditions {

    @Test
    public void compareCostsTest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        String costEstimate = new CalculatorPage(driver).getCost();
        calculatorPage.switchToEmailPage();
        new PageForGenerateEmail(driver).copyEmail().switchToCalculator();
        calculatorPage.switchToComputerEngine().clickEmailEstimate().inputEmail().sendEmail().switchToEmailPage();
        String costFromEmail = new PageForGenerateEmail(driver).openMail().getCostFromEmail();
        assertTrue(costEstimate.contains(costFromEmail), "Cost from mail isn't equal with cost from estimate");
    }
}
