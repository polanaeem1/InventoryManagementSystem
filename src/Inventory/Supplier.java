package Inventory;


/**
 * This Class contains everything belongs to the Supplier
 */
public class Supplier {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * This Method sends order to the Inventory
     */
    public void sendOrder(){
        for (int i=0;i<Order.order.size();i++){
           Product product=(Product) Order.order.get(i);
            Inventory.container.add(product);
        }
        Order.order.clear();
    }
}
