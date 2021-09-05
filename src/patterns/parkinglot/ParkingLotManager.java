package patterns.parkinglot;

import java.util.ArrayList;
import java.util.Set;

public class ParkingLotManager {

    ParkingLot parkingLot;
    ArrayList<Vehicle> vehicles;
    ParkingLotFactory parkingLotFactory;

    public ParkingLotManager()
    {
        parkingLotFactory=new ParkingLotFactory();
        vehicles=new ArrayList<>();

    }

    public void initializeWithDefaultValues()
    {
       parkingLot= parkingLotFactory.createParkingLot(ParkingLotType.SIMPLE,3);


    }
    public boolean addVehicleToPark(Vehicle vehicle)
    {
return false;
    }

    private Spots findSpot(VehicleType vehicle)
    {
        Level[] levels=parkingLot.getLevels();

        for(int i=0;i<levels.length;i++)
        {
            //Set<Spots> spots=levels[i].
        }
        return null;
    }
}
