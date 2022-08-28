package recofit.account.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import recofit.account.domain.VO.Address;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class AccountConsumerConfig {
    @Bean
    public ConsumerFactory<String, Address> addressConsumer() {

        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id_account");

        return new DefaultKafkaConsumerFactory<>(
                configs,
                new StringDeserializer(),
                new JsonDeserializer<>(Address.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Address> addressListener() {
        ConcurrentKafkaListenerContainerFactory<String, Address> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(addressConsumer());
        return factory;
    }
}
