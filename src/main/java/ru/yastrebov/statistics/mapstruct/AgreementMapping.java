package ru.yastrebov.statistics.mapstruct;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import ru.yastrebov.agreementStatisticsLib.model.AgreementStatistics;
import ru.yastrebov.statistics.model.Statistics;

@Mapper(componentModel = "spring")
public interface AgreementMapping {

    AgreementStatistics statisticToAgreement(Statistics statistics);

    Statistics agreementToStatistics(AgreementStatistics agreementsStatistics);

    @BeanMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    void updateFromAgreementToStatistics(AgreementStatistics agreementsStatistics, @MappingTarget Statistics statistics);

}
