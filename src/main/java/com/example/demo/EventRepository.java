package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EventRepository extends PagingAndSortingRepository<Event, Integer> {
    Event findEventsByUuid(@Param("uuid") Integer uuid);

    @Modifying
    @Query( value ="INSERT INTO " +
            " calendar.event(uuid, title, description, day, type, time) " +
            " VALUES (:uuid, :title, :description, :day, :type, :time) ", nativeQuery = true)
    @Transactional
    void inserTRow(@Param("uuid") Integer uuid, @Param("title") String title,  @Param("day") String day
                    , @Param("time") String time, @Param("description") String description , @Param("type") String type);
}
