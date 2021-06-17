package com.example.demo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reminder")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Integer uuid;

    String title;

    Date day;

    Date time;

    String description;

    String type;
}

