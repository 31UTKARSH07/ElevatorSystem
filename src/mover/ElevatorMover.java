package mover;

import models.ElevatorCar;

public interface ElevatorMover {
    void move(ElevatorCar car , int targetFloor) throws  InterruptedException;
}
