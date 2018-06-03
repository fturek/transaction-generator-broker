package classes.utils;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsQueueExample {

    public void sendQueue(String brokerUrl, String queueName, String message) throws URISyntaxException, Exception{

        Connection connection = null;
        try {
            // Producer
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    brokerUrl);
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueName);

            Message msg = session.createTextMessage(message);
            MessageProducer producer = session.createProducer(queue);
            System.out.println("Sending...");
            producer.send(msg);

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}