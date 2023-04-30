package com.microservice.servicejob.repository;

import com.microservice.servicejob.entity.ThemeParkRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeParkRideRepository extends JpaRepository<ThemeParkRide, Long> {

    @Query(value = "select * from theme_park_ride where name=:name", nativeQuery = true)
    List<ThemeParkRide> getByName(@Param("name")String name);


}
