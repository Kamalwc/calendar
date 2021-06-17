package com.example.demo;

import lombok.Data;


@Data
public class EventModel {
    Integer uuid;
    String title;
    String day;
    String time;
    String description;
    String type;
}