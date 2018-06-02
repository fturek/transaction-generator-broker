package options;

import classes.model.RawParameters;
import classes.utils.OptionsValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class CustomerIdsTests {

    RawParameters rawParameters = new RawParameters();
    OptionsValidator optionsValidator;

    @Before
    public void setup() {

        rawParameters = new RawParameters();
        optionsValidator = new OptionsValidator();
    }

    @Test
    public void testWithWrongCustomerIdsOptions() {

        String args = "10";

        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkCustomerIds());
    }


    @Test
    public void testOnlyForCustomerIdsOptions() {

        String args = "10:20";

        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkCustomerIds());
    }

    @Test
    public void testSameRangeCustomerIdsOptions() {

        String args = "10:10";
        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkCustomerIds());
    }

    @Test
    public void testFirstBiggerCustomerIdsOptions() {

        String args = "20:10";

        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkCustomerIds());
    }

    @Test
    public void testFirstOkSecondWrongCustomerIdsOptions() {

        String args = "20:a";

        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkCustomerIds());
    }

    @Test
    public void testFirstWrongSecondokCustomerIdsOptions() {

        String args = "a:10";


        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkCustomerIds());
    }

    @Test
    public void testCheckCustomerIds1() {

        String args = "a:10";

        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkCustomerIds());
    }

    @Test
    public void testCheckCustomerIds2() {

        String args = "20:10";

        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkCustomerIds());
    }

    @Test
    public void testCheckCustomerIds3() {

        String args = "20:a";

        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkCustomerIds());
    }

    @Test
    public void testCheckCustomerIds4() {

        String args = "20:20";

        rawParameters.setCustomerIdsFromTo(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkCustomerIds());
    }

}
