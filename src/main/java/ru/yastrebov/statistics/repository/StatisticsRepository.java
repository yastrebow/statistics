package ru.yastrebov.statistics.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.yastrebov.statistics.model.Statistics;

@Repository
public interface StatisticsRepository extends MongoRepository<Statistics, Long> {
}
