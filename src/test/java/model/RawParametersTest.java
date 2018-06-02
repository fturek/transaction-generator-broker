package model;

import classes.model.ParsedParameters;
import classes.model.RawParameters;
import org.junit.Assert;
import org.junit.Test;

public class RawParametersTest {
    @Test
    public void testRawPArs() {
        RawParameters rawParameters = new RawParameters();
        Assert.assertNotNull(rawParameters);
    }
}
