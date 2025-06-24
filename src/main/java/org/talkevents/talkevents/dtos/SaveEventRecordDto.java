package org.talkevents.talkevents.dtos;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record SaveEventRecordDto(
        String name,
        LocalDateTime date,
        Set<UUID> attendees,
        SaveLocationRecordDto location
) {
}
