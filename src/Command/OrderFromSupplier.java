package Command;

import Inventory.Product;
import Inventory.SupplementManager;
/**
 * This Class contains everything belongs to the OrderFromSupplier
 */
public class OrderFromSupplier implements ISecondCommand {


    /**
     * This Method will execute Order From Supplier Method
     *
     * @param product The Product that will be ordered
     */
    public void execute(Product product) {
        SupplementManager supplementManager=new SupplementManager();
        supplementManager.orderFromSupplier(product);
    }
}
