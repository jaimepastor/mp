public class Fertilizer extends Tool {

    public Fertilizer(String information){
        super(information);
    }

    @Override
    public void useTool(Tile tile) {
        tile.getHeldCrop().setNoOfFertilizes(tile.getHeldCrop().getNoOfFertilizes() + 1);
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getInformation());
    }
}
