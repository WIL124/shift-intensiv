package common.request;

public enum HistoryRequestType {
    TRANSFER("transfer"),
    PAYMENT("payment"),
    REFILL("refill");

    private final String value;

    HistoryRequestType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
