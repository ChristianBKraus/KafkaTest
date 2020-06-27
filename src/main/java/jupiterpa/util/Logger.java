package jupiterpa.util;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Logger {
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    @KafkaListener(topics = "myTopic")
    public void listenMyTopic(ConsumerRecord<?, ?> cr) {
        log("myTopic",cr);
    }

    @KafkaListener(topics = "myOtherTopic")
    public void listenMyOtherTopic(ConsumerRecord<?, ?> cr) {
        log("myOtherTopic",cr);
    }

    void log(String topic, ConsumerRecord<?, ?> cr) {
        logger.info("{}-{}:{}",topic, cr.key(),cr.value());
    }
}
