package classes.utils;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.net.URI;
import java.net.URISyntaxException;

public class JmsTopicExample {

    public void sendTopic(String brokerUrl, String topicName, String message) throws URISyntaxException, Exception {

        Connection connection = null;
        try {
            // Producer
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    brokerUrl);
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(topicName);

            connection.start();

            // Publish
            Message msg = session.createTextMessage(message);
            MessageProducer producer = session.createProducer(topic);
            System.out.println("Sending...");
            producer.send(msg);

            Thread.sleep(3000);
            session.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}