package factories;

import controller.ElevatorController;
import models.ElevatorCar;
import mover.ElevatorMover;
import mover.MotorMover;
import strategies.DispatchStrategy;
import strategies.impl.LookAlgo;
import strategies.impl.ScanAlgo;

public class ElevatorFactory {
    public static ElevatorController createLookElevator(int id){
        ElevatorCar car = new ElevatorCar(id);
        DispatchStrategy strategy = new LookAlgo();
        ElevatorMover mover = new MotorMover();
        return new ElevatorController(car,strategy,mover);
    }


    public static ElevatorController createScanElevator(int id ,int minFloor , int maxFloor){
        ElevatorCar car = new ElevatorCar(id);
        DispatchStrategy strategy = new ScanAlgo(maxFloor,minFloor);
        ElevatorMover mover = new MotorMover();
        return new ElevatorController(car,strategy,mover);
    }
}
