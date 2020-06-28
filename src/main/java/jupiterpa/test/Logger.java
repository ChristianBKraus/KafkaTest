package jupiterpa.test;

import jupiterpa.model.TestData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Logger {
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    void log(String topic, ConsumerRecord<String,TestData> cr) {
        logger.info("{}-{}:{}",topic, cr.key(),cr.value().getName());
    }

    @KafkaListener(topics = "myTopic")
    public void listenMyTopic(ConsumerRecord<String, TestData> cr) {
        log("myTopic",cr);
    }

    @KafkaListener(topics = "myOtherTopic")
    public void listenMyOtherTopic(ConsumerRecord<String,TestData> cr) { log("myOtherTopic",cr); }

}
