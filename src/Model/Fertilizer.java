package Model;

public class Fertilizer extends Tool {

    public Fertilizer(String name, String information){
        super(name, information);
    }

    @Override
    public void useTool(Tile tile) {
        if(tile.getHeldCrop().getNoOfFertilizes() < tile.getHeldCrop().getFertilizerNeeded())
            tile.getHeldCrop().setNoOfFertilizes(tile.getHeldCrop().getNoOfFertilizes() + 1);
    }
}
