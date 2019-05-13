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
            for (int i=0;i<360;++i)
            {
                Scene scene = setUpScene(i);
                long start = System.currentTimeMillis();
                Image image = scene.renderScene(300, 300, new Vector3(0, 15, 0), 60, 200, 0.01);
                long end = System.currentTimeMillis();
                System.out.println("Frame took " + (end - start) + "ms");
                image.save("frame_" + i);
            }



        }

        public static double getNoise(Vector3 p, Double time, Double amplitude,Double freq)
        {
            Double sum = 0.0;

            sum += noise(p.getX()/freq,p.getY()/freq, p.getZ()/freq , time/freq)*amplitude;
            sum += noise(p.getX()/freq*2,p.getY()/freq*2,p.getZ()/freq*2,time/freq*2)*amplitude/2;
            sum += noise(p.getX()/freq*4,p.getY()/freq*4, p.getZ()/freq*4, time/freq*4)*amplitude/4;
            sum += noise(p.getX()/freq*8,p.getY()/freq*8, p.getZ()/freq*8, time/freq*8)*amplitude/8;
            return sum;
        }


        public static Scene setUpScene(double t)
        {
            List<WorldObject> shapes = new ArrayList<>();
            LightSource light = new LightSource(new Vector3(0,100,-100),10000000);
            //shapes.add(new Plane(new Vector3(0,100,0), new Vector3(0,1,0) ));
            WorldObject o =new Plane(new Vector3(0,-100,0), new Vector3(0,-1,0) );
            //shapes.add(o);
            WorldObject o1 = new Sphere(new Vector3(0,10,-300),60);
            WorldObject o2 = new DisplacedObject(o1, (p) -> getNoise(p, t,12.0, 70.0));
            shapes.add(o2);
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
