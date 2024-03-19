package com.project.reader.controller;

import com.project.reader.services.EventService;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('PORTAL')")
    @GetMapping("/something/{serial}")
    @Transactional
    public List<String> something(@PathVariable String serial, @Param("lastModifiedDate") Long lastModifiedDate) {

        return null;

    }

}
