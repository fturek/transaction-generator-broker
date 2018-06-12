package classes.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.math.BigDecimal;

@Immutable
public class Item {
    public String name;
    public int quantity;
    public BigDecimal price;
}
