package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    @Query(value = "SELECT * " +
            "FROM calendar.profile ",nativeQuery = true)
    List<Profile> getAllProfiles();
}
