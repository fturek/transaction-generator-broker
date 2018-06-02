package classes.saver;

import classes.model.Transaction;
import classes.saver.condidtions.XMLSaverCondition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Service("xml")
@Qualifier("xml")
@Conditional(XMLSaverCondition.class)
public class XMLSaver implements Saver {

    @Override
    public void saveToFile(ArrayList<Transaction> transactions, File file) throws JAXBException, FileNotFoundException, UnsupportedEncodingException {

        TransactionXmlWrapper xmlTransactionWrapper = new TransactionXmlWrapper(transactions);
        JAXBContext jaxbContext = JAXBContext.newInstance(TransactionXmlWrapper.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(xmlTransactionWrapper, new PrintWriter(file, "UTF-8"));
    }

    @Override
    public String getExtension() {
        return "xml";
    }


}
