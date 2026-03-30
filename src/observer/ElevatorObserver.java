package observer;

import enums.Direction;

public interface ElevatorObserver {
    void update(int elevatorId , int currentFloor , Direction direction);
}
