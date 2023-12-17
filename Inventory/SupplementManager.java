package Inventory;

import Inventory.Order;
import Inventory.Product;

/**
 * This Class contains everything belongs to the Supplement Manager
 */
public class SupplementManager {
    private String UserName;
    private String Password;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }



    public void setPassword(String password) {
        Password = password;
    }

    /**
     * This Method sends the required products to Supplier
     *
     * @param product This is the product required from supplier which Inventory needs
     */
    public void orderFromSupplier(Product product){
        Order.order.add(product);
    }


}
