package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ReminderRepository extends PagingAndSortingRepository<Reminder, Integer> {

    @Query(value = "select * from calendar.event where uuid = :uuid ", nativeQuery = true)
    List<Reminder> findEventByUuid(@Param("uuid") Integer uuid);


    @Modifying
    @Query(value = " DELETE from calendar.event where id = :id ", nativeQuery = true)
    @Transactional
    void deleteEventById(@Param("id") Integer id);

    Optional<Reminder> findByIdAndUserId(Integer eventid, Integer userId);

}
