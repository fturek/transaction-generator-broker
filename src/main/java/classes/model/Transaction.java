package classes.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
public class Transaction {
    public int id;
    public String timestamp;
    public int customer_id;
    public ArrayList<Item> items = new ArrayList<>();
    public double sum;
}
