package com.example.demo;

import com.example.demo.dto.ReminderPl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reminder")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "user_id")
    Integer userId; // users id

    String title;

    @Column(name = "event_date")
    Date eventDate;

    @Column(name = "alert_date")
    Date alertDate; //drop down options (three days b4 1week b4 etc. or custom date

    String description;

    public static Reminder create(ReminderPl reminderPl){
        return Reminder.builder()
                .userId(reminderPl.getUserId())
                .title(reminderPl.getTitle())
                .eventDate(reminderPl.getEventDate())
                .alertDate(reminderPl.getAlertDate())
                .description(reminderPl.getDescription())
                .build();
    }

    public static Reminder update(ReminderPl reminderPl, Reminder reminder){
        return reminder.toBuilder()
                .title(reminderPl.getTitle())
                .eventDate(reminderPl.getEventDate())
                .alertDate(reminderPl.getAlertDate())
                .description(reminderPl.getDescription())
                .build();
    }
}
