package Model;

public abstract class Tool
{
    private String information;
    private String name;

    public Tool(String name, String information){
        this.information = information;
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public String getName() {
        return name;
    }

    public abstract void useTool(Tile tile);

    public abstract void displayInfo();
}