package MyMath;

import Graphics.Color;
import MyMath.Vector.Vector3;

public class Ray
{
    private Vector3 position;
    private Vector3 direction;
    private Color color;
    private int luminosity;

    public Ray(Vector3 position, Vector3 direction)
    {
        this.position = position;
        this.direction = direction;
        this.color = null;
        this.luminosity = 0;
    }

    public void print()
    {
        System.out.println("Position");
        this.getPosition().print();
        System.out.println("Direction");
        this.getDirection().print();
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Vector3 getDirection() {
        return direction;
    }

    public void setDirection(Vector3 direction) {
        this.direction = direction;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(int luminosity) {
        this.luminosity = luminosity;
    }
}
