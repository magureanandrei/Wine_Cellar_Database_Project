package Models;

public class WineType implements HasID{
    public int wineType_id;
    public String name;

    public WineType(int wineType_id, String name) {
        this.wineType_id = wineType_id;
        this.name = name;
    }

    public int getID() {
        return wineType_id;
    }

    public void setWineType_id(int wineType_id) {
        this.wineType_id = wineType_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WineType{" +
                "wineType_id=" + wineType_id +
                ", name='" + name + '\'' +
                '}';
    }
}
