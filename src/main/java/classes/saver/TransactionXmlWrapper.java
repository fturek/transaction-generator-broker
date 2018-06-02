package classes.saver;
import classes.model.Transaction;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "transactions")
public class TransactionXmlWrapper {

    @XmlElement(name = "transaction", type = Transaction.class)
    private List<Transaction> transactions;

    public TransactionXmlWrapper() {
    }

    public TransactionXmlWrapper(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
