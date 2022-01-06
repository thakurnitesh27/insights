package patterns.parkinglot;

enum VehicleType
{
    TWO_WHEELER(5), COMPACT(10), HATCH(12), SEDAN(15), MINI_BUS(20), BUS(25), TRUCK(30);
    private int size;
    private VehicleType(int size)
    {
        this.size=size;
    }
    public int getSize()
    {
        return size;
    }
}
public  abstract class Vehicle {

VehicleType vehicleType;
String name;
String registrationNo;
    public Vehicle(VehicleType vehicleType, String vehicleName)
    {
this.vehicleType=vehicleType;
this.name=vehicleName;
    }

}
