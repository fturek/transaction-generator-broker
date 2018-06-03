package classes.utils;

import classes.model.ParsedParameters;
import classes.model.RawParameters;
import classes.model.Transaction;
import classes.saver.Saver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class TransactionGenerator {

    final static Logger logger = LoggerFactory.getLogger(TransactionGenerator.class);

    private OptionParser optionParser;
    private OptionsValidator optionsValidator;

    RawParameters rawParameters;
    ParsedParameters parsedParameters;
    Saver saver;

    public TransactionGenerator(OptionParser optionParser, Saver saver, OptionsValidator optionsValidator) {
        this.optionParser = optionParser;
        this.saver = saver;
        this.optionsValidator = optionsValidator;
    }

    public boolean generate(String[] args) {
        logger.info("Generate.");
        optionParser.setArguments(args);
        optionParser.prepareOptions();
        optionParser.parseCommandLineArgs();
        rawParameters = optionParser.createRawParameters();

        optionsValidator.setRawParameters(rawParameters);
        boolean optionsOk = optionsValidator.validateOptions();
        if (!optionsOk) {
            logger.warn("Transaction generator failed.");
            return false;
        }
        parsedParameters = optionsValidator.getParsedParameters();

        try {
            int howMany = Integer.parseInt(parsedParameters.getEventsCount());

            File dir = new File(parsedParameters.getOutDir());
            if (!dir.exists()) {
                dir.mkdir();
            }

            for (int i = 0; i < howMany; i++) {
                ArrayList<Transaction> transactions = TransactionParser.createTransaction(parsedParameters, i);
                saver.saveToFile(transactions, new File(parsedParameters.getOutDir() + "/output" + i + "." + saver.getExtension()));

                if (parsedParameters.getBroker() != null) {
                    try {
                        String brokerUrl = parsedParameters.getBroker();
                        ObjectMapper objectMapper = new ObjectMapper();
                        String message = objectMapper.writeValueAsString(transactions);

                        if (parsedParameters.getQueue() != null) {
                            JmsQueueExample jmsQueueExample = new JmsQueueExample();
                            String gueueName = parsedParameters.getQueue();
                            jmsQueueExample.sendQueue(brokerUrl, gueueName, message);
                        }

                        if (parsedParameters.getTopic() != null) {
                            JmsTopicExample jmsTopicExample = new JmsTopicExample();
                            String topicName = parsedParameters.getTopic();

                            jmsTopicExample.sendTopic(brokerUrl, topicName, message);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return true;
    }
}
