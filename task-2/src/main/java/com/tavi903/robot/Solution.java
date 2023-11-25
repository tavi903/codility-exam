package com.tavi903.robot;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(String[] R) {
        Robot robot = new Robot();
        Map<Position, State> cellStates = new HashMap<>();
        for (int i=0; i<R.length; i++) {
            for (int j=0; j<R[0].length(); j++) {
                cellStates.put(new Position(j,i), State.DIRTY);
            }
        }

        try {
            while (true) {
                robot.moveRobot(R, cellStates);
            }
        } catch (RuntimeException exp) {
            // do nothing
        }

        return (int) cellStates.values().stream().filter(state -> state == State.CLEAN).count();
    }

}
