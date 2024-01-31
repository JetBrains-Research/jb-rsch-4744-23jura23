package org.jetbrains.assignment.controller;

import org.jetbrains.assignment.dto.LocationDto;
import org.jetbrains.assignment.dto.MoveDto;
import org.jetbrains.assignment.service.RobotMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RobotMovementController {

    private final RobotMovementService robotMovementService;

    @Autowired
    public RobotMovementController(RobotMovementService robotMovementService) {
        this.robotMovementService = robotMovementService;
    }

    @PostMapping("/locations")
    public List<LocationDto> getLocations(@RequestBody List<MoveDto> moves) {
        return robotMovementService.getLocations(moves);
    }

    @PostMapping("/moves")
    public List<MoveDto> getMoves(@RequestBody List<LocationDto> locations) {
        return robotMovementService.getMoves(locations);
    }
}