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

        Vector3 position = super.position.sub(p);
        //System.out.println(p.getX()+" "+p.getY()+" "+p.getZ());
        Vector3 z = position;
        //System.out.println(z.getX()+" "+z.getY()+" "+z.getZ());
        double dr = 1.0;
        double r = 0.0;
        for (int i = 0; i < this.Iterations ; i++) {
            r = z.dist();
            if (r>this.Bailout) break;

            // convert to polar coordinates
            double theta = Math.acos(z.getZ()/r);
            double phi = Math.atan2(z.getY(),z.getX());
            dr =  Math.pow( r, this.Power-1.0)*this.Power*dr + 1.0;

            // scale and rotate the point
            double zr = Math.pow( r,this.Power);
            theta = theta*this.Power;
            phi = phi*this.Power;

            // convert back to cartesian coordinates
            z = new Vector3(Math.sin(theta)*Math.cos(phi),Math.sin(phi)*Math.sin(theta), Math.cos(theta)).mul(zr);
            z = z.add(position);
        }
        double distance = 0.5*Math.log(r)*r/dr;
        //System.out.println(r +" " +distance);

        return distance;
    }

}
