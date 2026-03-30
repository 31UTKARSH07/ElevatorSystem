package models;

import enums.Direction;
import enums.ElevatorState;

public class ElevatorCar {
    private final int id;
    private int currentFloor;
    private Direction currentDirection;
    private ElevatorState state;

    public ElevatorCar(int id){
        this.id = id;
        this.currentFloor = 0;
        this.currentDirection = Direction.IDLE;
        this.state = ElevatorState.STOPPED;
    }

    public int getId(){
        return id;
    }
    public int getCurrentFloor(){
        return currentFloor;

    }
    public void setCurrentFloor(int floor){
        this.currentFloor = floor;
    }
    public Direction getCurrentDirection(){
        return currentDirection;
    }
    public void setCurrentDirection(Direction dir){
        this.currentDirection = dir;
    }

}
