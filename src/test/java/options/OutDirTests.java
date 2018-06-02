package options;

import classes.model.RawParameters;
import classes.utils.OptionsValidator;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.Assert;
import org.junit.Test;

public class OutDirTests {

    RawParameters rawParameters = new RawParameters();
    OptionsValidator optionsValidator;

    @Before
    public void setup() {

        rawParameters = new RawParameters();
        optionsValidator = new OptionsValidator();
    }

    @Test
    public void testOkOutputDirOptions(){

        String args = "-outDir ./output";

        rawParameters.setOutDir(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkOutDir());
    }

}
