package options;

import classes.model.RawParameters;
import classes.utils.OptionsValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ItemsCountTests {

    RawParameters rawParameters = new RawParameters();
    OptionsValidator optionsValidator;

    @Before
    public void setup() {

        rawParameters = new RawParameters();
        optionsValidator = new OptionsValidator();
    }

    @Test
    public void testWithWrongItemsCountOptions() {

        String args = "10";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkItemsCount());
    }

    @Test
    public void testWithWrongItemsCountOptions2() {

        String args = "d";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkItemsCount());
    }

    @Test
    public void testOnlyForItemsCountOptions() {

        String args = "10:20";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkItemsCount());
    }

    @Test
    public void testSameRangeItemsCountOptions() {

        String args = "0:10";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkItemsCount());
    }

    @Test
    public void testFirstBiggerItemsCountOptions() {

        String args = "20:10";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkItemsCount());
    }

    @Test
    public void testFirstOkSecondWrongItemsCountOptions() {

        String args = "20:a";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkItemsCount());
    }

    @Test
    public void testFirstWrongSecondOkItemsCountOptions() {

        String args = "20:b";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkItemsCount());
    }

    @Test
    public void testCheckItemsCount1() {

        String args = "20:b";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkItemsCount());
    }

    @Test
    public void testCheckItemsCount2() {

        String args = "b:1";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkItemsCount());
    }

    @Test
    public void testCheckItemsCount3() {

        String args = "20:10";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkItemsCount());
    }

    @Test
    public void testCheckItemsCount4() {

        String args = "20:20";

        rawParameters.setItemsCountFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkItemsCount());
    }
}
