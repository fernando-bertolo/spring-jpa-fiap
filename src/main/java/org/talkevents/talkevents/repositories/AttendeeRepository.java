package org.talkevents.talkevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.talkevents.talkevents.entities.Attendee;

import java.util.UUID;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, UUID> {
}
