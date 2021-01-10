package MyMath.Vector;

public class Vector4
{
    //Half of this class is stupid and uses redundant code so it should be refactored
    private double x;
    private double y;
    private double z;
    private double w;

    public Vector4()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }
    public void print()
    {
        System.out.println("X: " + this.x + " Y: " + this.y + " Z: " + this.z + " W: " + this.w);
    }

    public Vector4(double x, double y, double z, double w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public double dist()
    {
        return Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z+this.w*this.w);
    }

    public static double dist(Vector4 a)
    {
        return Math.sqrt(a.x*a.x+a.y*a.y+a.z*a.z+a.w*a.w);
    }

    public static Vector4 abs(Vector4 a)
    {
        double x = Math.abs(a.x);
        double y = Math.abs(a.y);
        double z = Math.abs(a.z);
        double w = Math.abs(a.w);
        return new Vector4(x, y, z, w);
    }

    public static Vector4 max(Vector4 a, double b)
    {
        double x = Math.max(a.x,b);
        double y = Math.max(a.y,b);
        double z = Math.max(a.z,b);
        double w = Math.max(a.w,b);
        return new Vector4(x, y, z, w);
    }

    public static Vector4 min(Vector4 a, double b)
    {
        double x = Math.min(a.x,b);
        double y = Math.min(a.y,b);
        double z = Math.min(a.z,b);
        double w = Math.min(a.w,b);
        return new Vector4(x, y, z, w);
    }

    public static Vector4 add(Vector4 a, Vector4 b)
    {
        double x = a.x + b.x;
        double y = a.y + b.y;
        double z = a.z + b.z;
        double w = a.w + b.w;
        return new Vector4(x, y, z, w);
    }

    public static Vector4 add(Vector4 a, double b)
    {
        double x = a.x + b;
        double y = a.y + b;
        double z = a.z + b;
        double w = a.w + b;
        return new Vector4(x, y, z, w);
    }

    public static Vector4 sub(Vector4 a, Vector4 b)
    {
        double x = a.x - b.x;
        double y = a.y - b.y;
        double z = a.z - b.z;
        double w = a.w - b.w;
        return new Vector4(x, y, z, w);
    }

    public static Vector4 sub(Vector4 a, double b)
    {
        double x = a.x - b;
        double y = a.y - b;
        double z = a.z - b;
        double w = a.w - b;
        return new Vector4(x, y, z, w);
    }

    public static Vector4 mul(Vector4 a, Vector4 b)
    {
        double x = a.x * b.x;
        double y = a.y * b.y;
        double z = a.z * b.z;
        double w = a.w * b.w;
        return new Vector4(x, y, z, w);
    }

    public static Vector4 mul(Vector4 a, double b)
    {
        double x = a.x * b;
        double y = a.y * b;
        double z = a.z * b;
        double w = a.w * b;
        return new Vector4(x, y, z, w);
    }


    public Vector4 add(Vector4 b)
    {
        double x = this.x + b.x;
        double y = this.y + b.y;
        double z = this.z + b.z;
        double w = this.w + b.w;
        return new Vector4(x, y, z, w);
    }

    public Vector4 add(double b)
    {
        double x = this.x + b;
        double y = this.y + b;
        double z = this.z + b;
        double w = this.z + b;
        return new Vector4(x, y, z, w);
    }

    public Vector4 sub(Vector4 b)
    {
        double x = this.x - b.x;
        double y = this.y - b.y;
        double z = this.z - b.z;
        double w = this.w - b.w;
        return new Vector4(x, y, z, w);
    }

    public Vector4 mul(double b)
    {
        double x = this.x * b;
        double y = this.y * b;
        double z = this.z * b;
        double w = this.w * b;
        return new Vector4(x, y, z ,w);
    }

    public Vector4 mul(Vector4 b)
    {
        double x = this.x * b.x;
        double y = this.y * b.y;
        double z = this.z * b.z;
        double w = this.w * b.w;
        return new Vector4(x, y, z, w);
    }

    public Vector4 div(double b)
    {
        double x = this.x / b;
        double y = this.y / b;
        double z = this.z / b;
        double w = this.w / b;
        return new Vector4(x, y, z, w);
    }

    public static Vector4 div(Vector4 a, double b)
    {
        double x = a.x / b;
        double y = a.y / b;
        double z = a.z / b;
        double w = a.w / b;
        return new Vector4(x, y, z, w);
    }

    public static Vector4 mod(Vector4 a, double b)
    {
        double x = a.getX() % b;
        double y = a.getY() % b;
        double z = a.getZ() % b;
        double w = a.getW() % b;
        return new Vector4(x, y, z, w);
    }

    public double magnitudeSquared()
    {
        double x = this.x;
        double y = this.y;
        double z = this.z;
        double w = this.w;
        return x*x+y*y+z*z+w*w;
    }

    public static double magnitudeSquared(Vector4 a)
    {
        double x = a.x;
        double y = a.y;
        double z = a.z;
        double w = a.w;
        return x*x+y*y+z*z+w*w;
    }

    public double magnitude()
    {
        return Math.sqrt(this.magnitudeSquared());
    }

    public static double magnitude(Vector4 a)
    {
        return Math.sqrt(magnitudeSquared(a));
    }

    public Vector4 normalize()
    {
        return this.div(this.magnitude());
    }

    public static Vector4 normalize(Vector4 a)
    {
        return div(a, magnitude(a));
    }

    public double dot(Vector4 b)
    {
        double x = this.x * b.x;
        double y = this.y * b.y;
        double z = this.z * b.z;
        double w = this.w * b.w;
        return x + y + z + w;
    }

    public static double dot(Vector4 a,Vector4 b)
    {
        double x = a.x * b.x;
        double y = a.y * b.y;
        double z = a.z * b.z;
        double w = a.w * b.w;
        return x + y + z + w;
    }

    public double getX()
    {
        return this.x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return this.y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getZ()
    {
        return this.z;
    }

    public void setZ(double z)
    {
        this.z = z;
    }

    public double getW()
    {
        return this.w;
    }

    public void setW(double w)
    {
        this.w = w;
    }
}
