package qiraTrainingSimulator.Encounters;

/** Represents an encounter in which the room contains an enemy. */

public class Enemy extends Encounter {

/** Creates an encounter in which the room contains a coin with the already set name and specified room.
 * @param r The encounter's designated room.
 */
    
    public Enemy(int r){
        super("Enemy", r);
    }
}