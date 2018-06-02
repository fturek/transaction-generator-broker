package classes.saver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import classes.model.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import classes.saver.condidtions.JSONSaverCondition;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Service
@Qualifier
@Conditional(JSONSaverCondition.class)
public class JsonSaver implements Saver {

    @Override
    public void saveToFile(ArrayList<Transaction> transactions, File file) throws JAXBException, FileNotFoundException, UnsupportedEncodingException {

        String result = "";

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        Gson gson = builder.create();
        result = gson.toJson(transactions);
        PrintWriter out = new PrintWriter(file, "UTF-8");
        out.println(result);
        out.close();
    }

    @Override
    public String getExtension() {
        return "json";
    }
}
