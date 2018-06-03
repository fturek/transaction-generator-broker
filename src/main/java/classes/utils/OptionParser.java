package classes.utils;

import classes.date.DateHelper;
import classes.model.RawParameters;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OptionParser {

    private Options options;
    final Logger logger = LoggerFactory.getLogger(OptionParser.class);
    private String[] arguments;

    private String customerIdsFromTo;
    private String dateRange;
    private String itemsFile;
    private String itemsCountFromTo;
    private String itemsQuantityFromTo;
    private String eventsCount;
    private String outDir;
    private String broker;
    private String queue;
    private String topic;

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    public OptionParser() {
        options = new Options();
    }

    public void prepareOptions() {
        logger.info("Preparing options");
        options.addOption("customerIds", true, "customerIds");
        options.addOption("dateRange", true, "dateRange");
        options.addOption("itemsFile", true, "itemsFile");
        options.addOption("itemsCount", true, "itemsCount");
        options.addOption("itemsQuantity", true, "itemsQuantity");
        options.addOption("eventsCount", true, "eventsCount");
        options.addOption("outDir", true, "outDir");
        options.addOption("broker", true, "broker");
        options.addOption("queue", true, "queue");
        options.addOption("topic", true, "topic");
    }

    public void parseCommandLineArgs() {
        logger.info("Parsing Command line arguments");

        CommandLineParser parser = new BasicParser();
        CommandLine cmd;
        try {

            cmd = parser.parse(options, arguments);
            customerIdsFromTo = ((cmd.getOptionValue("customerIds") != null ? cmd.getOptionValue("customerIds") : "1:20"));
            dateRange = (cmd.getOptionValue("dateRange") != null ? cmd.getOptionValue("dateRange") : DateHelper.prepareDateToday());
            itemsFile = (cmd.getOptionValue("itemsFile") != null ? cmd.getOptionValue("itemsFile") : "src/main/java/items.csv");
            itemsCountFromTo = (cmd.getOptionValue("itemsCount") != null ? cmd.getOptionValue("itemsCount") : "1:5");
            itemsQuantityFromTo = (cmd.getOptionValue("itemsQuantity") != null ? cmd.getOptionValue("itemsQuantity") : "1:5");
            eventsCount = (cmd.getOptionValue("eventsCount") != null ? cmd.getOptionValue("eventsCount") : "1000");
            outDir = (cmd.getOptionValue("outDir") != null ? cmd.getOptionValue("outDir") : "./");
            broker = (cmd.getOptionValue("broker") != null ? cmd.getOptionValue("broker") : null);
            queue = (cmd.getOptionValue("queue") != null ? cmd.getOptionValue("queue") : null);
            topic = (cmd.getOptionValue("topic") != null ? cmd.getOptionValue("topic") : null);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public RawParameters createRawParameters(){
        RawParameters rawParameters = new RawParameters();
        rawParameters.setCustomerIdsFromTo(customerIdsFromTo);
        rawParameters.setDateRange(dateRange);
        rawParameters.setItemsFile(itemsFile);
        rawParameters.setItemsCountFromTo(itemsCountFromTo);
        rawParameters.setItemsQuantityFromTo(itemsQuantityFromTo);
        rawParameters.setEventsCount(eventsCount);
        rawParameters.setOutDir(outDir);
        rawParameters.setBroker(broker);
        rawParameters.setQueue(queue);
        rawParameters.setTopic(topic);
        return rawParameters;
    }

}
