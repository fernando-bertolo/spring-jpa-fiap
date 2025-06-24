package org.talkevents.talkevents.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.talkevents.talkevents.dtos.SaveEventRecordDto;
import org.talkevents.talkevents.entities.Attendee;
import org.talkevents.talkevents.entities.Event;
import org.talkevents.talkevents.entities.Location;
import org.talkevents.talkevents.repositories.AttendeeRepository;
import org.talkevents.talkevents.repositories.EventRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public EventService(EventRepository eventRepository, AttendeeRepository attendeeRepository) {
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
    }

    @Transactional
    public Event saveEvent(SaveEventRecordDto input) {
        var event = new Event();
        Set<Attendee> attendees = new HashSet<>(attendeeRepository.findAllById(input.attendees()));
        var location = new Location();

        location.setName(input.name());
        location.setAddress(input.location().address());
        location.setCapacity(input.location().capacity());

        event.setName(input.name());
        event.setDate(input.date());
        event.setAttendees(attendees);
        event.setLocation(location);

        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
