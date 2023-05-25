package qiraTrainingSimulator.Encounters;

import java.util.*;

/** Represents an encounter in a room. */

public abstract class Encounter {
    protected String name;
    protected int room;
    protected ArrayList<Encounter> encounters = new ArrayList();

/** Creates an encounter with the specified name and room.
 * @param n The encounter's name.
 * @param r The encounter's designated room.
 */
    
    public Encounter(String n, int r){
        name = n;
        room = r;
        encounters.add(this);
    }
    
/** Gets the encounter's name.
 * @return A String representing the encounter's name.
 */
    
    public String getName(){
        return name;
    }
    
/** Gets the number of the room designated to the encounter.
 * @return An integer representing the encounter's designated room.
 */
    
    public int getRoom() {
        return room;
    }
    
/** Gets the list of encounters made.
 * @return An ArrayList representing the list of encounters.
 */
    
    public ArrayList getEncounters() {
        return encounters;
    }
}