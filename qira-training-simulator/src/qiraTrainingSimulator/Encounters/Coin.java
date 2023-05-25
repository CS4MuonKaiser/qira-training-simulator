package qiraTrainingSimulator.Encounters;

/** Represents an encounter in which the room contains a coin. */

public class Coin extends Encounter {

/** Creates an encounter in which the room contains a coin with the already set name and specified room.
 * @param r The encounter's designated room.
 */
    
    public Coin(int r){
        super("Coin", r);
    }
}