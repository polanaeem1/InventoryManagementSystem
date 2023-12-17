package Inventory;

import Inventory.Product;

import java.util.ArrayList;

/**
 * This Class contains everything belongs to the Order
 */
public class Order {
    public static ArrayList<Product> order = new ArrayList<>();

    public ArrayList<Product> getOrder() {
        return order;
    }

}
