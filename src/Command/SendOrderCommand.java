package Command;

import Inventory.Order;
import Inventory.Supplier;

import javax.swing.*;

/**
 * This Class contains everything belongs to the SendOrderCommand
 */
public class SendOrderCommand  implements ICommand {


    /**
     * This Method will execute SendOrder Method
     */
    @Override
    public void execute() {
        Supplier supplier=new Supplier();
        if (Order.order.size()==0){
            JOptionPane.showMessageDialog(null,"There is no Order","There is no Order",JOptionPane.ERROR_MESSAGE);
        }else{
            supplier.sendOrder();
        }
    }
}
