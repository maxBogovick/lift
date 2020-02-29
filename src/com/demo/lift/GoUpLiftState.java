package com.demo.lift;

import java.util.List;
import java.util.Map;

public class GoUpLiftState extends CommonLiftState {

    private final Map<Integer, List<Passenger>> waitingPassenger;
    public GoUpLiftState(int maxFloor, final Map<Integer, List<Passenger>> waitingPassenger) {
        super(maxFloor);
        this.waitingPassenger = waitingPassenger;
    }

    @Override
    public void next(Lift lift) {
        if (lift.getCurrentFloor()>=maxFloor) {
            lift.setCurrentFloor(lift.getCurrentFloor()-1);
            lift.setDirection(Direction.DOWN);
            lift.setState(new OutLiftState(maxFloor, waitingPassenger));
        } else {
            lift.setCurrentFloor(lift.getCurrentFloor()+1);
            lift.setDirection(Direction.UP);
            lift.setState(new OutLiftState(maxFloor, waitingPassenger));
        }

    }
}
