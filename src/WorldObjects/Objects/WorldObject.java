package WorldObjects.Objects;

import MyMath.Vector.Vector3;

public abstract class WorldObject
{
    protected Vector3 position;
    public WorldObject()
    {

    }
    public abstract double distance(Vector3 p);

}
