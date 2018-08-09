package Model;

import Controller.GameController;

public class Pickaxe extends Tool
{
    public Pickaxe(String name, String information){
        super(name, information);
    }

    @Override
    public void useTool(Tile tile, GameController gc){
        tile.setRockStatus(false);
        tile.setSpaceStatus(true);
        gc.changeTile(tile.getCoordinate(), "pickaxe");
    }
}