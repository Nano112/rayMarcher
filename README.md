# Very basic ray marching implementation

## Scene creation
### Scene is being rendered in the initialisation phase using the following setup:
The scene is rendered from a list of "World objects" and a single light source.
Each world object is created from combining primitives using booleans and displacing them using lambdas
For example a metaball would be created using the following:

    `WorldObject o1 = new Sphere(new Vector3(0,0,-100),12);`
    `WorldObject o2 = new Sphere(new Vector3(0,16,-100),8);`
    `WorldObject o3 = new CombinedObjects(o1,o2,1,false,false,false);`
    
And would yield the following:
    ![alt text](https://github.com/Nano112/rayMarcher/blob/master/examples/metaball.png?raw=true)
 
