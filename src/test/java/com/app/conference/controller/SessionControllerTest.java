package com.app.conference.controller;

import com.app.conference.model.Session;
import com.app.conference.service.SessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SessionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SessionService sessionService;

    private List<Session> sessions;

    @BeforeEach
    public void setup() {
        sessions = Arrays.asList(
                new Session(1L, "Session 1", 60),
                new Session(2L, "Session 2", 90)
        );
    }

    @Test
    public void testGetAllSessions() throws Exception {
        when(sessionService.list()).thenReturn(sessions);

        mockMvc.perform(get("/api/v1/conference/allSessions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].session_id").value(1L))
                .andExpect(jsonPath("$[0].session_name").value("Session 1"))
                .andExpect(jsonPath("$[0].session_length").value(60))
                .andExpect(jsonPath("$[1].session_id").value(2L))
                .andExpect(jsonPath("$[1].session_name").value("Session 2"))
                .andExpect(jsonPath("$[1].session_length").value(90));
    }

    @Test
    public void testGetSessionById() throws Exception {
        Long id = 1L;
        Session session = new Session(id, "Session 1", 60);

        when(sessionService.getSessionById(id)).thenReturn(session);

        mockMvc.perform(get("/api/v1/conference/session_{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.session_id").value(id))
                .andExpect(jsonPath("$.session_name").value("Session 1"))
                .andExpect(jsonPath("$.session_length").value(60));
    }

    @Test
    public void testDeleteSession() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/api/v1/conference/deleteSession_{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateSessionLength() throws Exception {
        Long id = 1L;
        Integer newLength = 120;

        mockMvc.perform(put("/api/v1/conference/updateSession{id}toNewLength={newLength}", id, newLength)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateSessionName() throws Exception {
        Long id = 1L;
        String newName = "Updated Session";

        mockMvc.perform(put("/api/v1/conference/updateSession{id}toNewDescription={newName}", id, newName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddSession() throws Exception {
        Session session = new Session(3L, "Session 3", 120);

        mockMvc.perform(post("/api/v1/conference/addSession")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"session_id\":3,\"session_name\":\"Session 3\",\"session_length\":120}"))
                .andExpect(status().isOk());
    }
}