import Graphics.Image;
import MyMath.Vector.Vector3;
import WorldObjects.LightSource;
import WorldObjects.Objects.Sphere;
import WorldObjects.Objects.WorldObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


        public static void main(String[] args) throws IOException
        {

            Scene scene = setUpScene();
            Image image = scene.renderScene(1024,1024,new Vector3(0,0,0),60,0.01);
            image.save("frame");


        }

        public static Scene setUpScene()
        {

            int wallSize = 40000;
            List<WorldObject> shapes = new ArrayList<WorldObject>();
            LightSource light = new LightSource(new Vector3(100*(double)Math.sin(0),100,-100+100*(double)Math.cos(0)),10000000);

            shapes.add(new Sphere(new Vector3(0,0,-80), 10 ));

            Scene scene = new Scene(shapes, light);
            return scene;
        }






}
