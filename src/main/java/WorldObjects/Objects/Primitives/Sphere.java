package WorldObjects.Objects.Primitives;

import MyMath.Vector.Vector3;
import WorldObjects.Objects.WorldObject;

public class Sphere extends WorldObject
{
    private double radius;

    public Sphere(Vector3 position, double r)
    {
        super.position = position;
        this.radius = r;
    }

    @Override
    public double distance(Vector3 p)
    {

        double dist = super.position.sub(p).dist() - this.radius;
        return dist;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
