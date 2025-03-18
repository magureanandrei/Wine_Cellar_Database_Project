package Models;

public class Wines {
    private int wine_id;
    private String name;
    private int type_id;
    private int region_id;
    private String vintage_year;
    private String alcohol_percentage;
    private int supplier_id;

    public Wines(int wine_id, String name, int type_id, int region_id, String vintage_year, String alcohol_percentage, int supplier_id) {
        this.wine_id = wine_id;
        this.name = name;
        this.type_id = type_id;
        this.region_id = region_id;
        this.vintage_year = vintage_year;
        this.alcohol_percentage = alcohol_percentage;
        this.supplier_id = supplier_id;
    }

    public int getWine_id() {
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

    public String getVintage_year() {
        return vintage_year;
    }

    public void setVintage_year(String vintage_year) {
        this.vintage_year = vintage_year;
    }

    public String getAlcohol_percentage() {
        return alcohol_percentage;
    }

    public void setAlcohol_percentage(String alcohol_percentage) {
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
