package Inventory;

/**
 * This Class contains everything belongs to the Product
 */

public class Product {
    private String name;
    private String ID;
    private String description;
    private double price;
    private int quantity;
    public  Product(String name,String ID,String description,double price,int quantity){
        this.name=name;
        this.ID=ID;
        this.description=description;
        this.price=price;
        this.quantity=quantity;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * This Method prints Product's Details
     *
     * @return This returns Text that includes Product's Details
     */
    public String toString() {
        return "Product{" + "Name=" + name + ", id=" + ID + ", description=" + description + ", quantity=" + quantity + ", price=" + price + '}';
    }


}
