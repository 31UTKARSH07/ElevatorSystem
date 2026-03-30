package system;

import controller.ElevatorController;
import models.Request;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private static ElevatorSystem instance;
    private final List<ElevatorController> controllers = new ArrayList<>();

    private ElevatorSystem(){

    }

    public static synchronized ElevatorSystem getInstance(){
        if (instance == null) {
            instance = new ElevatorSystem();
        }
        return instance;
    }


    public void addController(ElevatorController controller){
        controllers.add(controller);
    }

    public void requestElevator(Request request){
        ElevatorController bestController = controllers.get(0);
        bestController.acceptRequest(request);
    }
}
