package Command;

import Inventory.Product;
import Inventory.Staff;

/**
 * This Class contains everything belongs to the AddCommand
 */
public class AddCommand implements ISecondCommand{

    /**
     * This Method will execute Add Method
     *
     * @param product the Product that will be added
     */
    @Override
    public void execute(Product product) {
        Staff staff=new Staff();
        staff.add(product);
    }
}
