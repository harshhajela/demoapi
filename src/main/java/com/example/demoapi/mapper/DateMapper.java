package com.example.demoapi.mapper;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {

    public OffsetDateTime asOffsetDateTime(LocalDateTime localDateTime) {
        return localDateTime != null ?
                localDateTime.atZone(ZoneOffset.UTC).toOffsetDateTime() : null;
    }

    public LocalDateTime asLocalDateTime(OffsetDateTime offsetDateTime) {
        return offsetDateTime != null ? offsetDateTime.toLocalDateTime() : null;
    }

}
