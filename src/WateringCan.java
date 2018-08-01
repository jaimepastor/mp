public class WateringCan extends Tool
{
    public WateringCan(String information){
        super(information);
    }

    @Override
    public void useTool(Tile tile){
        tile.setWaterStatus(true);
        tile.getHeldCrop().setNoOfWaters(tile.getHeldCrop().getNoOfWaters() + 1);
    }

    @Override
    public void displayInfo(){
        System.out.println(this.getInformation());
    }
}