package Model;

public class WateringCan extends Tool
{
    public WateringCan(String name, String information){
        super(name, information);
    }

    @Override
    public void useTool(Tile tile){
        tile.setWaterStatus(true);
        tile.getHeldCrop().setNoOfWaters(tile.getHeldCrop().getNoOfWaters() + 1);
    }
}