package Graphics;

import MyMath.Vector.Vector3;

public class Color
{
    private int r;
    private int g;
    private int b;

    public Color(int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void print()
    {
        System.out.println("R:"+this.r+" G:"+this.g+" B:"+this.b);
    }

    public int rgbToHex()
    {
        int hex = this.r;
        hex = (hex << 8) + this.g;
        hex = (hex << 8) + this.b;
        return hex;
    }

    public Vector3 toVec()
    {
        return new Vector3(this.r,this.g,this.b);
    }

    public int getR()
    {
        return r;
    }

    public void setR(int r)
    {
        this.r = r;
    }

    public int getG()
    {
        return g;
    }

    public void setG(int g)
    {
        this.g = g;
    }

    public int getB()
    {
        return b;
    }

    public void setB(int b)
    {
        this.b = b;
    }
}
