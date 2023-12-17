package Command;

import Inventory.Product;
import Inventory.Staff;

import javax.swing.*;
/**
 * This Class contains everything belongs to the DeleteCommand
 */
public class DeleteCommand implements ISecondCommand{
    /**
     * This Method will execute Delete Method
     *
     * @param product The product that will be deleted
     */
    @Override
    public void execute(Product product) {
        Staff staff=new Staff();
        if (product==null){
            JOptionPane.showMessageDialog(null,"The Product is not Found","The Product is not Found",JOptionPane.ERROR_MESSAGE);
        }else{
            staff.delete(product.getID());
        }
    }
}
