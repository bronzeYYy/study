package cn.chen;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            // 创建session第二个参数为CLIENT_ACKNOWLEDGE时 需要手动调用Message.acknowledge服务端才会删除这个消息
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(session.createQueue("test"));
            for (int i = 0; i < 3; i++) {
                TextMessage textMessage = (TextMessage) consumer.receive();
                System.out.println(textMessage.getText());
            }

            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
