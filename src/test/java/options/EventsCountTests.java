package options;

import classes.model.RawParameters;
import classes.utils.OptionsValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class EventsCountTests {

    RawParameters rawParameters = new RawParameters();
    OptionsValidator optionsValidator;

    @Before
    public void setup() {

        rawParameters = new RawParameters();
        optionsValidator = new OptionsValidator();
    }


    @Test
    public void testOkEventCountOptions() {

        String args = "10";

        rawParameters.setEventsCount(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkEventsCount());
    }

    @Test
    public void testWrongOptions1() {
        String args = "d";

        rawParameters.setEventsCount(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkEventsCount());
    }

    @Test
    public void testWrongOptions2() {

        String args = "20:10";

        rawParameters.setEventsCount(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkEventsCount());
    }

}