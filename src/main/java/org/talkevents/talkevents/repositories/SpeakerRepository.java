package org.talkevents.talkevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.talkevents.talkevents.entities.Session;
import org.talkevents.talkevents.entities.Speaker;

import java.util.UUID;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, UUID> {
}
