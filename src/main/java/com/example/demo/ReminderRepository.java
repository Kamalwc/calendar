package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReminderRepository extends PagingAndSortingRepository<Reminder, Integer> {

    @Query(value = "select * from calendar.event where uuid = :uuid ", nativeQuery = true)
    List<Reminder> findEventByUuid(@Param("uuid") Integer uuid);

    @Modifying
    @Query( value ="INSERT INTO " +
            " calendar.event(uuid, title, description, day, type, time) " +
            " VALUES (:uuid, :title, :description, :day, :type, :time) ", nativeQuery = true)
    @Transactional
    void createEvent(@Param("uuid") Integer uuid, @Param("title") String title,  @Param("day") String day
                    , @Param("time") String time, @Param("description") String description , @Param("type") String type);

    @Modifying
    @Query(value = " UPDATE calendar.event SET " +
            " title = :title, description = :description, day = :day, type = :type, time = :time " +
            " where id = :id ", nativeQuery = true)
    @Transactional
    void updateEvent( @Param("id") Integer id, @Param("title") String title, @Param("description") String description,
                      @Param("day") String day, @Param("type") String type, @Param("time") String time);

    @Modifying
    @Query(value = " DELETE from calendar.event where id = :id ", nativeQuery = true)
    @Transactional
    void deleteEventById(@Param("id") Integer id);

}
