package options;

import classes.model.RawParameters;
import classes.utils.OptionsValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ItemsFileTests {

    RawParameters rawParameters = new RawParameters();
    OptionsValidator optionsValidator;

    @Before
    public void setup() {

        rawParameters = new RawParameters();
        optionsValidator = new OptionsValidator();
    }


    @Test
    public void testWithWrongItemsFile(){

        String args = "noName.csv ";

        rawParameters.setItemsFile(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertFalse(optionsValidator.checkInputFile());
    }

    @Test
    public void testOnlyForItemstFileOptions(){

        String args = "items.csv";

        rawParameters.setItemsFile(args);
        optionsValidator.setRawParameters(rawParameters);
        Assert.assertTrue(optionsValidator.checkInputFile());
    }
}
