package org.jetbrains.assignment.service;

import org.jetbrains.assignment.dto.LocationDto;
import org.jetbrains.assignment.dto.MoveDto;
import org.jetbrains.assignment.model.Location;
import org.jetbrains.assignment.model.Move;
import org.jetbrains.assignment.repository.LocationRepository;
import org.jetbrains.assignment.repository.MoveRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RobotMovementService {

    private final MoveRepository moveRepository;
    private final LocationRepository locationRepository;

    public RobotMovementService(MoveRepository moveRepository, LocationRepository locationRepository) {
        this.moveRepository = moveRepository;
        this.locationRepository = locationRepository;
    }

    public List<LocationDto> getLocations(List<MoveDto> moves) {
        int x = 0;
        int y = 0;
        List<LocationDto> locations = new ArrayList<>();
        locations.add(new LocationDto(x, y));  // Initial Location

        for (MoveDto move : moves) {
            switch (move.getDirection()) {
                case "NORTH":
                    y += move.getSteps();
                    break;
                case "SOUTH":
                    y -= move.getSteps();
                    break;
                case "EAST":
                    x += move.getSteps();
                    break;
                case "WEST":
                    x -= move.getSteps();
                    break;
            }
            locations.add(new LocationDto(x, y));
            // Save the moves in the database
            moveRepository.save(new Move(null, move.getDirection(), move.getSteps()));
            // Save the locations in the database
            locationRepository.save(new Location(null, x, y));
        }
        return locations;
    }

    public List<MoveDto> getMoves(List<LocationDto> locations) {
        List<MoveDto> moves = new ArrayList<>();

        for (int i = 0; i < locations.size() - 1; i++) {
            LocationDto currentLocation = locations.get(i);
            LocationDto nextLocation = locations.get(i + 1);

            int xDifference = nextLocation.getX() - currentLocation.getX();
            int yDifference = nextLocation.getY() - currentLocation.getY();

            if (xDifference > 0) {
                moves.add(new MoveDto("EAST", xDifference));
            } else if (xDifference < 0) {
                moves.add(new MoveDto("WEST", -xDifference));
            }

            if (yDifference > 0) {
                moves.add(new MoveDto("NORTH", yDifference));
            } else if (yDifference < 0) {
                moves.add(new MoveDto("SOUTH", -yDifference));
            }
        }

        return moves;
    }
}