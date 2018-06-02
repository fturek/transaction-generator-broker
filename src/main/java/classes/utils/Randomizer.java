package classes.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static int getInt(String rangeFrom, String rangeTo){
        int from = Integer.parseInt(rangeFrom);
        int to = Integer.parseInt(rangeTo);
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }
}
