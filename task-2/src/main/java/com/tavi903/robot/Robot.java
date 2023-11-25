package com.tavi903.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Robot {

    private Position position;
    private Direction direction;
    private List<Pair<Position, Direction>> memory;

    public Robot() {
        this.position = new Position(0,0);
        this.direction = Direction.RIGHT;
        this.memory = new ArrayList<>();
    }

    private enum Direction {
        RIGHT, DOWN, LEFT, UP;
    }

    /**
     * Procedure with Side Effects
     */
    public void moveRobot(String[] R, Map<Position, State> cellStates) {
        updateMemory(this.position, this.direction);
        cellStates.put(this.position, State.CLEAN);
        switch (direction) {
            case RIGHT -> moveRight(R);
            case DOWN -> moveDown(R);
            case LEFT -> moveLeft(R);
            case UP -> moveUp(R);
        }
    }

    private void moveRight(String[] R) {
        if (canMoveRight(R)) {
            this.position = new Position(this.position.getX()+1, this.position.getY());
            return;
        }
        if (canMoveDown(R)) {
            this.direction = Direction.DOWN;
            this.position = new Position(this.position.getX(), this.position.getY()+1);
            return;
        }
        this.direction = Direction.LEFT;
        this.position = new Position(this.position.getX()-1, this.position.getY());
    }

    private void moveDown(String[] R) {
        if (canMoveDown(R)) {
            this.position = new Position(this.position.getX(), this.position.getY()+1);
            return;
        }
        if (canMoveLeft(R)) {
            this.direction = Direction.LEFT;
            this.position = new Position(this.position.getX()-1, this.position.getY());
            return;
        }
        this.direction = Direction.UP;
        this.position = new Position(this.position.getX(), this.position.getY()-1);
    }

    private void moveLeft(String[] R) {
        if (canMoveLeft(R)) {
            this.position = new Position(this.position.getX()-1, this.position.getY());
            return;
        }
        if (canMoveUp(R)) {
            this.direction = Direction.UP;
            this.position = new Position(this.position.getX(), this.position.getY()-1);
            return;
        }
        this.direction = Direction.RIGHT;
        this.position = new Position(this.position.getX()+1, this.position.getY());
    }

    private void moveUp(String[] R) {
        if (canMoveUp(R)) {
            this.position = new Position(this.position.getX(), this.position.getY()-1);
            return;
        }
        if (canMoveRight(R)) {
            this.direction = Direction.RIGHT;
            this.position = new Position(this.position.getX()+1, this.position.getY());
            return;
        }
        this.direction = Direction.DOWN;
        this.position = new Position(this.position.getX(), this.position.getY()+1);
    }

    private boolean canMoveRight(String[] R) {
        return this.position.getX()+1<R[0].length() && R[this.position.getY()].charAt(this.position.getX()+1) == '.';
    }

    private boolean canMoveDown(String[] R) {
        return this.position.getY()+1<R.length && R[this.position.getY()+1].charAt(this.position.getX()) == '.';
    }

    private boolean canMoveLeft(String[] R) {
        return this.position.getX()-1>=0 && R[this.position.getY()].charAt(this.position.getX()-1) == '.';
    }

    private boolean canMoveUp(String[] R) {
        return this.position.getY()-1>=0 && R[this.position.getY()-1].charAt(this.position.getX()) == '.';
    }

    private void updateMemory(Position position, Direction direction) {
        if (memory.contains(new Pair<>(position, direction)))
            throw new RuntimeException("The robot is in a loop!");
        memory.add(new Pair<>(position, direction));
    }

}
