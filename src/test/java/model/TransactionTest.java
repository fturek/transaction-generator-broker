package model;

import classes.model.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {
    @Test
    public void testTransaction() {
        Transaction transaction = new Transaction();
        Assert.assertNotNull(transaction);
    }
}
