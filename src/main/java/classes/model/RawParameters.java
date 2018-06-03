package classes.model;

public class RawParameters {

    private String customerIdsFromTo;
    private String dateRange;
    private String itemsFile;
    private String itemsCountFromTo;
    private String itemsQuantityFromTo;
    private String eventsCount;
    private String outDir;
    private static String broker;
    private static String queue;
    private static String topic;

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

    public static String getBroker() {
        return broker;
    }

    public static void setBroker(String broker) {
        RawParameters.broker = broker;
    }

    public static String getQueue() {
        return queue;
    }

    public static void setQueue(String queue) {
        RawParameters.queue = queue;
    }

    public static String getTopic() {
        return topic;
    }

    public static void setTopic(String topic) {
        RawParameters.topic = topic;
    }
}
