package patterns.parkinglot;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SimpleParkingLevel extends ParkingLevel  {

    private Set<Spots> sortedSpots;

    public SimpleParkingLevel(String levelName,int numberOfSpots) {
        super(numberOfSpots,levelName);
        sortedSpots=  new TreeSet<Spots>(Comparator.comparing(Spots::isAvailable).thenComparing(Spots::getSize));
    }

    @Override
    public boolean addNewSpotSize(int size) {
        {
            if(spots==null)
                return false;


            if(numberOfSpots>spots.size())
                return spots.add(size);
            else
                return false;
        }
    }


    @Override
    public Level buildLevel() {
       spots.stream().forEach(i->{sortedSpots.add(new CommonSpot(i));});
       spots=null;
       return this;
    }

    @Override
    public String getLevelName() {
        return levelName;
    }

    @Override
    public Iterator iterator() {
       // return new SimpleParkingLevelIterator();
        return null;
    }

    private class SimpleParkingLevelIterator implements Iterator
    {
        VehicleType vehicleType;
        SimpleParkingLevelIterator(VehicleType vehicleType)
        {
            this.vehicleType=vehicleType;

        }

        @Override
        public boolean hasNext() {
           Iterator<Spots> iterator= ((TreeSet<Spots>)sortedSpots).iterator();
           while (iterator.hasNext())
           {
               Spots spots=iterator.next();
               if(spots.isAvailable()&&spots.getSize()<=vehicleType.getSize())
               {

                       return true;
               }
           }
           return false;
        }

        @Override
        public Spots next() {
            Iterator<Spots> iterator= ((TreeSet<Spots>)sortedSpots).iterator();
            while (iterator.hasNext())
            {
                Spots spots=iterator.next();
                if(spots.isAvailable()&&spots.getSize()<=vehicleType.getSize())
                {

                    return spots;
                }
            }
            return null;
        }
    }
}
