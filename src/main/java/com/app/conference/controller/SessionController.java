package com.app.conference.controller;


import com.app.conference.model.Session;
import com.app.conference.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conference")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping("/allSessions")
    public List<Session> getAllSessions(){
        return sessionService.list();
    }

    @GetMapping("/session_{id}")
    public Session getSessionById(@PathVariable Long id){
        return sessionService.getSessionById(id);
    }

    @DeleteMapping("/deleteSession_{id}")
    public void deleteSession(@PathVariable Long id){
        sessionService.deleteSessionById(id);
    }

    @PutMapping("/updateSession{id}toNewLength={newLength}")
    public void updateSessionLenght(@PathVariable("id") Long id, @PathVariable("newLength") Integer newLength){
        sessionService.updateSessionLength(id, newLength);
    }

    @PutMapping("/updateSession{id}toNewDescription={newName}")
    public void updateSessionName(@PathVariable("id") Long id, @PathVariable("newName") String newName){
        sessionService.updateSessionName(id, newName);
    }

    @PostMapping("/addSession")
    public void addSession(@RequestBody Session session){
        sessionService.addSession(session);
    }
}
