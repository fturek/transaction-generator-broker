package options;

import classes.model.RawParameters;
import classes.saver.JsonSaver;
import classes.saver.Saver;
import classes.utils.OptionParser;
import classes.utils.OptionsValidator;
import classes.utils.TransactionGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AllOptionsTest {

    OptionParser optionParser;

    Saver saver;

    OptionsValidator optionsValidator;

    @Test
    public void testCorrectOptions() {
        String args = "-customerIds 1:20 " +
                "-dateRange 2018-03-08T00:00:00.000-0100:2018-03-08T23:59:59.999-0100 " +
                "-itemsFile items.csv " +
                "-itemsCount 5:15 " +
                "-itemsQuantity 1:30 " +
                "-eventsCount 10 " +
                "-outDir ./output";

        String[] options = args.split(" ");

        optionParser = new OptionParser();
        saver = new JsonSaver();
        optionsValidator = new OptionsValidator();

        TransactionGenerator transactionGenerator = new TransactionGenerator(optionParser, saver, optionsValidator);
        Assert.assertTrue(transactionGenerator.generate(options));
    }

    @Test
    public void testMockOptionFailed() {
        String args = "";

        String[] options = args.split(" ");

        optionParser = new OptionParser();
        saver = new JsonSaver();
        optionsValidator = Mockito.mock(OptionsValidator.class);

        Mockito.when(optionsValidator.validateOptions()).thenReturn(Boolean.FALSE);
        TransactionGenerator transactionGenerator = new TransactionGenerator(optionParser, saver, optionsValidator);
        Assert.assertFalse(transactionGenerator.generate(options));
    }

    @Test
    public void testBadOptions() {

        optionsValidator = new OptionsValidator();
        RawParameters rawParameters = new RawParameters();
        String args = "bad parameters";

        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.validateOptions());
    }
}
