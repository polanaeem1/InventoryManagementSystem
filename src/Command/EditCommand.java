package Command;

import Inventory.Product;
import Inventory.Staff;
/**
 * This Class contains everything belongs to the EditCommand
 */
public class EditCommand implements IThirdCommand{

    /**
     * This Method will execute Edit Method
     *
     * @param product The Product that will be edited
     * @param name The new name of the product
     * @param description The new description of the product
     * @param price The new price of the product
     */
    @Override
    public void execute(Product product, String name, String description, double price) {
        Staff staff=new Staff();
        staff.edit(product,name,description,price);

    }
}
