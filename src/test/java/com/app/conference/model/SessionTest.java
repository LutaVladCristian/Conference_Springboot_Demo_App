package com.app.conference.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionTest {

    @Test
    public void testSessionGetters(){
        Session session = new Session(1L, "Session 1", 60);

        assertEquals(1L, session.getSession_id());
        assertEquals("Session 1", session.getSession_name());
        assertEquals(60, session.getSession_length());
    }

    @Test
    public void testSessionSetters(){
        Session session = new Session();

        session.setSession_id(1L);
        session.setSession_name("Session 1");
        session.setSession_length(60);

        assertEquals(1L, session.getSession_id());
        assertEquals("Session 1", session.getSession_name());
        assertEquals(60, session.getSession_length());
    }
}
