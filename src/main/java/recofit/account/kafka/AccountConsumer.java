package recofit.account.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountConsumer {

//    @KafkaListener(topics = "recofit-test", groupId = "group_id_account")
//    public void consume(String message) throws IOException {
//        log.info("****** kafka consume Start ******");
//        log.info(message);
//    }
//
//    @KafkaListener(topics = "recofit-test", groupId = "group_id_account", containerFactory = "addressListener")
//    public void consume2(Address message) throws IOException {
//        log.info("****** kafka consume2 Start ******");
//        log.info("Address.getZipCode : " + message.getZipCode());
//        log.info("Address.getDetail : " + message.getDetail());
//        log.info("Address.getLatitude : " + message.getLatitude());
//        log.info("Address.getLongitude : " + message.getLongitude());
//        log.info("****** kafka consume2 End ******");
//    }
}
