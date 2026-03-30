package controller;

import enums.Direction;
import models.ElevatorCar;
import models.Request;
import mover.ElevatorMover;
import observer.ElevatorObserver;
import strategies.DispatchStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private final ElevatorCar car;
    private final DispatchStrategy strategy;
    private final ElevatorMover mover;
    private final List<ElevatorObserver> observers = new ArrayList<>();
    private final List<Request> pendingRequests = new ArrayList<>();

    public ElevatorController(ElevatorCar car, DispatchStrategy strategy, ElevatorMover mover) {
        this.car = car;
        this.strategy = strategy;
        this.mover = mover;
    }

    public void addObserver(ElevatorObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(){
        for (ElevatorObserver obs : observers){
            obs.update(car.getId() , car.getCurrentFloor() , car.getCurrentDirection());
        }
    }

    public void acceptRequest(Request request){
        pendingRequests.add(request);
        System.out.println("Elevator " + car.getId() + " accepted request for floor " + request.getTargetFloor());

    }

    public void processNext() {
        Integer nextFloor = strategy.calculateNextStop(car, pendingRequests);
        if (nextFloor != null) {
            car.setCurrentDirection(nextFloor > car.getCurrentFloor() ? Direction.UP : Direction.DOWN);
            try {
                mover.move(car, nextFloor);
                notifyObservers();
                System.out.println("Opening doors at floor " + nextFloor);
                pendingRequests.removeIf(r -> r.getTargetFloor() == nextFloor);
                if (pendingRequests.isEmpty()) {
                    car.setCurrentDirection(Direction.IDLE);
                }
            } catch (InterruptedException e) {
                System.out.println("Elevator movement interrupted.");
            }
        }
    }

    public ElevatorCar getCar(){
        return car;
    }
}
