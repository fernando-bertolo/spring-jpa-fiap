package org.talkevents.talkevents.dtos;

import java.util.UUID;

public record UpdateLocationRecordDto(
        UUID id,
        String name,
        String address,
        int capacity
) {}
