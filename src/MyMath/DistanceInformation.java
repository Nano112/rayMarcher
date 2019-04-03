package MyMath;

public class DistanceInformation {
    private double distance;
    private int objectID;

    public DistanceInformation()
    {
        this.distance = Double.MAX_VALUE;;
        this.objectID = -1;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }
}
