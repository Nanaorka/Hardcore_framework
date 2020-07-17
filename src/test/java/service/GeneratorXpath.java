package service;

import models.Calculator;

public class GeneratorXpath {
    private Calculator calculator = CalculatorCreator.withCredentialsFromProperty();

    public String getXpathForOperatingSystemValue() {
        return "//md-option/div[text()[contains(.,'" + calculator.getOperatingSystem() + "')]]";
    }

    public String getXpathForMachineClass() {
        return "//div[@class='md-select-menu-container md-active md-clickable']//div[text()='"
                + calculator.getMachineClass() + "']";
    }

    public String getXpathForMachineType() {
        return "//md-option//div[text()[contains(.,'" + calculator.getMachineType() + "')]]";
    }

    public String getXpathForNumberOfGpus() {
        return "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='"
                + calculator.getNumberOfGpus() + "']";
    }

    public String getXpathForGpuType() {
        return "//md-option//div[text()[contains(.,'" + calculator.getGpuType() + "')]]";
    }

    public String getXpathForLocalSSD() {
        return "//md-option//div[text()[contains(.,'" + calculator.getLocalSSD() + "')]]";
    }

    public String getXpathForDatacenterLocation() {
        return "//div[@id='select_container_88']//div[text()[contains(.,'" + calculator.getDatacenterLocation() + "')]]";
    }

    public String getXpathForCommitedUsage() {
        return "//div[@id='select_container_95']//div[text()[contains(.,'" + calculator.getCommittedUsage() + "')]]";
    }
}
