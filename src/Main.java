import Graphics.Image;
import MyMath.Vector.Vector3;
import WorldObjects.LightSource;
import WorldObjects.Objects.Primitives.Box;
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
            Image image = scene.renderScene(1920,1080,new Vector3(0,0,0),60,100, 0.001);
            long end = System.currentTimeMillis();
            System.out.println("Frame took " + (end - start) + "ms");
            image.save("frame");


        }

        public static Scene setUpScene()
        {

            int wallSize = 40000;
            List<WorldObject> shapes = new ArrayList<WorldObject>();
            LightSource light = new LightSource(new Vector3(100* Math.sin(0),100,-100+100* Math.cos(0)),10000000);

            shapes.add(new Box(new Vector3(0,0,-80), new Vector3(10,10,10) ));

            Scene scene = new Scene(shapes, light);
            return scene;
        }






}
