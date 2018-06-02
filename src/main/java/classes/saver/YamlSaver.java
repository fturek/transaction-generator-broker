package classes.saver;

import classes.model.Transaction;
import classes.saver.condidtions.YAMLSaverCondition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Service("yaml")
@Qualifier("yaml")
@Conditional(YAMLSaverCondition.class)
public class YamlSaver implements Saver {

    @Override
    public void saveToFile(ArrayList<Transaction> transactions, File file) throws JAXBException, FileNotFoundException, UnsupportedEncodingException {
        Representer representer = new Representer();
        representer.addClassTag(Transaction.class, new Tag("!transaction"));
        Yaml yaml = new Yaml(representer, new DumperOptions());
        yaml.dump(transactions, new PrintWriter(file, "UTF-8"));
    }

    @Override
    public String getExtension() {
        return "yaml";
    }
}
