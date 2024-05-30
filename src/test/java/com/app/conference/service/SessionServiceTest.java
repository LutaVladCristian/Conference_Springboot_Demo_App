package com.app.conference.service;

import com.app.conference.model.Session;
import com.app.conference.repository.SessionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SessionServiceTest {

    @InjectMocks
    SessionService sessionService;

    @Mock
    SessionRepo sessionRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllSessions() {
        List<Session> sessions = Arrays.asList(
                new Session(1L, "Session 1", 60),
                new Session(2L, "Session 2", 90)
        );

        when(sessionRepository.findAll()).thenReturn(sessions);

        List<Session> result = sessionService.list();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetSessionById() {
        Session session = new Session(1L, "Session 1", 60);

        when(sessionRepository.findById(1L)).thenReturn(Optional.of(session));

        Session result = sessionService.getSessionById(1L);
        assertEquals("Session 1", result.getSession_name());
        assertEquals(60, result.getSession_length());
    }

    @Test
    public void testDeleteSession() {
        Session session = new Session(1L, "Session 1", 60);

        sessionService.deleteSessionById(session.getSession_id());

        verify(sessionRepository, times(1)).deleteById(session.getSession_id());
    }

    @Test
    public void testUpdateSessionLength() {
        Session session = new Session(1L, "Session 1", 60);

        when(sessionRepository.findById(1L)).thenReturn(Optional.of(session));

        sessionService.updateSessionLength(1L, 60);

        assertEquals(60, session.getSession_length());
    }

    @Test
    public void testUpdateSessionName() {
        Session session = new Session(1L, "Session 1", 60);

        when(sessionRepository.findById(1L)).thenReturn(Optional.of(session));

        sessionService.updateSessionName(1L, "Session 1");

        assertEquals("Session 1", session.getSession_name());
    }

    @Test
    public void testAddSession() {
        Session session = new Session(3L, "Session 3", 120);

        when(sessionRepository.save(session)).thenReturn(session);

        Session result = sessionService.addSession(session);

        assertEquals("Session 3", result.getSession_name());
        assertEquals(120, result.getSession_length());
    }
}