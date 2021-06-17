package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public  class CalendarController {
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ReminderRepository reminderRepository;

    // POST, PUT, GET, DELETE
    // create reminder POST ( creating / updating a resource)
    // get reminder GET (request data from a server)
    // update/ edit reminder POST
    // delete reminder DELETE


    @RequestMapping("/")
    public String FirstPage() {
        return "We succeed. we are viewing our first page.";
    }

    @GetMapping(value = "/users")
    public List<Profile> allUsers(){
        List<Profile> profiles = profileRepository.getAllProfiles();
        return profiles;
    }

    @PostMapping(value = "/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody EventModel eventModel){
      reminderRepository.createEvent(eventModel.getUuid(), eventModel.getTitle(), eventModel.getDay(), eventModel.getTime(),
              eventModel.getDescription(), eventModel.getType());

      return ResponseEntity.ok("success");
    }

    @PutMapping("/updateEvent/{id}")
    public ResponseEntity<String> updateEvent(@RequestBody EventModel eventModel, @PathVariable("id") Integer id){
        reminderRepository.updateEvent(id, eventModel.getTitle(), eventModel.getDescription(),
                eventModel.getDay(), eventModel.getType(), eventModel.getTime());

        return ResponseEntity.ok("success");
    }

    @GetMapping("/getEvents")
    public List<Reminder> getEvent(@RequestParam Integer uuid){
        return reminderRepository.findEventByUuid(uuid);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Integer id){
        reminderRepository.deleteEventById(id);
        return ResponseEntity.ok("Success .. event under id: " + id.toString() + "deleted");
    }

}