package strategies;

import models.ElevatorCar;
import models.Request;

import java.util.List;

public interface DispatchStrategy {
    Integer calculateNextStop(ElevatorCar car , List<Request>pendingRequests);
}
