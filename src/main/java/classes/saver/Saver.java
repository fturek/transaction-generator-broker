package classes.saver;

import classes.model.Transaction;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public interface Saver {
    void saveToFile(ArrayList<Transaction> transactions, File file) throws JAXBException, FileNotFoundException, UnsupportedEncodingException;
    String getExtension();
}
