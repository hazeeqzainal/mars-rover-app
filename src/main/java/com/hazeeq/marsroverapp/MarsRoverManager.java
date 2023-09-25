package com.hazeeq.marsroverapp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MarsRoverManager {
    private MarsSurface marsSurface;
    private List<MarsRover> rovers;

    private int roverIdCount = 0;

    public MarsRoverManager() {
        marsSurface = new MarsSurface();
        rovers = new ArrayList<>();
    }

    public void initializeRover(int x, int y, String directionCommand, String commands) {
        if (marsSurface.isCoordinateOccupied(x, y)) {
            System.out.println("Initial position is already occupied by another rover.");
            return;
        }
        Direction direction = convertDirection(directionCommand.toLowerCase());
        MarsRover rover = new MarsRover(roverIdCount++, new Coordinate(x, y), direction);
        rovers.add(rover);
        System.out.println("Rover initialized.\nRoverID: " + rover.getId() + "\nCoordinates: " + x + "," + y + "\nDirection: " + direction.toString());
        marsSurface.occupyCoordinate(x, y);
        rover.executeCommands(commands, marsSurface);
    }

    public List<MarsRover> getRovers() {
        return rovers;
    }

    public void getAllRoversPosition() {
        System.out.println("--------------------------");
        System.out.println("All Rovers");
        for (MarsRover rover: rovers) {
            System.out.println("--------------------------");
            System.out.println("RoverID: " + rover.getId());
            System.out.println("Final Coordinate: " + rover.getCoordinate());
            System.out.println("Final Direction: " + rover.getDirection());
            System.out.println("--------------------------");
        }
    }

    public Direction convertDirection(String comandDirection) {
        if (comandDirection.equalsIgnoreCase("n")) {
            return Direction.North;
        } else if (comandDirection.equalsIgnoreCase("s")) {
            return Direction.South;
        } else if (comandDirection.equalsIgnoreCase("e")) {
            return Direction.East;
        } else if (comandDirection.equalsIgnoreCase("w")) {
            return Direction.West;
        } else {
            System.out.println("Invalid direction: " + comandDirection);
            return null;
        }
    }
}