package com.app.conference.service;


import com.app.conference.model.Speaker;
import com.app.conference.repository.SpeakerRepo;
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
public class SpeakerService {

    @Autowired
    private SpeakerRepo speakerRepo;

    public List<Speaker> list(){
        log.warn("Got all speakers!");
        return speakerRepo.findAll();
    }
}
