package classes.model;

public class ParsedParameters {

    private static String customerIdFrom;
    private static String customerIdTo;

    private static String dateRange;

    private static String itemsFile;

    private static String itemsCountFrom;
    private static String itemsCountTo;

    private static String itemsQuantityFrom;
    private static String itemsQuantityTo;

    private static String eventsCount;
    private static String outDir;

    public static String getCustomerIdFrom() {
        return customerIdFrom;
    }

    public static void setCustomerIdFrom(String customerIdFrom) {
        ParsedParameters.customerIdFrom = customerIdFrom;
    }

    public static String getCustomerIdTo() {
        return customerIdTo;
    }

    public static void setCustomerIdTo(String customerIdTo) {
        ParsedParameters.customerIdTo = customerIdTo;
    }

    public static String getDateRange() {
        return dateRange;
    }

    public static void setDateRange(String dateRange) {
        ParsedParameters.dateRange = dateRange;
    }

    public static String getItemsCountFrom() {
        return itemsCountFrom;
    }

    public static void setItemsCountFrom(String itemsCountFrom) {
        ParsedParameters.itemsCountFrom = itemsCountFrom;
    }

    public static String getItemsCountTo() {
        return itemsCountTo;
    }

    public static void setItemsCountTo(String itemsCountTo) {
        ParsedParameters.itemsCountTo = itemsCountTo;
    }

    public static String getItemsQuantityFrom() {
        return itemsQuantityFrom;
    }

    public static void setItemsQuantityFrom(String itemsQuantityFrom) {
        ParsedParameters.itemsQuantityFrom = itemsQuantityFrom;
    }

    public static String getItemsQuantityTo() {
        return itemsQuantityTo;
    }

    public static void setItemsQuantityTo(String itemsQuantityTo) {
        ParsedParameters.itemsQuantityTo = itemsQuantityTo;
    }

    public static String getEventsCount() {
        return eventsCount;
    }

    public static void setEventsCount(String eventsCount) {
        ParsedParameters.eventsCount = eventsCount;
    }

    public static String getOutDir() {
        return outDir;
    }

    public static void setOutDir(String outDir) {
        ParsedParameters.outDir = outDir;
    }

    public static String getItemsFile() {
        return itemsFile;
    }

    public static void setItemsFile(String itemsFile) {
        ParsedParameters.itemsFile = itemsFile;
    }
}
