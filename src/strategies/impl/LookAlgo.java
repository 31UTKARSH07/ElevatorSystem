package strategies.impl;

import models.ElevatorCar;
import models.Request;
import strategies.DispatchStrategy;

import java.util.List;

public class LookAlgo implements DispatchStrategy {

    @Override
    public Integer calculateNextStop(ElevatorCar car , List<Request> pendingRequests){
        if(pendingRequests.isEmpty()) return null;

        System.out.println("Calculating next stop using Look algorithm....");
        return pendingRequests.get(0).getTargetFloor();
    }
}
