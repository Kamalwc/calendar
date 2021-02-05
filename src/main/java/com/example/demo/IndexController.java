package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Temporal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public  class IndexController {
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    EventRepository eventRepository;


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
      eventRepository.createEvent(eventModel.getUuid(), eventModel.getTitle(), eventModel.getDay(), eventModel.getTime(),
              eventModel.getDescription(), eventModel.getType());

      return ResponseEntity.ok("success");
    }

    @PutMapping("/updateEvent/{id}")
    public ResponseEntity<String> updateEvent(@RequestBody EventModel eventModel, @PathVariable("id") Integer id){
        eventRepository.updateEvent(id, eventModel.getTitle(), eventModel.getDescription(),
                eventModel.getDay(), eventModel.getType(), eventModel.getTime());

        return ResponseEntity.ok("success");
    }

    @GetMapping("/getEvents")
    public List<Event> getEvent(@RequestParam Integer uuid){
        return eventRepository.findEventByUuid(uuid);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Integer id){
        eventRepository.deleteEventById(id);
        return ResponseEntity.ok("Success .. event under id: " + id.toString() + "deleted");
    }

}