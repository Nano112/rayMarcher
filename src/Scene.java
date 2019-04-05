import Graphics.Color;
import Graphics.Image;
import MyMath.DistanceInformation;
import MyMath.Ray;
import MyMath.Vector.Vector3;
import WorldObjects.LightSource;
import WorldObjects.Objects.WorldObject;

import java.util.List;

public class Scene {

    private LightSource light;
    private List<WorldObject> objects;



    public Scene(List<WorldObject> o, LightSource light)
    {
        this.objects = o;
        this.light = light;
    }

    public Vector3 getNormal(Vector3 p, double epsilon)
    {
        return Vector3.normalize(new Vector3(
                getSceneDist(new Vector3(p.getX()+epsilon,p.getY(),p.getZ())).getDistance() - getSceneDist(new Vector3(p.getX()-epsilon,p.getY(),p.getZ())).getDistance(),
                getSceneDist(new Vector3(p.getX(),p.getY()+epsilon,p.getZ())).getDistance() - getSceneDist(new Vector3(p.getX(),p.getY()-epsilon,p.getZ())).getDistance(),
                getSceneDist(new Vector3(p.getX(),p.getY(),p.getZ()+epsilon)).getDistance() - getSceneDist(new Vector3(p.getX(),p.getY(),p.getZ()-epsilon)).getDistance())
        );
    }


    public DistanceInformation marchRay(Vector3 cameraPosition, Vector3 viewDirection ,int maxStepNumber, double epislon)
    {
        double depth = 0;
        for (int i = 0; i < maxStepNumber; ++ i)
        {
            DistanceInformation distInf = getSceneDist(Vector3.add(cameraPosition, Vector3.mul(viewDirection, depth)));

            if( distInf.getDistance() < epislon)
            {
                distInf.setDistance(depth);
                return distInf;
            }
            depth += distInf.getDistance();
            if(distInf.getObjectID() == -1)
            {
                return new DistanceInformation();
            }
        }
        return new DistanceInformation();
    }



    public DistanceInformation getSceneDist(Vector3 position)
    {
        DistanceInformation distInf = new DistanceInformation();
        for ( int i = 0; i < this.objects.size(); ++i)
        {
            double objectDistance = this.objects.get(i).distance(position);
            //System.out.println(objectDistance);
            if (distInf.getDistance() > objectDistance)
            {
                distInf.setDistance(objectDistance);
                distInf.setObjectID(i);
            }
        }
        return distInf;
    }


    public double getShade(Vector3 p, double epsilon)
    {
        Vector3 lightVector = Vector3.normalize(Vector3.sub(light.getPosition(),p));
        return Vector3.dot(lightVector, getNormal(p,epsilon));
    }

    public Image renderScene(int width, int height,Vector3 cameraPos, double fov,int maxSteps, double epsilon)
    {

        long start = System.currentTimeMillis();
        fov = fov * Math.PI / 180;
        Image image = new Image(width, height);
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                Vector3 direction = new Vector3(x - width / 2f, y - height / 2f, -width / (2 * Math.tan(fov / 2))).normalize();
                Ray ray = new Ray(new Vector3(0, 0 ,0), direction );
                DistanceInformation di = marchRay(cameraPos,direction,maxSteps,epsilon);
                Vector3 position = Vector3.add(cameraPos,Vector3.mul(direction,di.getDistance()));
                if(di.getDistance() != Double.MAX_VALUE)
                {
                    Color color;
                    if(true) {//Print Normal Map
                        Vector3 normal = getNormal(position, epsilon);
                        normal = normal.add(1.0);
                        normal = normal.div(2);
                        color = new Color((int) (255 * normal.getX()), (int) (255 * normal.getY()), (int) (255 * normal.getZ()));
                    }
                    else
                    {
                        double intensity = getShade(position,epsilon);
                        if(intensity < 0)
                        {
                            intensity = 0;
                        }
                        color = new Color((int)(255 * intensity),(int)(255 * intensity),(int)(255 * intensity));
                    }
                    image.setPixel(x, height-y-1,color );
                }

            }
        }
        return image;
    }
}
