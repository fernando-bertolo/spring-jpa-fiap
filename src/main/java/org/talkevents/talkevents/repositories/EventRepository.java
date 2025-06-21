package org.talkevents.talkevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.talkevents.talkevents.entities.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    Event findEventByName(String name);

    @Query(value = "SELECT * FROM Event WHERE date = :date", nativeQuery = true)
    List<Event> findElementByDate(@Param("date") LocalDateTime date);
}
