package common.request;

public enum MaintenanceType {
    INBOUND("inbound"),
    OUTBOUND("outbound");

    private final String value;

    MaintenanceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}