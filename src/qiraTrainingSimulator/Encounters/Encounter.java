package qiraTrainingSimulator.Encounters;

import java.util.*;

public abstract class Encounter {
    protected String name;
    protected int room;
    protected ArrayList<Encounter> encounters = new ArrayList();
    
    public Encounter(String n, int r){
        name = n;
        room = r;
        encounters.add(this);
    }
    
    public String getName(){
        return name;
    }
    
    public int getRoom() {
        return room;
    }
    
    public ArrayList getEncounters() {
        return encounters;
    }
}
