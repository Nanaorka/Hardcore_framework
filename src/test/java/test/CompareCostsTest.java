package test;

import org.testng.annotations.Test;
import pages.CalculatorPage;
import pages.PageForGenerateEmail;

import static org.junit.Assert.assertTrue;

public class CompareCostsTest extends CommonConditions {

    @Test
    public void compareCostsTest() {
        String costEstimate = new CalculatorPage(driver).getCost();
        new CalculatorPage(driver).switchToEmailPage();
        new PageForGenerateEmail(driver).copyEmail().switchToCalculator();
        new CalculatorPage(driver).switchToComputerEngine().clickEmailEstimate().inputEmail().sendEmail().switchToEmailPage();
        String costFromEmail = new PageForGenerateEmail(driver).openMail().getCostFromEmail();
        assertTrue(costEstimate.contains(costFromEmail));
    }
}
