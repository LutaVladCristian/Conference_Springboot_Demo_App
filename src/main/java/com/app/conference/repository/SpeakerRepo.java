package com.app.conference.repository;

import com.app.conference.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepo extends JpaRepository<Speaker, Long> {
}
