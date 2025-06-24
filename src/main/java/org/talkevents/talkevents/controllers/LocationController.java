package org.talkevents.talkevents.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talkevents.talkevents.dtos.SaveLocationRecordDto;
import org.talkevents.talkevents.dtos.UpdateLocationRecordDto;
import org.talkevents.talkevents.entities.Location;
import org.talkevents.talkevents.services.LocationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<Location> saveLocation(@RequestBody SaveLocationRecordDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.saveLocation(input));
    }

    @PutMapping
    public ResponseEntity<Void> updateLocation(@RequestBody UpdateLocationRecordDto input) {
        locationService.updateLocation(input);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable UUID id) {
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable UUID id) {
        return ResponseEntity.ok(locationService.getLocation(id));
    }
}
