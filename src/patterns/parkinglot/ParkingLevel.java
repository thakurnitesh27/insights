package patterns.parkinglot;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public abstract class ParkingLevel implements Level, Iterable {

    protected String levelName;
    protected Set<Integer> spots;
    protected int numberOfSpots;

    public ParkingLevel(int numberOfSpots, String levelName)
    {
        spots= new HashSet<>(numberOfSpots);

        this.numberOfSpots=numberOfSpots;
        this.levelName=levelName;
    }
    public abstract boolean addNewSpotSize(int size);


}
