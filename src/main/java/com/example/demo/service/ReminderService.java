package com.example.demo.service;

import com.example.demo.Profile;
import com.example.demo.ProfileRepository;
import com.example.demo.Reminder;
import com.example.demo.ReminderRepository;
import com.example.demo.dto.ReminderPl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReminderService {
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ReminderRepository reminderRepository;

    public Reminder createReminder(ReminderPl payload){
        Optional<Profile> optionalProfile = profileRepository.findById(payload.getUserId());
        if(optionalProfile.isPresent()){
            Reminder reminder = Reminder.create(payload); // why are builder methods static??
            return reminderRepository.save(reminder);
        }else{
            return null;
        }
    }

    public Reminder updateReminder(ReminderPl payload, Integer eventId){
        Optional<Reminder> optionalReminder = reminderRepository.findByIdAndUserId(payload.getUserId(),eventId);
        if(optionalReminder.isPresent()){
            Reminder reminder = Reminder.create(payload); // why are builder methods static??
            return reminderRepository.save(reminder);
        }else{
            return null;
        }
    }

}
