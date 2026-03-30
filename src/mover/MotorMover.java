package mover;

import models.ElevatorCar;

public class MotorMover implements ElevatorMover{
    @Override
    public void move(ElevatorCar car , int targetFloor) throws InterruptedException {
        System.out.println("Elevator " + car.getId() + " starting motor...");

        while (car.getCurrentFloor() != targetFloor){
            if(car.getCurrentFloor() < targetFloor){
                car.setCurrentFloor(car.getCurrentFloor() + 1);
            }else {
                car.setCurrentFloor(car.getCurrentFloor() - 1);
            }
            Thread.sleep(500);
        }
        System.out.println("Elevator " + car.getId() + " arrived at floor " + targetFloor);
    }
}
