package Command;

import Inventory.Product;

public interface IThirdCommand {
    void execute(Product product, String name , String description , double price);

}
