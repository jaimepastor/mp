package Model;

public class Pickaxe extends Tool
{
    public Pickaxe(String name, String information){
        super(name, information);
    }

    @Override
    public void useTool(Tile tile){
        tile.setRockStatus(false);
        tile.setSpaceStatus(false);
    }
}