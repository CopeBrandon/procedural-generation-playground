import java.util.ArrayList;

public class VertexGenerator {
    int seaLevel = 0;
    int graphSize = 100;
    int heightMax = 10;
    public VertexGenerator(){}
    public VertexGenerator(int seaLevel, int graphSize, int heightMax){
        this.seaLevel = seaLevel;
        this.graphSize = graphSize;
        this.heightMax = heightMax;
    }
    //TODO: generate vertices based on nearby vertex
    public Vertex[][] generateList(){
        //TODO: create list of types of biomes for now this will be a placeholder biome type
        Vertex[][] arr = new Vertex[graphSize][graphSize];
        //FOR LOOP GENERATE size graphSize send in parent
        for(int i=0; i<graphSize; i++){
            for(int j=0; j<graphSize; j++){
                arr[i][j] = generate(i, j, arr);
            }
        }
        return arr;
    }
    private Vertex generate(int y, int x, Vertex[][] arr){
        //todo: generate random pop based on biome type but for now we will randomize within a value of like 0-100000 or something
        int pop = (int)Math.floor(Math.random() * 100001);
        Biome biome = new Biome("temperate forest", pop, generateWaterLevel());//string int and waterlevel

        Vertex vertex = new Vertex(new int[]{x, y}, biome);//needs to add itself to the list of vertices to the left and above

        //Adds self to adjacent vertices so that they can recall what is near them.
        for(int i=-1; i<2; i++){
            //go up 1, add self to y
            if(y > 1 && x > 1 && x + i < arr[y].length) {
                arr[y - 1][x + i].addAdjacentVertex(vertex);
            }
        }
        if(x > 1){
            arr[y][x-1].addAdjacentVertex(vertex);
        }
        return vertex;
    }
    private Biome.WaterLevel generateWaterLevel(){
        int rand = (int) Math.floor(Math.random() * 3);
        switch(rand){
            case 0: return Biome.WaterLevel.LAND;
            case 1: return Biome.WaterLevel.COASTAL;
            default:return Biome.WaterLevel.OCEANIC;
        }
    }
}
