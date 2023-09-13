public class Biome {
    //TODO: think up potential contained data for a biome
    String type;
    String[] animals;
    int population; // generated depending on incoming populated variable(enum? multiplier? "populationScale log scale?")
    enum WaterLevel{
        LAND(-1, 1, new String[]{"cow"}), //TODO: change animals to a type and create a static list using json and read the list of different animal types based on biome/water level, have "underwater desert, and coastal jungle, etc"
        COASTAL(0, 2, new String[]{"walrus"}),
        OCEANIC(1, 0, new String[]{"manatee"});
        public final int state;
        public final double popEffect;
        public final String[] animals;
        private WaterLevel(int state, double popEffect, String[] animals){
            this.state = state;
            this.popEffect = popEffect;
            this.animals = animals;
        }
    }
    String waterLevel;

        //if height is within sea level by certain margin, then "partially underwater"? or maybe depending on whether there are adjacent above water tiles?
            //this could be applied during sanity check


    public Biome(String type, int population, WaterLevel waterLevel){
        this.type = type;
        this.animals = waterLevel.animals;
        this.waterLevel = waterLevel.toString();
        this.population = (int) Math.floor(population * waterLevel.popEffect);
    }
}
