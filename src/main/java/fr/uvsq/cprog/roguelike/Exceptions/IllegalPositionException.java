package fr.uvsq.cprog.roguelike.Exceptions;

public class IllegalPositionException extends Exception{

    public IllegalPositionException() {
        super("X and Y must be positive");
    }
}
