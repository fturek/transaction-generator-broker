package classes.utils;

import classes.model.Item;
import classes.model.ParsedParameters;
import classes.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class TransactionParser {

    final static Logger logger = LoggerFactory.getLogger(TransactionGenerator.class);

    public static ArrayList<Transaction> createTransaction(ParsedParameters parsedParameters, int id) {

        String itemsCsvFile = parsedParameters.getItemsFile();
        FileReader fileReader = new FileReader();
        ArrayList<Item> items = fileReader.readItems(itemsCsvFile, ",", parsedParameters);

        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        Transaction transaction = new Transaction();
        transaction.id = id;
        transaction.timestamp = parsedParameters.getDateRange();
        transaction.customer_id = Randomizer.getInt(parsedParameters.getCustomerIdFrom(), parsedParameters.getCustomerIdTo());
        transaction.items = items;
        transaction.sum = items.stream().mapToDouble(item -> item.quantity * item.price.doubleValue()).sum();
        transactions.add(transaction);


        return transactions;
    }
}
