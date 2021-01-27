package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public  class IndexController {
    @Autowired
    ProfileRepository profileRepository;

    @RequestMapping("/")
    public String FirstPage() {
        return "We succeed. we are viewing our first page.";
    }

    @GetMapping(value = "/users")
    public List<Profile> allUsers(){
        List<Profile> profiles = profileRepository.getAllProfiles();
        return profiles;
    }



}