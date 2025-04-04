package Models;

public class Transactions implements HasID{
    public int transaction_id;
    public int wine_id;
    public String transaction_type;
    public String date;
    public int quantity;
    public int price_per_bottle;
    public int user_id;

    public Transactions (int transaction_id, int wine_id, String transaction_type, String date, int quantity, int price_per_bottle, int user_id) {
        this.transaction_id = transaction_id;
        this.wine_id = wine_id;
        this.transaction_type = transaction_type;
        this.date = date;
        this.quantity = quantity;
        this.price_per_bottle = price_per_bottle;
        this.user_id = user_id;
    }



    public int getID() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getWine_id() {
        return wine_id;
    }

    public void setWine_id(int wine_id) {
        this.wine_id = wine_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice_per_bottle() {
        return price_per_bottle;
    }

    public void setPrice_per_bottle(int price_per_bottle) {
        this.price_per_bottle = price_per_bottle;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transaction_id=" + transaction_id +
                ", wine_id=" + wine_id +
                ", transaction_type='" + transaction_type + '\'' +
                ", date='" + date + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price_per_bottle='" + price_per_bottle + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
