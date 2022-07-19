package ru.yastrebov.statistics.mapstruct;

import org.mapstruct.*;
import ru.yastrebov.statistics.model.Statistics;
import ru.yastrebov.statistics.model.StatisticsDTO;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public interface StatisticsMapper {

    StatisticsDTO entityToDto(Statistics statistics);

    @Mapping(target = "date", ignore = true)
    Statistics dtoToEntity(StatisticsDTO statisticsDTO);

    @AfterMapping
    default void afterMappingStatisticsDto(StatisticsDTO statisticsDTO, @MappingTarget Statistics statistics) {

        LocalDateTime localDate = statisticsDTO.getDate();
        ZonedDateTime zonedDateTime = localDate.atZone(ZoneId.of("Europe/Moscow"));

        statistics.setDate(zonedDateTime);
    }
}
