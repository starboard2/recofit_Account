package recofit.account.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import recofit.account.domain.VO.Address;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountProducer {
    private final KafkaTemplate<String, Address> kafkaTemplate;

    public void sendMessage(String topic, Address payload) {
        log.info("****** kafka SendMessage ****** >>>>>>>   Payload='{}', Topic='{}'", payload, topic);
        ListenableFuture<SendResult<String, Address>> listenableFuture = kafkaTemplate.send(topic, payload);
        log.info("****** kafka SendMessage Complete ******");
    }

}
