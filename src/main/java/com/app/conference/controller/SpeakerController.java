package com.app.conference.controller;


import com.app.conference.model.Speaker;
import com.app.conference.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conference")
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;

    @GetMapping("/allSpeakers")
    public List<Speaker> getAllSpeakers(){
        return speakerService.list();
    }
}
