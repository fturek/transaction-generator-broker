package classes.utils;

import classes.date.DateHelper;
import classes.model.ParsedParameters;
import classes.model.RawParameters;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OptionsValidator {

    final static Logger logger = LoggerFactory.getLogger(OptionsValidator.class);

    private ParsedParameters parsedParameters;
    private RawParameters rawParameters;

    public OptionsValidator() {

        parsedParameters = new ParsedParameters();
    }

    public void setRawParameters(RawParameters rawParameters) {
        this.rawParameters = rawParameters;
    }

    public boolean checkCustomerIds() {
        String[] customerIdsFromTo;
        if (!rawParameters.getCustomerIdsFromTo().contains(":")) {
            logger.warn("CustomerIDs failed");
            return false;

        } else {
            customerIdsFromTo = rawParameters.getCustomerIdsFromTo().split(":");
            if (!StringUtils.isNumeric(customerIdsFromTo[0]) ||
                    !StringUtils.isNumeric(customerIdsFromTo[1]) ||
                    Integer.parseInt(customerIdsFromTo[0]) > Integer.parseInt(customerIdsFromTo[1])) {
                logger.warn("CustomerIDs failed");
                return false;
            }
        }
        logger.info("CustomerIDs checked!");
        parsedParameters.setCustomerIdFrom(customerIdsFromTo[0]);
        parsedParameters.setCustomerIdTo(customerIdsFromTo[1]);
        return true;

    }

    public boolean checkDateRange() {
        if (rawParameters.getDateRange().length() != 57 || rawParameters.getDateRange().charAt(28) != ':') {
            logger.warn("DataRange is in bad format.");
            return false;
        }
        parsedParameters.setDateRange(DateHelper.transformDate(rawParameters.getDateRange()));
        logger.info("DateRange checked!");
        return true;
    }

    public boolean checkEventsCount() {
        if (!StringUtils.isNumeric(rawParameters.getEventsCount())) {
            logger.warn("EventsCount failed");
            return false;
        }
        logger.info("EventsCount checked");
        parsedParameters.setEventsCount(rawParameters.getEventsCount());
        return true;

    }

    public boolean checkItemsQuantity() {
        String[] itemsQuantityFromTo;
        if (!rawParameters.getItemsQuantityFromTo().contains(":")) {
            logger.warn("ItemsQuantity failed");
            return false;
        } else {
            itemsQuantityFromTo = rawParameters.getItemsQuantityFromTo().split(":");
            if (!StringUtils.isNumeric(itemsQuantityFromTo[1]) || !StringUtils.isNumeric(itemsQuantityFromTo[0]) || Integer.parseInt(itemsQuantityFromTo[0]) > Integer.parseInt(itemsQuantityFromTo[1])) {
                logger.warn("ItemsQuantity failed");
                return false;

            }
        }
        logger.info("ItemsQuantity checked");
        parsedParameters.setItemsQuantityFrom(itemsQuantityFromTo[0]);
        parsedParameters.setItemsQuantityTo(itemsQuantityFromTo[1]);
        return true;

    }

    public boolean checkItemsCount() {
        String[] itemsCountFromTo;
        if (!rawParameters.getItemsCountFromTo().contains(":")) {
            logger.warn("ItemsCount failed");
            return false;
        } else {
            itemsCountFromTo = rawParameters.getItemsCountFromTo().split(":");
            if (!StringUtils.isNumeric(itemsCountFromTo[1]) || !StringUtils.isNumeric(itemsCountFromTo[0]) || Integer.parseInt(itemsCountFromTo[0]) > Integer.parseInt(itemsCountFromTo[1])) {
                logger.warn("ItemsCount failed");
                return false;

            }
        }
        logger.info("ItemsCount checked");
        parsedParameters.setItemsCountFrom(itemsCountFromTo[0]);
        parsedParameters.setItemsCountTo(itemsCountFromTo[1]);
        return true;

    }

    public boolean checkInputFile() {
        File file = new File(rawParameters.getItemsFile());
        if (!file.exists()) {
            logger.warn("InputFile failed");
            return false;
        }
        logger.info("InputFile checked");
        parsedParameters.setItemsFile(rawParameters.getItemsFile());
        return true;

    }

    public boolean checkOutDir() {

        parsedParameters.setOutDir(rawParameters.getOutDir());
        return true;
    }

    public boolean validateOptions() {
        if (checkCustomerIds() && checkEventsCount() && checkOutDir() && checkDateRange() &&
                checkItemsQuantity() && checkItemsCount() && checkInputFile()) {

            logger.info("All Checked completed!");
            return true;
        }

        logger.warn("Check failed.");
        return false;
    }


    public ParsedParameters getParsedParameters() {
        return parsedParameters;
    }
}
