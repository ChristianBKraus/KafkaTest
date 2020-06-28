package jupiterpa.util;

import jupiterpa.model.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producer {
    public static Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired KafkaTemplate<String, TestData> template;

    void sendData(String topic, TestData data) {
        this.template.send(topic,data.getKey(), data);
    }

    public void send(String topic, List<TestData> data) {
        logger.info("Sending to {}", topic);
        data.forEach( item -> sendData(topic,item));
        logger.info("{} messages sent to {}", data.size(), topic);
    }

}

