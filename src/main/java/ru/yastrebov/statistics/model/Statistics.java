package ru.yastrebov.statistics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.yastrebov.statistics.model.enums.Status;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "request_statistics")
public class Statistics {

    @Id
    private Long id;

    private ZonedDateTime date;

    private Status status;
}
