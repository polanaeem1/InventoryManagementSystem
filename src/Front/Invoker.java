package Front;

import Command.ICommand;
import Command.ISecondCommand;
import Command.IThirdCommand;
import Inventory.Product;

public class Invoker {

    public void execute(ICommand command){
    command.execute();
    };
    public void execute(ISecondCommand command, Product product){
        command.execute(product);
    };
    public void execute(IThirdCommand command, Product product, String name , String description , double price){
        command.execute(product,name,description,price);
    };
}
