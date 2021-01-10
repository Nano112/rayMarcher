package WorldObjects.Objects.Primitives;

import MyMath.Vector.Vector3;
import WorldObjects.Objects.WorldObject;

import static java.lang.Double.max;
import static java.lang.Double.min;


public class Box extends WorldObject
{
    private Vector3 dimensions;

    public Box(Vector3 position, Vector3 dim)
    {
        super.position = position;
        this.dimensions = dim;
    }

    @Override
    public double distance(Vector3 p)
    {
        Vector3 position = Vector3.sub(super.position,p);
        Vector3 d = Vector3.abs(position).sub(this.dimensions);
        return Vector3.dist(Vector3.max(d,0.0))
                //+ min(max(d.getX(),max(d.getY(),d.getZ())),0.0)
          ;
    }

    public Vector3 getDimensions()
    {
        return dimensions;
    }

    public void setDimensions(Vector3 dimensions)
    {
        this.dimensions = dimensions;
    }


}
