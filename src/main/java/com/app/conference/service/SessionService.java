package com.app.conference.service;

import com.app.conference.model.Session;
import com.app.conference.repository.SessionRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class SessionService {
    @Autowired
    private SessionRepo sessionRepo;

    public List<Session> list(){
        log.warn("Got all sessions!");
        return sessionRepo.findAll();
    }

    public Session getSessionById(Long id) {
        log.warn("Got session by id = " + id.toString() + "!");
        return sessionRepo.findById(id).orElse(null);
    }

    public void deleteSessionById(Long id) {
        log.warn("Deleted session by id = " + id.toString() + "!");
        sessionRepo.deleteById(id);
    }

    @Transactional
    public void updateSessionLength(Long id, Integer newLength) {
        log.warn("Updated session by id = " + id.toString() + " to length = " + newLength.toString() + "!");
        sessionRepo.updateSessionLength(id, newLength);
    }

    @Transactional
    public void updateSessionName(Long id, String newName) {
        log.warn("Updated session by id = " + id.toString() + " with the new description: " + newName + "!");
        sessionRepo.updateSessionName(id, newName);
    }

    public Session addSession(Session session) {
        log.warn("Added session!");
        sessionRepo.save(session);
        return session;
    }
}
