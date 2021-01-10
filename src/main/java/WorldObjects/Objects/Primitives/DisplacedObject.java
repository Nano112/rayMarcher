package WorldObjects.Objects.Primitives;

import MyMath.Vector.Vector3;
import WorldObjects.Objects.WorldObject;

public class DisplacedObject extends WorldObject
{

    public interface Modifier
    {
        double Modify(Vector3 p);
    }


    private WorldObject object;
    private Modifier m;
    public DisplacedObject(WorldObject object, Modifier m)
    {
        this.object = object;
        this.m = m;
    }


    @Override
    public double distance(Vector3 p) {
        return this.object.distance(p)+m.Modify(p);
    }
}
