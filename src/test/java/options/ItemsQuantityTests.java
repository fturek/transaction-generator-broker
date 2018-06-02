package options;

import classes.model.RawParameters;
import classes.utils.OptionsValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ItemsQuantityTests {

    RawParameters rawParameters = new RawParameters();
    OptionsValidator optionsValidator;

    @Before
    public void setup() {

        rawParameters = new RawParameters();
        optionsValidator = new OptionsValidator();
    }

    @Test
    public void testWithWrongItemsQuantityOptions(){

        String args = "20";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertFalse(optionsValidator.checkItemsQuantity());
    }

    @Test
    public void testWithWrongItemsQuantityOptions2(){

        String args = "d";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertFalse(optionsValidator.checkItemsQuantity());
    }
    @Test
    public void testOnlyForItemsQuantityOptions(){

        String args = "10:20";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertTrue(optionsValidator.checkItemsQuantity());
    }

    @Test
    public void testSameRangeItemsQuantityOptions(){

        String args = "10:10";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertTrue(optionsValidator.checkItemsQuantity());
    }

    @Test
    public void testFirstBiggerItemsQuantityOptions(){

        String args = "20:10";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertFalse(optionsValidator.checkItemsQuantity());
    }

    @Test
    public void testFirstOkSecondWrongItemsQuantityOptions(){

        String args = "20:v";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertFalse(optionsValidator.checkItemsQuantity());
    }
    @Test
    public void testFirstWrongSecondOkItemsQuantityOptions(){

        String args = "v:10";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertFalse(optionsValidator.checkItemsQuantity());
    }

    @Test
    public void testCheckItemsQuantity1(){

        String args = "20:b";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertFalse(optionsValidator.checkItemsQuantity());
    }

    @Test
    public void testCheckItemsQuantity2(){

        String args = "b:1";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertFalse(optionsValidator.checkItemsQuantity());
    }

    @Test
    public void testCheckItemsQuantity3(){

        String args = "20:10";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertFalse(optionsValidator.checkItemsQuantity());
    }

    @Test
    public void testCheckItemsQuantity4(){

        String args = "20:20";

        rawParameters.setItemsQuantityFromTo(args);
        optionsValidator.setRawParameters(rawParameters);

        Assert.assertTrue(optionsValidator.checkItemsQuantity());
    }
}
