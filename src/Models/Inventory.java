package Models;

public class Inventory implements HasID{
    public int inventory_id;
    public int wine_id;
    public int location_id;
    public int quantity;
    public int bottle_size_ml;

    public Inventory(int inventory_id, int wine_id, int location_id, int quantity, int bottle_size_ml) {
        this.inventory_id = inventory_id;
        this.wine_id = wine_id;
        this.location_id = location_id;
        this.quantity = quantity;
        this.bottle_size_ml = bottle_size_ml;
    }

    public int getID() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getWine_id() {
        return wine_id;
    }

    public void setWine_id(int wine_id) {
        this.wine_id = wine_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBottle_size_ml() {
        return bottle_size_ml;
    }

    public void setBottle_size_ml(int bottle_size_ml) {
        this.bottle_size_ml = bottle_size_ml;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventory_id +
                ", wine_id=" + wine_id +
                ", location_id=" + location_id +
                ", quantity=" + quantity +
                ", bottle_size_ml=" + bottle_size_ml +
                '}';
    }
}
