import Graphics.Image;
import MyMath.OpenSimplexNoise.Noise;
import MyMath.Vector.Vector3;
import WorldObjects.LightSource;
import WorldObjects.Objects.Primitives.*;
import WorldObjects.Objects.WorldObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static MyMath.OpenSimplexNoise.SimplexNoise.noise;

public class Main {
 public static void main(String[] args) throws IOException
        {
                Scene scene = setUpScene(0);
                long start = System.currentTimeMillis();
                Image image = scene.renderScene(400, 400, new Vector3(0, 15, 0), 60, 2000, 0.1);
                long end = System.currentTimeMillis();
                System.out.println("Frame took " + (end - start) + "ms");
                image.save("frame_" + 0);
        }

        public static double getNoise(Vector3 p, Double amplitude,Double freq)
        {
            Double sum = 0.0;
            for (int i = 0 ; i < 8 ; ++i)
            {
                sum += noise(p.getX()/freq*Math.pow(2,i),p.getY()/freq*Math.pow(2,i),p.getZ()/freq*Math.pow(2,i))*amplitude/Math.pow(2,i);
            }
            return sum;
        }



        public static Scene setUpScene(double t)
        {
            List<WorldObject> shapes = new ArrayList<>();
            LightSource light = new LightSource(new Vector3(0,20,-100),10000000);
            //shapes.add(new Plane(new Vector3(0,100,0), new Vector3(0,1,0) ));
            WorldObject o =new Sphere(new Vector3(0,0,-300), 100 );
            WorldObject o1 = new DisplacedObject(o, (p) -> getNoise(p, 30.0, 300.0));
            shapes.add(o1);
            //shapes.add(o3);
            //shapes.add(new CombinedObjects(o2, o3,0.2,false,false,false));
            //shapes.add(new Plane(new Vector3(-100,0,0), new Vector3(-1,0,0) ));
            //shapes.add(new Plane(new Vector3(100,0,0), new Vector3(1,0,0) ));
            //shapes.add(new Plane(new Vector3(0,0,-2000), new Vector3(0,0,1) ));//TOO DO DE PLANE IS BROKEN
            //shapes.add(new Plane(new Vector3(0,0,100), new Vector3(0,0,1) ));
            //WorldObject s0 = new Sphere(new Vector3(0,0,-100),20);
            //WorldObject o0 = new DisplacedObject(s0,(p) -> noise(p.getX()/10,p.getY()/10,p.getZ()/10,t/60)*5);
            //WorldObject s1 = new Sphere(new Vector3(20*Math.cos(Math.PI*t/180),20*Math.sin(Math.PI*t/180),-100),20);
            //WorldObject o1 = new DisplacedObject(s1,(p) -> noise(p.getX()/10,p.getY()/10,p.getZ()/10,t/60)*5);
            //WorldObject c0 = new CombinedObjects(o0,o1,1,true,false,false);
            //WorldObject o1 = new Sphere(new Vector3(0,0,-100),12);
            //WorldObject o2 = new Sphere(new Vector3(0,16,-100),8);
            //WorldObject o3 = new CombinedObjects(o1,o2,1,false,false,false);
            //WorldObject o4 = new CombinedObjects(o0,o3,1,false,false,false);
            //shapes.add(c0);
            Scene scene = new Scene(shapes, light);
            return scene;
        }






}
