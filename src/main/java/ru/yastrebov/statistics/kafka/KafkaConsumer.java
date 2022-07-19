package ru.yastrebov.statistics.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.yastrebov.agreementStatisticsLib.model.AgreementStatistics;
import ru.yastrebov.statistics.service.impl.StatisticsServiceImpl;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final StatisticsServiceImpl statisticsService;

    @KafkaListener(topics = "agreement_statistics", groupId = "${spring.kafka.consumer.group-id}")

    private void listenGroupRequests(ConsumerRecord<String, AgreementStatistics> message) {

        log.info("Received message: {}", message);

        statisticsService.kafkaMessageHandler(message.value());
    }
}
