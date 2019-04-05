package WorldObjects.Objects.Primitives;

import MyMath.Vector.Vector3;
import WorldObjects.Objects.WorldObject;

public class Plane extends WorldObject
{
    private Vector3 normal;

    public Plane(Vector3 position, Vector3 normal)
    {
        super.position = position;
        this.normal = Vector3.normalize(normal);
    }

    @Override
    public double distance(Vector3 p) {
        Vector3 position = Vector3.sub(super.position,p);
        double distance = Vector3.dot(this.normal,position);
        return distance;
    }
}
