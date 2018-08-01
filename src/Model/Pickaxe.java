package Model;

public class Pickaxe extends Tool
{
    public Pickaxe(String information){
        super(information);
    }

    @Override
    public void useTool(Tile tile){
        tile.setRockStatus(false);
        tile.setSpaceStatus(false);
    }

    @Override
    public void displayInfo(){
        System.out.println(this.getInformation());
    }
}