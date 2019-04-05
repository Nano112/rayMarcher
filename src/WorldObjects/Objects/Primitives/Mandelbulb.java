package WorldObjects.Objects.Primitives;

import MyMath.Vector.Vector3;
import WorldObjects.Objects.WorldObject;

public class Mandelbulb extends WorldObject
{
    private int Iterations;
    private double Bailout;
    private double Power;
    public Mandelbulb(Vector3 position, int iterations, int bailout, double power)
    {
        super.position = position;
        this.Iterations = iterations;
        this.Bailout = bailout;
        this.Power = power;
    }
    @Override
    public double distance(Vector3 p)
    {
        Vector3 z = p;
        double dr = 1.0;
        double r = 0.0;
        for (int i = 0; i < Iterations ; i++) {
            r = z.dist();
            if (r>Bailout) break;

            // convert to polar coordinates
            double theta = Math.acos(z.getZ()/r);
            double phi = Math.atan(z.getY()/z.getX());
            dr =  Math.pow( r, Power-1.0)*Power*dr + 1.0;

            // scale and rotate the point
            double zr = Math.pow( r,Power);
            theta = theta*Power;
            phi = phi*Power;

            // convert back to cartesian coordinates
            z = new Vector3(Math.sin(theta)*Math.cos(phi),Math.sin(phi)*Math.sin(theta), Math.cos(theta)).mul(zr);
            z.add(p);
        }
        return 0.5*Math.log(r)*r/dr;
    }

}
