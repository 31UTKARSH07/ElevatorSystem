package strategies.impl;

import models.ElevatorCar;
import models.Request;
import strategies.DispatchStrategy;

import java.util.List;

public class ScanAlgo implements DispatchStrategy {
    private final int maxFloor;
    private final int minFloor;

    public ScanAlgo(int maxFloor , int minFloor){
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    @Override
    public Integer calculateNextStop(ElevatorCar car , List<Request> pendingRequests){
        if(pendingRequests.isEmpty()) return null;

        System.out.println("Calculating next stop using SCAN algorithm.....");
        return pendingRequests.get(0).getTargetFloor();
    }
}
