package WorldObjects;

import MyMath.Vector.Vector3;

public class LightSource
{
    private Vector3 position;
    private int intensity;

    public LightSource(Vector3 position, int intensity)
    {
        this.position = position;
        this.intensity = intensity;
    }


    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
