package Models;

public class CellarLocation {
    private int location_id;
    private String section;
    private String rack_number;
    private String bottle_position;

    public CellarLocation(int location_id, String section, String rack_number, String bottle_position) {
        this.location_id = location_id;
        this.section = section;
        this.rack_number = rack_number;
        this.bottle_position = bottle_position;
    }

    public int getLocation_id() {
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

    public String getRack_number() {
        return rack_number;
    }

    public void setRack_number(String rack_number) {
        this.rack_number = rack_number;
    }

    public String getBottle_position() {
        return bottle_position;
    }

    public void setBottle_position(String bottle_position) {
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
