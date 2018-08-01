package Model;

public abstract class Tool
{
    private String information;

    public Tool(String information){
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public abstract void useTool(Tile tile);

    public abstract void displayInfo();
}