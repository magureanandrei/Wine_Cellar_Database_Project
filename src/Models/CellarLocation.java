package Models;

public class CellarLocation implements HasID{
    public int location_id;
    public String section;
    public int rack_number;
    public int bottle_position;

    public CellarLocation(int location_id, String section, int rack_number, int bottle_position) {
        this.location_id = location_id;
        this.section = section;
        this.rack_number = rack_number;
        this.bottle_position = bottle_position;
    }

    public int getID() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getRack_number() {
        return rack_number;
    }

    public void setRack_number(int rack_number) {
        this.rack_number = rack_number;
    }

    public int getBottle_position() {
        return bottle_position;
    }

    public void setBottle_position(int bottle_position) {
        this.bottle_position = bottle_position;
    }

    @Override
    public String toString() {
        return "CellarLocation{" +
                "location_id=" + location_id +
                ", section='" + section + '\'' +
                ", rack_number='" + rack_number + '\'' +
                ", bottle_position='" + bottle_position + '\'' +
                '}';
    }
}
