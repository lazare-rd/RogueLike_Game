package fr.uvsq.cprog.roguelike.Exceptions;

/**
 * @author lazare-rd
 * @version 01/01/2023
 */
public class IllegalPositionException extends Exception{

    public IllegalPositionException() {
        super("X and Y must be positive");
    }
}
