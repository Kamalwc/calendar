package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void createEvent(@RequestBody EventModel eventModel){
      eventRepository.inserTRow(eventModel.getUuid(), eventModel.getTitle(), eventModel.getDay(), eventModel.getTime(),
              eventModel.getDescription(), eventModel.getType());
    }


}