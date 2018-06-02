package model;

import classes.model.Item;
import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void testItem() {
        Item item = new Item();
        Assert.assertNotNull(item);
    }
}
