package MyMath;

public class MyMath {

    public static double clamp(double a, double min, double max)
    {
        return Math.min(max,Math.max(min,a));
    }


    public static double smin(double a, double b, double k)
    {
        double res = Math.pow(2.0, -k * a) + Math.pow(2.0, -k * b );
        return -Math.log(res)/(k*Math.log(2));
    }

    public static double sigm(double a)
    {
        return 1/(1+Math.exp(-a));
    }
}
