public class Main {
    public static void main(String[] args) {
        int seaLevel = 0;
        int graphSize = 3;
        int heightMax = 10;
        VertexGenerator vertexGenerator = new VertexGenerator(seaLevel, graphSize, heightMax);
        Vertex[][] vertices = vertexGenerator.generateList();
        graphPrinter(vertices, graphSize);


    }
    public static void graphPrinter(Vertex[][] vertices, int graphSize){
        for(int i=0; i<graphSize; i++){
            for(int j=0; j<graphSize; j++){
            }
            for(int j=0; j<graphSize; j++){
                System.out.print(vertices[i][j] + " | ");
            }
            System.out.println();
        }
    }
}