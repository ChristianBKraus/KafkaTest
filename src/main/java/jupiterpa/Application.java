package jupiterpa;

import jupiterpa.test.TestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(jupiterpa.Application.class, args).close();
    }

    @Autowired TestProducer testProducer;

    @Override
    public void run(String... args) throws Exception {
        testProducer.run();
        Thread.sleep(1000);
    }
}
