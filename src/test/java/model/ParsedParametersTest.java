package model;

import classes.model.ParsedParameters;
import org.junit.Assert;
import org.junit.Test;

public class ParsedParametersTest {
    @Test
    public void testParsedPArs() {
        ParsedParameters parsedParameters = new ParsedParameters();
        Assert.assertNotNull(parsedParameters);
    }
}
