package ru.yastrebov.statistics.service;

import ru.yastrebov.statistics.model.Statistics;
import ru.yastrebov.statistics.model.StatisticsDTO;

public interface StatisticsService {

    StatisticsDTO postStatistics(Statistics messageForPosting);

}
