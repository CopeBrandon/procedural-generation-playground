import java.util.ArrayList;
import java.util.Arrays;

public class Vertex {
    int[] position;
    ArrayList<Vertex> adjacentVertex = new ArrayList<>();
    Biome biome;
    public Vertex(int[] position, Biome biome){
        this.position = position; // position is (x,y,z) where position is south, east, up
        this.biome = biome;
    }
    public void addAdjacentVertex(Vertex vertex){
        if (adjacentVertex.size() >= 6){
            Error e = new Error("" + this.position.toString() + " has too many vertices.");
            throw e;
        } else if(adjacentVertex.contains(vertex)) {
            Error e = new Error("" + this.position.toString() + " already has vertex " + vertex.position.toString() + " inside its adjacent array.");
            throw e;
        } else {
            adjacentVertex.add(vertex);
        }
    }

    @Override
    public String toString() {
        return "Vertex{" + Arrays.toString(position) + " biome: " + biome.type + " waterlevel: " + biome.waterLevel + "}";
    }
}
