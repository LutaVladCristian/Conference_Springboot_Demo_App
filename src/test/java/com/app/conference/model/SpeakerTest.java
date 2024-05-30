package com.app.conference.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeakerTest {

    @Test
    public void testSpeakerGetters(){
        Speaker speaker = new Speaker(1L, "David", "Moore", "Software Dev", "Adobe");

        assertEquals(1L, speaker.getSpeaker_id());
        assertEquals("David", speaker.getFirst_name());
        assertEquals("Moore", speaker.getLast_name());
        assertEquals("Software Dev", speaker.getTitle());
        assertEquals("Adobe", speaker.getCompany());
    }

    @Test
    public void testSpeakerSetters(){
        Speaker speaker = new Speaker(1L, "David", "Moore", "Software Dev", "Adobe");

        speaker.setSpeaker_id(1L);
        speaker.setFirst_name("David");
        speaker.setLast_name("Moore");
        speaker.setTitle("Software Dev");
        speaker.setCompany("Adobe");

        assertEquals(1L, speaker.getSpeaker_id());
        assertEquals("David", speaker.getFirst_name());
        assertEquals("Moore", speaker.getLast_name());
        assertEquals("Software Dev", speaker.getTitle());
        assertEquals("Adobe", speaker.getCompany());
    }
}
