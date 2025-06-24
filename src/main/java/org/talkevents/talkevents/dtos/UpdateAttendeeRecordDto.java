package org.talkevents.talkevents.dtos;

import java.util.UUID;

public record UpdateAttendeeRecordDto(
        UUID id,
        String name,
        String email
) {
}
