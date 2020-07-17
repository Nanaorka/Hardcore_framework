package models;

public class Calculator {
    private String numberOfInstances;
    private String operatingSystem;
    private String machineClass;
    private String machineType;
    private String numberOfGpus;
    private String gpuType;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public Calculator(String numberOfInstances, String operatingSystem, String machineClass, String machineType,
                      String numberOfGpus, String gpuType, String localSSD, String datacenterLocation,
                      String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.numberOfGpus = numberOfGpus;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getNumberOfGpus() {
        return numberOfGpus;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "numberOfInstances=" + numberOfInstances +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGpus='" + numberOfGpus + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calculator that = (Calculator) o;

        if (numberOfInstances != null ? !numberOfInstances.equals(that.numberOfInstances) : that.numberOfInstances != null)
            return false;
        if (operatingSystem != null ? !operatingSystem.equals(that.operatingSystem) : that.operatingSystem != null)
            return false;
        if (machineClass != null ? !machineClass.equals(that.machineClass) : that.machineClass != null) return false;
        if (machineType != null ? !machineType.equals(that.machineType) : that.machineType != null) return false;
        if (numberOfGpus != null ? !numberOfGpus.equals(that.numberOfGpus) : that.numberOfGpus != null) return false;
        if (gpuType != null ? !gpuType.equals(that.gpuType) : that.gpuType != null) return false;
        if (localSSD != null ? !localSSD.equals(that.localSSD) : that.localSSD != null) return false;
        if (datacenterLocation != null ? !datacenterLocation.equals(that.datacenterLocation) : that.datacenterLocation != null)
            return false;
        return committedUsage != null ? committedUsage.equals(that.committedUsage) : that.committedUsage == null;
    }

    @Override
    public int hashCode() {
        int result = numberOfInstances != null ? numberOfInstances.hashCode() : 0;
        result = 31 * result + (operatingSystem != null ? operatingSystem.hashCode() : 0);
        result = 31 * result + (machineClass != null ? machineClass.hashCode() : 0);
        result = 31 * result + (machineType != null ? machineType.hashCode() : 0);
        result = 31 * result + (numberOfGpus != null ? numberOfGpus.hashCode() : 0);
        result = 31 * result + (gpuType != null ? gpuType.hashCode() : 0);
        result = 31 * result + (localSSD != null ? localSSD.hashCode() : 0);
        result = 31 * result + (datacenterLocation != null ? datacenterLocation.hashCode() : 0);
        result = 31 * result + (committedUsage != null ? committedUsage.hashCode() : 0);
        return result;
    }
}
