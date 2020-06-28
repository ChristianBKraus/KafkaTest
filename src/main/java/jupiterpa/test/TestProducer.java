package jupiterpa.test;

import jupiterpa.model.TestData;
import jupiterpa.util.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TestProducer {

    static Logger logger = LoggerFactory.getLogger(jupiterpa.Application.class);
    @Autowired Producer producer;

    public void run() {
        loadTestData();
    }

    void loadTestData() {

        logger.info("Start");

        ArrayList<TestData> list = new ArrayList<>();
        list.add(new TestData(1,"foo1"));
        list.add(new TestData(2,"foo2"));
        list.add(new TestData(1,"foo3"));
        producer.send("myTopic",list);

        logger.info("Stop");
    }

}
