package jupiterpa.test;

import jupiterpa.model.TestData;
import jupiterpa.util.TransformUtil;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.serializer.JsonSerde;

@Configuration
public class TestTransform {

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamsConfigs() {
        return TransformUtil.defaultConfig("testStreams", new JsonSerde<>(TestData.class));
    }

    @Bean
    public KStream<String, TestData> kStream(StreamsBuilder kStreamBuilder) {

        KStream<String,TestData> stream = kStreamBuilder.stream("myTopic");

        stream
                .mapValues( v -> v )
                .peek( (k,v) -> System.out.println("Transform: " + v.getName()) )
                .to("myOtherTopic");

//        stream.print(Printed.toSysOut());

        return stream;
    }
    }
