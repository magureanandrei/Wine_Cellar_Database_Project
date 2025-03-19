package Models;

public class Supplier implements HasID{
    public int supplier_id;
    public String supplier_name;
    public String contact_email;
    public String phone;
    public String address;

    public Supplier(int supplier_id, String supplier_name, String contact_email, String phone, String address) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.contact_email = contact_email;
        this.phone = phone;
        this.address = address;
    }

    public int getID() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplier_id=" + supplier_id +
                ", supplier_name='" + supplier_name + '\'' +
                ", contact_email='" + contact_email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
