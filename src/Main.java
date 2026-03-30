import controller.ElevatorController;
import enums.Direction;
import enums.RequestType;
import factories.ElevatorFactory;
import models.Request;
import observer.HallDisplay;
import system.ElevatorSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Elevator System...");
        ElevatorSystem system = ElevatorSystem.getInstance();
        ElevatorController elevator1 = ElevatorFactory.createLookElevator(1);
        elevator1.addObserver(new HallDisplay(1));
        elevator1.addObserver(new HallDisplay(5));
        system.addController(elevator1);

        Request externalReq = new Request(1, Direction.UP, RequestType.EXTERNAL);
        system.requestElevator(externalReq);
        elevator1.processNext();
        Request internalReq = new Request(5, Direction.IDLE, RequestType.INTERNAL);
        elevator1.acceptRequest(internalReq);
        elevator1.processNext(); // Elevator goes to Floor 5 to drop them off
    }
}
