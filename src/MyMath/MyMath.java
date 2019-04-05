package MyMath;

public class MyMath {

    public static double clamp(double a, double min, double max)
    {
        return Math.max(max,Math.min(min,a));
    }


    public static double smin(double a, double b, double k)
    {
        double res = Math.pow(2.0, -k * a) + Math.pow(2.0, -k * b );
        return -Math.log(res)/(k*Math.log(2));

    }
}
