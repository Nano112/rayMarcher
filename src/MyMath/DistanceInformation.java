package MyMath;

import Graphics.Color;

public class DistanceInformation {
    private double distance;
    private int objectID;
    private int steps;
    private double minDist;
    private Color color;

    public DistanceInformation()
    {
        this.distance = Double.MAX_VALUE;
        this.objectID = -1;
        this.steps = 0;
        this.minDist = Double.MAX_VALUE;
        this.color = new Color(0,0,0);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }



    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getMinDist() {
        return minDist;
    }

    public void setMinDist(double minDist) {
        this.minDist = minDist;
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
