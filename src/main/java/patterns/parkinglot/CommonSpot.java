package patterns.parkinglot;

public class CommonSpot implements Spots {
    int spotSize;
    boolean isAvailable;

    CommonSpot(int spotSize)
    {
        this.spotSize=spotSize;
        isAvailable=true;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public Integer getSize() {
        return spotSize;
    }

    public void setFilled()
    {
        isAvailable=false;
    }

}
