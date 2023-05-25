package qiraTrainingSimulator.Encounters;

/** Represents an encounter in which the room contains an immovable object. */

public class ImmovableObject extends Encounter {

/** Creates an encounter in which the room contains an immovable object with the already set name and specified room.
 * @param r The encounter's designated room.
 */
    
    public ImmovableObject(int r){
        super("Immovable Object", r);
    }
}