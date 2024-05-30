package com.app.conference.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "speakers")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long speaker_id;
    String first_name;
    String last_name;
    String title;
    String company;
}
