package options;

import classes.model.RawParameters;
import classes.utils.OptionsValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class DataRangeTests {

    RawParameters rawParameters = new RawParameters();
    OptionsValidator optionsValidator;

    @Before
    public void setup() {

        rawParameters = new RawParameters();
        optionsValidator = new OptionsValidator();
    }


    @Test
    public void testWithWrongDateRangeOptions() {

        String args = "2018-03-08T20:59:59.999-010:2018-03-08T20:59:59";

        rawParameters.setDateRange(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkDateRange());
    }


    @Test
    public void testOnlyForDateRange() {

        String args = "2018-03-08T00:00:00.000-0100:2018-03-08T23:59:59.999-0100";

        rawParameters.setDateRange(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkDateRange());
    }

    @Test
    public void testSameRangeDateRange() {

        String args = "2018-03-08T20:59:59.999-0100:2018-03-08T20:59:59.999-0100";

        rawParameters.setDateRange(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkDateRange());
    }


}
