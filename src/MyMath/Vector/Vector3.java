package MyMath.Vector;

public class Vector3
{
    private double x;
    private double y;
    private double z;

    public Vector3()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public void print()
    {
        System.out.println("X: " + this.x + " Y: " + this.y + " Z: " + this.z);
    }

    public Vector3(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double dist()
    {
        return Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z);
    }

    public static double dist(Vector3 a)
    {
        return Math.sqrt(a.x*a.x+a.y*a.y+a.z*a.z);
    }

    public static Vector3 abs(Vector3 a)
    {
        double x = Math.abs(a.x);
        double y = Math.abs(a.y);
        double z = Math.abs(a.z);
        return new Vector3(x, y, z);
    }

    public static Vector3 max(Vector3 a, double b)
    {
        double x = Math.max(a.x,b);
        double y = Math.max(a.y,b);
        double z = Math.max(a.z,b);
        return new Vector3(x, y, z);
    }

    public static Vector3 min(Vector3 a, double b)
    {
        double x = Math.min(a.x,b);
        double y = Math.min(a.y,b);
        double z = Math.min(a.z,b);
        return new Vector3(x, y, z);
    }

    public static Vector3 add(Vector3 a, Vector3 b)
    {
        double x = a.x + b.x;
        double y = a.y + b.y;
        double z = a.z + b.z;
        return new Vector3(x, y, z);
    }

    public static Vector3 add(Vector3 a, double b)
    {
        double x = a.x + b;
        double y = a.y + b;
        double z = a.z + b;
        return new Vector3(x, y, z);
    }

    public static Vector3 sub(Vector3 a, Vector3 b)
    {
        double x = a.x - b.x;
        double y = a.y - b.y;
        double z = a.z - b.z;
        return new Vector3(x, y, z);
    }

    public static Vector3 sub(Vector3 a, double b)
    {
        double x = a.x - b;
        double y = a.y - b;
        double z = a.z - b;
        return new Vector3(x, y, z);
    }

    public static Vector3 mul(Vector3 a, Vector3 b)
    {
        double x = a.x * b.x;
        double y = a.y * b.y;
        double z = a.z * b.z;
        return new Vector3(x, y, z);
    }

    public static Vector3 mul(Vector3 a, double b)
    {
        double x = a.x * b;
        double y = a.y * b;
        double z = a.z * b;
        return new Vector3(x, y, z);
    }


    public Vector3 add(Vector3 b)
    {
        double x = this.x + b.x;
        double y = this.y + b.y;
        double z = this.z + b.z;
        return new Vector3(x, y, z);
    }

    public Vector3 add(double b)
    {
        double x = this.x + b;
        double y = this.y + b;
        double z = this.z + b;
        return new Vector3(x, y, z);
    }

    public Vector3 sub(Vector3 b)
    {
        double x = this.x - b.x;
        double y = this.y - b.y;
        double z = this.z - b.z;
        return new Vector3(x, y, z);
    }

    public Vector3 mul(double b)
    {
        double x = this.x * b;
        double y = this.y * b;
        double z = this.z * b;
        return new Vector3(x, y, z);
    }

    public Vector3 mul(Vector3 b)
    {
        double x = this.x * b.x;
        double y = this.y * b.x;
        double z = this.z * b.x;
        return new Vector3(x, y, z);
    }

    public Vector3 div(double b)
    {
        double x = this.x / b;
        double y = this.y / b;
        double z = this.z / b;
        return new Vector3(x, y, z);
    }

    public static Vector3 div(Vector3 a, double b)
    {
        double x = a.x / b;
        double y = a.y / b;
        double z = a.z / b;
        return new Vector3(x, y, z);
    }

    public static Vector3 mod(Vector3 a, double b)
    {
        double x = a.x % b;
        double y = a.y % b;
        double z = a.z % b;
        return new Vector3(x, y, z);
    }

    public double magnitudeSquared()
    {
        double x = this.x;
        double y = this.y;
        double z = this.z;
        return x*x+y*y+z*z;
    }

    public static double magnitudeSquared(Vector3 a)
    {
        double x = a.x;
        double y = a.y;
        double z = a.z;
        return x*x+y*y+z*z;
    }

    public double magnitude()
    {
        return Math.sqrt(this.magnitudeSquared());
    }

    public static  double magnitude(Vector3 a)
    {
        return Math.sqrt(magnitudeSquared(a));
    }

    public Vector3 normalize()
    {
        return this.div(this.magnitude());
    }

    public static Vector3 normalize(Vector3 a)
    {
        return div(a, magnitude(a));
    }

    public double dot(Vector3 b)
    {
        double x = this.x * b.x;
        double y = this.y * b.y;
        double z = this.z * b.z;
        return x + y + z;
    }

    public static double dot(Vector3 a,Vector3 b)
    {
        double x = a.x * b.x;
        double y = a.y * b.y;
        double z = a.z * b.z;
        return x + y + z;
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getZ()
    {
        return z;
    }

    public void setZ(double z)
    {
        this.z = z;
    }
}
