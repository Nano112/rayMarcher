import Graphics.Color;
import Graphics.Image;
import MyMath.DistanceInformation;
import MyMath.MyMath;
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
        DistanceInformation distInf = new DistanceInformation();
        double minDist = Double.MAX_VALUE;
        for (int i = 0; i < maxStepNumber; ++ i)
        {
            distInf = getSceneDist(Vector3.add(cameraPosition, Vector3.mul(viewDirection, depth)));
            if ( distInf.getDistance() < minDist)
                minDist = distInf.getDistance();


            if( distInf.getDistance() < epislon)
            {
                distInf.setDistance(depth);
                distInf.setSteps(i);
                break;
            }

            depth += distInf.getDistance();

            if(distInf.getObjectID() == -1)
            {
                 distInf.setDistance(Double.MAX_VALUE);
                 break;
            }
        }
        distInf.setMinDist(minDist);
        return distInf;
    }



    public DistanceInformation getSceneDist(Vector3 position)
    {
        DistanceInformation distInf = new DistanceInformation();
        double objectDistance;
        for ( int i = 0; i < this.objects.size(); ++i)
        {
             objectDistance = this.objects.get(i).distance(position);
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
        Ray ray = new Ray(new Vector3(0, 0 ,0), new Vector3(0,0,0) );
        Vector3 direction = new Vector3(0 - (width >>1), 0 - (height >> 1), -width / (Math.tan(fov /2) *2)).normalize();
        double zTan =   1/(Math.tan(fov /2) *2);
        for (int x = 0; x < width; ++x) {
            //System.out.println(x);
            for (int y = 0; y < height; ++y) {
                direction.setX(x - (width >>1));
                direction.setY(y - (height >> 1));
                direction.setZ(-width * zTan);
                direction = direction.normalize();
                ray.setPosition(cameraPos);
                ray.setDirection(direction);
                DistanceInformation di = marchRay(cameraPos,direction,maxSteps,epsilon);
                Vector3 position = Vector3.add(cameraPos,Vector3.mul(direction,di.getDistance()));

                Color color = new Color(0,0,0);
                if(di.getDistance() != Double.MAX_VALUE)
                {
                    if(false) {//Print Normal Map
                        Vector3 normal = getNormal(position, epsilon);
                        normal = normal.add(1.0);
                        normal = normal.div(2);
                        color.setR((int) (255 * normal.getX()));
                        color.setG((int) (255 * normal.getY()));
                        color.setB((int) (255 * normal.getZ()));
                    }
                    else if(true)
                    {
                        double intensity = getShade(position,epsilon);
                        if(intensity < 0)
                        {
                            intensity = 0;
                        }
                        color.setR((int) (255 * intensity));
                        color.setG((int) (255 * intensity));
                        color.setB((int) (255 * intensity));
                    }
                }

                if(di.getMinDist() < 25.5 && false)
                {
                    color.setR((int)MyMath.clamp(color.getR()*(255-(di.getMinDist()*10)),0,255));
                    color.setG((int)MyMath.clamp(color.getG()+0,0,255));
                    color.setB((int)MyMath.clamp(color.getB()+0,0,255));
                }
                image.setPixel(x, height-y-1,color );
            }
        }
        return image;
    }
}
