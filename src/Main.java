import Graphics.Image;
import MyMath.Vector.Vector3;
import WorldObjects.LightSource;
import WorldObjects.Objects.Primitives.Box;
import WorldObjects.Objects.Primitives.CombinedObjects;
import WorldObjects.Objects.Primitives.Plane;
import WorldObjects.Objects.Primitives.Sphere;
import WorldObjects.Objects.WorldObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


        public static void main(String[] args) throws IOException
        {

                Scene scene = setUpScene();
                long start = System.currentTimeMillis();
                Image image = scene.renderScene(300, 300, new Vector3(0, 15, 0), 60, 300, 0.01);
                long end = System.currentTimeMillis();
                System.out.println("Frame took " + (end - start) + "ms");
                image.save("frame_");


        }

        public static Scene setUpScene()
        {

            int wallSize = 40000;
            List<WorldObject> shapes = new ArrayList<WorldObject>();
            LightSource light = new LightSource(new Vector3(100* Math.sin(0),100,-100+100* Math.cos(0)),10000000);

            shapes.add(new Plane(new Vector3(0,-20,-80), new Vector3(0,-1,0) ));
            shapes.add(new Plane(new Vector3(0,100,-80), new Vector3(0,1,0) ));
            WorldObject o1 = new Box(new Vector3(0,0,-40), new Vector3(10,10,10) );
            WorldObject o2 = new Sphere(new Vector3(0,15,-40), 10 );
            WorldObject o3 = new CombinedObjects(o1,o2,0.5,false,false,false);
            WorldObject o4 = new Sphere(new Vector3(10,15,-40), 10 );
            WorldObject o5 = new CombinedObjects(o3,o4,0.5,false,false,false);

            shapes.add(o5);

            Scene scene = new Scene(shapes, light);
            return scene;
        }






}
