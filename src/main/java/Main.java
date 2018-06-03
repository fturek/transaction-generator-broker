import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import classes.utils.TransactionGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(TransactionGenerator.class);

    public static void main(String[] args) {

        String[] CLIArgs = args;
        if (args.length == 1 && args[0].equals("docker")) {
            try {
                Properties properties = new Properties();
                InputStream inputStream = new FileInputStream("/storage/generator.properties");
                properties.load(inputStream);
                CLIArgs = new String[]{
                        "-customerIds",
                        properties.getProperty("customerIds"),
                        "-dateRange",
                        properties.getProperty("dateRange").replace("\"", ""),
                        "-itemsFile",
                        "." + properties.getProperty("itemsFile"),
                        "-itemsCount",
                        properties.getProperty("itemsCount"),
                        "-itemsQuantity",
                        properties.getProperty("itemsQuantity"),
                        "-eventsCount",
                        properties.getProperty("eventsCount"),
                        "-outDir",
                        "." + properties.getProperty("outDir"),
                        "--format=" + properties.getProperty("format"),
                        "-broker" + properties.getProperty("broker"),
                        "-queue" + properties.getProperty("queue"),
                        "-topic" + properties.getProperty("topic"),
                };

                System.out.println();
            } catch (IOException e) {
            }
        }
        AnnotationConfigApplicationContext ctx = configurate(CLIArgs);

        String[] commonsCliArgs = Arrays.stream(CLIArgs).filter(s -> !s.contains("--format")).toArray(String[]::new);

        TransactionGenerator transactionGenerator = (TransactionGenerator) ctx.getBean("transactionGenerator");

        if (transactionGenerator.generate(commonsCliArgs)) {
            logger.info("...::Done::...");
        } else {
            logger.warn("Transaction generator failed.");
        }

    }

    private static AnnotationConfigApplicationContext configurate(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        PropertySource theSource = new SimpleCommandLinePropertySource(args);
        ctx.getEnvironment().getPropertySources().addFirst(theSource);
        ctx.scan("classes");
        ctx.refresh();
        return ctx;
    }

}
