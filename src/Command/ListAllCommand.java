package Command;

import Inventory.Staff;
/**
 * This Class contains everything belongs to the ListAllCommand
 */
public class ListAllCommand implements ICommand{

    /**
     * This Method will execute ListAll Method
     */
    @Override
    public void execute() {
        Staff staff=new Staff();
        staff.listAll();
    }
}
