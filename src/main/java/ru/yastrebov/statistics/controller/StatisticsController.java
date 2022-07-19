package ru.yastrebov.statistics.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yastrebov.statistics.model.Statistics;
import ru.yastrebov.statistics.model.StatisticsDTO;
import ru.yastrebov.statistics.service.StatisticsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/request_statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Operation(
            summary = "Create recording in MongoDB 'request_statistics'",
            description = "Add new recording about calling GET-method in the 'MS-agreement'")
    @PostMapping
    public ResponseEntity<StatisticsDTO> postStatistics(@RequestBody Statistics statistics) {
        return new ResponseEntity<>(statisticsService.postStatistics(statistics), HttpStatus.OK);
    }
}
