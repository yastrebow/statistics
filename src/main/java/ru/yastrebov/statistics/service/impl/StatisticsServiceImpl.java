package ru.yastrebov.statistics.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yastrebov.agreementStatisticsLib.model.AgreementStatistics;
import ru.yastrebov.statistics.mapstruct.AgreementMapping;
import ru.yastrebov.statistics.mapstruct.StatisticsMapper;
import ru.yastrebov.statistics.model.Statistics;
import ru.yastrebov.statistics.model.StatisticsDTO;
import ru.yastrebov.statistics.repository.StatisticsRepository;
import ru.yastrebov.statistics.service.StatisticsService;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository statisticsRepository;
    private final StatisticsMapper statisticsMapper;
    private final AgreementMapping agreementMapping;

    @Override
    public StatisticsDTO postStatistics(Statistics messageForPosting) {

        Statistics savedStatistics = statisticsRepository.save(messageForPosting);
        log.info("Entity \"{}\" successfully saved!", savedStatistics);

        return statisticsMapper.entityToDto(savedStatistics);
    }

    public void kafkaMessageHandler(AgreementStatistics agreementsStatistics) {

        Statistics messageForPosting = agreementMapping.agreementToStatistics(agreementsStatistics);

        postStatistics(messageForPosting);
    }
}
