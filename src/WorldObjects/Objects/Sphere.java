package WorldObjects.Objects;

import MyMath.Vector.Vector3;

public class Sphere extends WorldObject
{
    private double radius;

    public Sphere(Vector3 position, double r)
    {
        super.position= position;
        this.radius = r;
    }

    @Override
    public double distance(Vector3 p) {
        return super.position.sub(p).dist() - this.radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
