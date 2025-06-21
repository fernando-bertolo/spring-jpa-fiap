package org.talkevents.talkevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.talkevents.talkevents.entities.Location;
import org.talkevents.talkevents.entities.Session;

import java.util.UUID;

@Repository
public interface SessionRepository extends JpaRepository<Session, UUID> {
}
