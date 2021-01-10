package WorldObjects.Objects;

import Graphics.Color;
import MyMath.Vector.Vector3;

public abstract class WorldObject
{
    protected Vector3 position;
    protected Color color;
    public WorldObject()
    {

    }
    public abstract double distance(Vector3 p);

}
