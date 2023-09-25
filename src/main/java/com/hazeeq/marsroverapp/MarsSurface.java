package com.hazeeq.marsroverapp;
import java.util.HashSet;
import java.util.Set;

public class MarsSurface {
    private Set<Coordinate> occupiedCoordinates;

    public MarsSurface() {
        this.occupiedCoordinates = new HashSet<>();
    }

    public boolean isCoordinateOccupied(int x, int y) {
        return occupiedCoordinates.contains(new Coordinate(x, y));
    }

    public void occupyCoordinate(int x, int y) {
        occupiedCoordinates.add(new Coordinate(x, y));
    }

    public void vacateCoordinate(int x, int y) {
        occupiedCoordinates.remove(new Coordinate(x, y));
    }
}