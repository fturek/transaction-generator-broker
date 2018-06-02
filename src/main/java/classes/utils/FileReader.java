package classes.utils;

import classes.model.Item;
import classes.model.ParsedParameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FileReader {

    public ArrayList<Item> readItems(String csvFile, String sep, ParsedParameters parsedParameters) {

        String separator = sep;
        String singleItem;
        ArrayList<Item> items = new ArrayList<>();

        try {
            List<String> itemsFile = Files.readAllLines(new File(csvFile).toPath());
            int countItems = Randomizer.getInt(parsedParameters.getItemsCountFrom(), parsedParameters.getItemsCountTo());
            for (int i = 0; i < countItems; i++) {
                singleItem = itemsFile.get(ThreadLocalRandom.current().nextInt(0,itemsFile.size()));
                String[] itemValues = singleItem.split(separator);
                Item item = new Item();
                item.name = itemValues[0].replaceAll("\"", "");
                item.quantity = Randomizer.getInt(parsedParameters.getItemsQuantityFrom(), parsedParameters.getItemsQuantityTo());
                item.price = Float.parseFloat(itemValues[1]);
                items.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }


}
