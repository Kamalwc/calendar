package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    @Query(value = "SELECT * " +
            "FROM calendar.profile ",nativeQuery = true)
    List<Profile> getAllProfiles();

    @Query(value = "SELECT * " +
            "FROM calendar.profile WHERE id = :id ",nativeQuery = true)
    Optional<Profile>  findById(Integer id);

}
