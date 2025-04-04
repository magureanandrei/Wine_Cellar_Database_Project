package Models;

public class Wines implements HasID{
    public int wine_id;
    public String name;
    public int type_id;
    public int region_id;
    public int vintage_year;
    public int alcohol_percentage;
    public int supplier_id;

    public Wines(int wine_id, String name, int type_id, int region_id, int vintage_year, int alcohol_percentage, int supplier_id) {
        this.wine_id = wine_id;
        this.name = name;
        this.type_id = type_id;
        this.region_id = region_id;
        this.vintage_year = vintage_year;
        this.alcohol_percentage = alcohol_percentage;
        this.supplier_id = supplier_id;
    }

    public int getID() {
        return wine_id;
    }

    public void setWine_id(int wine_id) {
        this.wine_id = wine_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public int getVintage_year() {
        return vintage_year;
    }

    public void setVintage_year(int vintage_year) {
        this.vintage_year = vintage_year;
    }

    public int getAlcohol_percentage() {
        return alcohol_percentage;
    }

    public void setAlcohol_percentage(int alcohol_percentage) {
        this.alcohol_percentage = alcohol_percentage;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    @Override
    public String toString() {
        return "Wines{" +
                "wine_id=" + wine_id +
                ", name='" + name + '\'' +
                ", type_id=" + type_id +
                ", region_id=" + region_id +
                ", vintage_year='" + vintage_year + '\'' +
                ", alcohol_percentage='" + alcohol_percentage + '\'' +
                ", supplier_id=" + supplier_id +
                '}';
    }
}
