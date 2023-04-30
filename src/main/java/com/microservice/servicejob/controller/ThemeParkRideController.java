package com.microservice.servicejob.controller;

import com.microservice.servicejob.entity.ThemeParkRide;
import com.microservice.servicejob.repository.ThemeParkRideRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
public class ThemeParkRideController {

    private final ThemeParkRideRepository themeParkRideRepository;

    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository){
        this.themeParkRideRepository = themeParkRideRepository;
    }

    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRide> getRides(){
        log.info("all request rides");
        return themeParkRideRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide getRide(@PathVariable("id")long id){
        log.info("request ride by id = {} ",id);
        return themeParkRideRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/ride")
    public ThemeParkRide createRide(@RequestBody ThemeParkRide request){
        log.info("request save ride = {} ",request.toString());
        return themeParkRideRepository.save(request);
    }
}
