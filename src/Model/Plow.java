package Model;

public class Plow extends Tool
{
    public Plow(String name, String information){
        super(name, information);
    }

    @Override
    public void useTool(Tile tile){
        if(tile.getSpaceStatus() == false)//if tile has no plant inside
            if(tile.getRockStatus() == false)//if tile has no rock inside
                if(tile.getPlowStatus() == false)//if tile is not plowed
                    tile.setPlowStatus(true);
                else if(tile.getPlowStatus() == true)//if tile is plowed
                    System.out.println("plowed na gago");
            else if(tile.getRockStatus() == true)//if tile has rock
                System.out.println("may rock gago");
        else if(tile.getSpaceStatus() == true)//if tile has a plant inside
            if(tile.getWitherStatus() == false)//if tile has not withered yet
                if(tile.getHeldCrop().getHarvestTime() >= 0) {//if crop can still be harvested
                    System.out.print("harvested with products");
                    //remove crop
                    //get produce
                    //sell
                    //set tile space status to false
                }
            else if(tile.getWitherStatus() == true);{
                System.out.print("harvested without products");
                //get nothing in return
                //decrease OC by 10% of SeedCost
                //set tile space status to false
        }
    }
}