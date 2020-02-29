package com.demo.lift;

import java.util.*;

public class Lift {

    private final int maxCapacity;
    private final Collection<Passenger> passengers;
    private LiftState state;
    private Direction direction;
    private int currentFloor;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Lift(int maxCapacity, LiftState state) {
        this.maxCapacity = maxCapacity;
        this.state = state;
        currentFloor = 0;
        passengers = new ArrayList<>(maxCapacity);
    }

    public int getMaxCapacity() {

        return maxCapacity;
    }

    public void run() {
        state.next(this);
    }

    public boolean isFull() {
        return passengers.size() >= maxCapacity;
    }

    public Collection<Passenger> getPassengers() {
        return passengers;
    }

    public LiftState getState() {
        return state;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setState(LiftState state) {
        this.state = state;
    }

    public static void main(String[] args) {
        Map<Integer, List<Passenger>> map = new HashMap<>();
        map.put(1, new ArrayList<>(Arrays.asList(new Passenger(1, 3), new Passenger(1, 4), new Passenger(1, 10))));
        map.put(3, new ArrayList<>(Arrays.asList(new Passenger(3, 0), new Passenger(3, 1), new Passenger(3, 10))));
        map.put(6, new ArrayList<>(Arrays.asList(new Passenger(6, 0), new Passenger(6, 1), new Passenger(6, 8), new Passenger(6, 3))));
        Lift lift = new Lift(5, new FillLiftState(10, map));
        lift.setCurrentFloor(0);
        while (true) {
            System.out.println("current floor = " + lift.getCurrentFloor() + " passenger in lift = " + lift.getPassengers().size() );
            lift.run();
            System.out.println("after waiting passengers = " + map);
        }
    }
}
