package observer;

import enums.Direction;
import mover.ElevatorMover;

public class HallDisplay implements ElevatorObserver {
    private final int floorNumber;

    public HallDisplay(int floorNumber){
        this.floorNumber = floorNumber;
    }

    @Override
    public void update(int elevatorId , int currentFloor , Direction direction){
        System.out.println("[Display Floor " + floorNumber + "] Elevator "
                + elevatorId + " is now at floor " + currentFloor + " going " + direction);
    }
}
