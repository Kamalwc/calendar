package com.example.demo.dto;

import lombok.Data;
import java.util.Date;


@Data
public class ReminderPl {
    Integer userId;
    String title;
    Date eventDate;
    Date alertDate;
    String description;
}

