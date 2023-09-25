package com.hazeeq.marsroverapp;

public class MarsRover {
    private int id;
    private Coordinate coordinate;
    private Direction direction;

    public MarsRover(int id, Coordinate coordinate, Direction direction) {
        this.id = id;
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public int getId() {
        return id;
    }
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void executeCommands(String commands, MarsSurface marsSurface) {
        commands = commands.trim().replace(",","");

        // Check if the input contains only valid commands
        if (!commands.matches("^[fblr]+$")) {
            throw new IllegalArgumentException("Invalid commands: " + commands);
        }

        char commandsCharArray[] = commands.toCharArray();

        for (char command : commandsCharArray) {
            executeCommand(command, marsSurface);
        }
    }

    private void executeCommand(char command, MarsSurface marsSurface) {
        switch (command) {
            case 'f':
                moveForward(marsSurface);
                break;
            case 'b':
                moveBackward(marsSurface);
                break;
            case 'r':
                rotateClockwise();
                break;
            case 'l':
                rotateAntiClockwise();
                break;
            default:
                throw new IllegalArgumentException("Invalid command: " + command);
        }
    }

    public void moveForward(MarsSurface marsSurface) {
        switch (direction) {
            case North:
                if (!marsSurface.isCoordinateOccupied(coordinate.getX(), coordinate.getY() + 1)) {
                    marsSurface.vacateCoordinate(coordinate.getX(), coordinate.getY());
                    coordinate.setY(coordinate.getY() + 1);
                    marsSurface.occupyCoordinate(coordinate.getX(), coordinate.getY());
                }
                break;
            case South:
                if (!marsSurface.isCoordinateOccupied(coordinate.getX(), coordinate.getY() - 1)) {
                    marsSurface.vacateCoordinate(coordinate.getX(), coordinate.getY());
                    coordinate.setY(coordinate.getY() - 1);
                    marsSurface.occupyCoordinate(coordinate.getX(), coordinate.getY());
                }
                break;
            case East:
                if (!marsSurface.isCoordinateOccupied(coordinate.getX() + 1, coordinate.getY())) {
                    marsSurface.vacateCoordinate(coordinate.getX(), coordinate.getY());
                    coordinate.setX(coordinate.getX() + 1);
                    marsSurface.occupyCoordinate(coordinate.getX(), coordinate.getY());
                }
                break;
            case West:
                if (!marsSurface.isCoordinateOccupied(coordinate.getX() - 1, coordinate.getY())) {
                    marsSurface.vacateCoordinate(coordinate.getX(), coordinate.getY());
                    coordinate.setX(coordinate.getX() - 1);
                    marsSurface.occupyCoordinate(coordinate.getX(), coordinate.getY());
                }
                break;
        }
    }

    public void moveBackward(MarsSurface marsSurface) {
        int count = 0;
        switch (direction) {
            case North:
                if (!marsSurface.isCoordinateOccupied(coordinate.getX(), coordinate.getY() - 1)) {
                    marsSurface.vacateCoordinate(coordinate.getX(), coordinate.getY());
                    coordinate.setY(coordinate.getY() - 1);
                    marsSurface.occupyCoordinate(coordinate.getX(), coordinate.getY());
                }
                break;
            case South:
                if (!marsSurface.isCoordinateOccupied(coordinate.getX(), coordinate.getY() + 1)) {
                    marsSurface.vacateCoordinate(coordinate.getX(), coordinate.getY());
                    coordinate.setY(coordinate.getY() + 1);
                    marsSurface.occupyCoordinate(coordinate.getX(), coordinate.getY());
                }
                break;
            case East:
                if (!marsSurface.isCoordinateOccupied(coordinate.getX() - 1, coordinate.getY())) {
                    marsSurface.vacateCoordinate(coordinate.getX(), coordinate.getY());
                    coordinate.setX(coordinate.getX() - 1);
                    marsSurface.occupyCoordinate(coordinate.getX(), coordinate.getY());
                }
                break;
            case West:
                if (!marsSurface.isCoordinateOccupied(coordinate.getX() + 1, coordinate.getY())) {
                    marsSurface.vacateCoordinate(coordinate.getX(), coordinate.getY());
                    coordinate.setX(coordinate.getX() + 1);
                    marsSurface.occupyCoordinate(coordinate.getX(), coordinate.getY());
                }
                break;
        }
    }

    public void rotateClockwise() {
        switch (direction) {
            case North:
                direction = Direction.East;
                break;
            case South:
                direction = Direction.West;
                break;
            case East:
                direction = Direction.South;
                break;
            case West:
                direction = Direction.North;
                break;
        }
    }

    public void rotateAntiClockwise() {
        switch (direction) {
            case North:
                direction = Direction.West;
                break;
            case South:
                direction = Direction.East;
                break;
            case East:
                direction = Direction.North;
                break;
            case West:
                direction = Direction.South;
                break;
        }
    }
    public String getFinalState() {
        return "Final Coordinate: " + getCoordinate().getX() + ", " + getCoordinate().getY() + "\nFinal Direction: " + direction;
    }

}
