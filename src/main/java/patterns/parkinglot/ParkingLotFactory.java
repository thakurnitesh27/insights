package patterns.parkinglot;

enum ParkingLotType
{
    SIMPLE, COMPOUND, ADVANCED
}
public class ParkingLotFactory {

    public ParkingLot createParkingLot(ParkingLotType parkingLotType, int levels)
    {
        if(parkingLotType==ParkingLotType.SIMPLE)
        {
            Level[] levelList=new Level[levels];
            for(int i=0;i<levels;i++)
            {
                SimpleParkingLevel simpleParkingLevel=new SimpleParkingLevel("Level"+(i+1),3);
                simpleParkingLevel.addNewSpotSize(5);
                simpleParkingLevel.addNewSpotSize(10);
                simpleParkingLevel.addNewSpotSize(15);
                levelList[i]=simpleParkingLevel.buildLevel();
            }
            ParkingLot parkingLot= new ParkingLot();
            parkingLot.setLevels(levelList);
            return parkingLot;
        }
        //todo for other parking type.
        return null;
    }
}
