package chenqian.site.commontest.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 功能简介:.
 * *
 */
public class SimpleProducer {

    public static void main(String[] arg) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("simple_queue", false, false, false, null);
            String message = "this is new Message";
            //channel.basicPublish("",);
        }
    }
}
