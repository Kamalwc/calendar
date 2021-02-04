package com.example.demo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "uuid")
    Integer uuid;

    @Column(name = "title")
    String title;

    @Column(name = "day")
    String day;

    @Column(name = "time")
    String time;

    @Column(name = "description")
    String description;

    @Column(name = "type")
    String type;
}

