package WorldObjects.Objects.Primitives;

import MyMath.MyMath;
import MyMath.Vector.Vector3;
import WorldObjects.Objects.WorldObject;

public class CombinedObjects extends WorldObject {
    private WorldObject object1;
    private WorldObject object2;
    private double smoothness;
    private boolean intersect;
    private boolean object1Negative;
    private boolean object2Negative;

    public CombinedObjects(WorldObject o1, WorldObject o2, double smoothness, boolean intersect, boolean object1Negative, boolean object2Negative) {
        this.object1 = o1;
        this.object2 = o2;
        this.smoothness = smoothness;
        this.intersect = intersect;
        this.object1Negative = object1Negative;
        this.object2Negative = object2Negative;
    }


    @Override
    public double distance(Vector3 p) {
        if (intersect)
        {
            return intersectDistance(p);
        }
        else
        {
            return unionDistance(p);
        }
    }

    public double unionDistance(Vector3 p)
    {
        double d1 = object1.distance(p);
        double d2 = object2.distance(p);
        if (this.object1Negative)
        {
            d1*=-1;
        }
        if (this.object2Negative)
        {
            d2*=-1;
        }
        return MyMath.smin(d1,d2,this.smoothness);
    }

    public double intersectDistance(Vector3 p)
    {
        double d1 = object1.distance(p);
        double d2 = object2.distance(p);
        if (this.object1Negative)
        {
            d1*=-1;
        }
        if (this.object2Negative)
        {
            d2*=-1;
        }
        return Math.max(d1,d2);
    }

}
