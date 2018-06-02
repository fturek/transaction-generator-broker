package classes.model;

public class RawParameters {

    private String customerIdsFromTo;
    private String dateRange;
    private String itemsFile;
    private String itemsCountFromTo;
    private String itemsQuantityFromTo;
    private String eventsCount;
    private String outDir;

    public String getCustomerIdsFromTo() {
        return customerIdsFromTo;
    }

    public void setCustomerIdsFromTo(String customerIdsFromTo) {
        this.customerIdsFromTo = customerIdsFromTo;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public String getItemsFile() {
        return itemsFile;
    }

    public void setItemsFile(String itemsFile) {
        this.itemsFile = itemsFile;
    }

    public String getItemsCountFromTo() {
        return itemsCountFromTo;
    }

    public void setItemsCountFromTo(String itemsCountFromTo) {
        this.itemsCountFromTo = itemsCountFromTo;
    }

    public String getItemsQuantityFromTo() {
        return itemsQuantityFromTo;
    }

    public void setItemsQuantityFromTo(String itemsQuantityFromTo) {
        this.itemsQuantityFromTo = itemsQuantityFromTo;
    }

    public String getEventsCount() {
        return eventsCount;
    }

    public void setEventsCount(String eventsCount) {
        this.eventsCount = eventsCount;
    }

    public String getOutDir() {
        return outDir;
    }

    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }
}
