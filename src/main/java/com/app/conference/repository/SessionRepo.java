package com.app.conference.repository;

import com.app.conference.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface SessionRepo extends JpaRepository<Session, Long>{

    @Modifying
    @Query("update Session s set s.session_length = ?2 where s.session_id = ?1")
    void updateSessionLength(Long id, Integer newLength);

    @Modifying
    @Query("update Session s set s.session_name = ?2 where s.session_id = ?1")
    void updateSessionName(Long id, String newName);
}
