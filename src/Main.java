import Graphics.Image;
import MyMath.Vector.Vector3;
import WorldObjects.LightSource;
import WorldObjects.Objects.Primitives.*;
import WorldObjects.Objects.WorldObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


        public static void main(String[] args) throws IOException
        {

                Scene scene = setUpScene();
                long start = System.currentTimeMillis();
                Image image = scene.renderScene(1920, 1080, new Vector3(0, 15, 0), 60, 2000, 0.001);
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
            WorldObject o1 = new Mandelbulb(new Vector3(0,0,-80),100,)
            shapes.add(o5);

            Scene scene = new Scene(shapes, light);
            return scene;
        }






}
