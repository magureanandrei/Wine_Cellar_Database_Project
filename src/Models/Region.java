package Models;

public class Region implements HasID{
    public int region_id;
    public String region_name;
    public String country;

    public Region(int region_id, String region_name, String country) {
        this.region_id = region_id;
        this.region_name = region_name;
        this.country = country;
    }

    public int getID() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Region{" +
                "region_id=" + region_id +
                ", region_name='" + region_name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
