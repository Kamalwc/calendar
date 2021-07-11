package com.example.demo;

import com.example.demo.dto.ReminderPl;
import com.example.demo.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public  class CalendarController {

    @Autowired
    ReminderService reminderService;

    @Autowired
    ProfileRepository profileRepository;
    // POST, PUT, GET, DELETE
    // create reminder POST ( creating / updating a resource)
    // get reminder GET (request data from a server)
    // update/ edit reminder POST
    // delete reminder DELETE

    //CREATE TESTS FOR ALL

    @GetMapping(value = "/users")
    public List<Profile> allUsers(){
        List<Profile> profiles = profileRepository.getAllProfiles();
        return profiles;
    }

    @PostMapping(value = "/reminder")
    public ResponseEntity createReminder(@RequestBody ReminderPl payload){
        Reminder reminder = reminderService.createReminder(payload);
        if(reminder != null){
            return ResponseEntity.ok().body("Success! event created.");
        }else{
            return ResponseEntity.badRequest().body("Error! not created.");
        }
    }

    @PostMapping("/reminder/{eventId}")
    public ResponseEntity updateReminder(@RequestBody ReminderPl payload, @PathVariable("eventId") Integer eventId){
        Reminder reminder = reminderService.updateReminder(payload, eventId);
        if(reminder != null){
            return ResponseEntity.ok().body("Success! event created.");
        }else{
            return ResponseEntity.badRequest().body("Error! not created.");
        }
    }

//    @GetMapping("/getEvents")
//    public List<Reminder> getEvent(@RequestParam Integer uuid){
//    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Integer id){
        return ResponseEntity.ok("Success .. event under id: " + id.toString() + "deleted");
    }

}