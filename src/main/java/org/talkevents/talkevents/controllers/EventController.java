package org.talkevents.talkevents.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talkevents.talkevents.dtos.SaveEventRecordDto;
import org.talkevents.talkevents.entities.Event;
import org.talkevents.talkevents.services.EventService;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody SaveEventRecordDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.saveEvent(input));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }
}
