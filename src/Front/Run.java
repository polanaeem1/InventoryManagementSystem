package Front;

import Command.*;
import Data.Data;
import Inventory.Product;
import Inventory.Staff;

import javax.swing.*;

/**
 * This Class contains everything belongs to the UI
 */
public class Run {
    static String namePattern = "^[a-zA-Z ]*$";
    static Invoker worker= new Invoker();
    static void run(){
        while (true){
            String[][]  options={{"Staff","Supplement Manager", "Supplier","Quit"},{"Add Product","Delete Product","Edit Product","ListAll Product","Quit"},{"Make an order","Quit"},{"Add Product to the order","End Order"},{"Send the Order to the Inventory"}};
            Object op = JOptionPane.showInputDialog(null, "Select one",
                    "Select one", JOptionPane.QUESTION_MESSAGE, null, options[0], options[0][0]);
            if (op.equals("Staff")){
                String userName= JOptionPane.showInputDialog("Enter User Name");
                while (!Validation.validate(userName,namePattern)){
                    userName = JOptionPane.showInputDialog("Please Enter only letters");
                }
                String password= JOptionPane.showInputDialog("Enter Your Password");
                if (userName.equals(Data.staffUserName)&&password.equals(Data.staffPassword)){
                    Staff staff=new Staff(userName,password);
                    while (true){

                        op = JOptionPane.showInputDialog(null, "Select Operation",
                                "Select Operation", JOptionPane.QUESTION_MESSAGE, null, options[1], options[1][0]);
                        if (op.equals("Add Product")){
                            String name=JOptionPane.showInputDialog("Enter Your Product Name : ");
                            if (!name.isEmpty()){
                                while (!Validation.validate(userName,namePattern)){
                                    userName = JOptionPane.showInputDialog("Please Enter only letters \n Product Name:");
                                }
                            }else{
                                while (name.isEmpty()){
                                    name=JOptionPane.showInputDialog("Name is required");
                                }
                            }


                            String id=JOptionPane.showInputDialog("Enter Your Product ID : ");

                            if (id.isEmpty()){
                                while (id.isEmpty()){
                                    id=JOptionPane.showInputDialog("ID is required ");
                                }
                            }else{
                                while (!Validation.isValid(id)){
                                    id=JOptionPane.showInputDialog("ID is invalid. Please Enter Only Numbers between 5 and 8");
                                }
                            }

                            String description=JOptionPane.showInputDialog("Enter Your Product Description : ");
                            while (description.isEmpty()){
                                description=JOptionPane.showInputDialog("Description is required ");
                            }
                            String price=JOptionPane.showInputDialog("Enter Your Product Price : ");
                            if (price.isEmpty()){
                                while (price.isEmpty()){
                                    price=JOptionPane.showInputDialog("Price is required ");
                                }
                            }else{
                                while (!Validation.isValidQuantity(price)){
                                    price=JOptionPane.showInputDialog("Price is invalid. Please Enter Only Numbers");

                                }
                            }

                            String quantity=JOptionPane.showInputDialog("Enter Your Product Quantity : ");
                            if (quantity.isEmpty()){
                                while (quantity.isEmpty()){
                                    quantity=JOptionPane.showInputDialog("Quantity is required ");
                                }
                            }else{
                                while (!Validation.isValidQuantity(quantity)){
                                    quantity=JOptionPane.showInputDialog("Quantity is invalid. Please Enter Only  Integer Numbers");
                                }
                            }

                            Product product=new Product(name,id.trim(),description,Double.parseDouble(price.trim()),Integer.parseInt(quantity.trim()));
                            AddCommand addCommand=new AddCommand();
                            worker.execute(addCommand,product);
                        }else if(op.equals("Delete Product")){
                            String id=JOptionPane.showInputDialog("Enter Your Product ID : ");

                            while (id.isEmpty()){
                                id=JOptionPane.showInputDialog("ID is required ");
                            }
                            Product product =staff.getById(id.trim());
                            DeleteCommand deleteCommand=new DeleteCommand();
                            worker.execute(deleteCommand,product);
                        } else if(op.equals("Edit Product")){
                            String id=JOptionPane.showInputDialog("Enter Your Product ID : ");
                            while (id.isEmpty()){
                                id=JOptionPane.showInputDialog("ID is required ");
                            }
                            Product product=staff.getById(id.trim());
                            String name=JOptionPane.showInputDialog("Enter New Name:");
                            if (!name.isEmpty()){
                                while (!Validation.validate(userName,namePattern)){
                                    userName = JOptionPane.showInputDialog("Please Enter only letters \n Product Name:");
                                }
                            }else{
                                while (name.isEmpty()){
                                    name=JOptionPane.showInputDialog("Name is required");
                                }
                            }
                            String description=JOptionPane.showInputDialog("Enter New Description:");
                            while (description.isEmpty()){
                                description=JOptionPane.showInputDialog("Description is required ");
                            }
                            String price=JOptionPane.showInputDialog("Enter New Price:");
                            if (price.isEmpty()){
                                while (price.isEmpty()){
                                    price=JOptionPane.showInputDialog("Price is required ");
                                }
                            }else{
                                while (!Validation.isValidQuantity(price)){
                                    price=JOptionPane.showInputDialog("Price is invalid. Please Enter Only Numbers");

                                }
                            }
                            EditCommand editCommand=new EditCommand();
                            worker.execute(editCommand,product,name,description,Double.parseDouble(price.trim()));
                        }else if(op.equals("ListAll Product")){
                            ListAllCommand listAllCommand=new ListAllCommand();
                            worker.execute(listAllCommand);
                        }else if (op.equals("Quit")){
                            break;
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"The data is wrong","The data is wrong",JOptionPane.ERROR_MESSAGE);
                }

            }else if(op.equals("Supplement Manager")){
                String userName= JOptionPane.showInputDialog("Enter User Name");
                while (!Validation.validate(userName,namePattern)){
                    userName = JOptionPane.showInputDialog("Please Enter only letters");
                }
                String password= JOptionPane.showInputDialog("Enter Your Password");
                while (password.isEmpty()){
                    password= JOptionPane.showInputDialog("Password is required");
                }
                if (userName.equals(Data.supplementUserName)&&password.equals(Data.supplementPassword)){
                    op = JOptionPane.showInputDialog(null, "Select Operation",
                            "Select Operation", JOptionPane.QUESTION_MESSAGE, null, options[2], options[2][0]);
                    if (op.equals("Make an order")){
                        while (true){
                            op = JOptionPane.showInputDialog(null, "Select Operation",
                                    "Select Operation", JOptionPane.QUESTION_MESSAGE, null, options[3], options[3][0]);
                            if (op.equals("Add Product to the order")){
                                OrderFromSupplier orderFromSupplierCommand=new OrderFromSupplier();
                                String name=JOptionPane.showInputDialog("Enter Your Product Name : ");
                                if (!name.isEmpty()){
                                    while (!Validation.validate(userName,namePattern)){
                                        userName = JOptionPane.showInputDialog("Please Enter only letters \n Product Name:");
                                    }
                                }else{
                                    while (name.isEmpty()){
                                        name=JOptionPane.showInputDialog("Name is required");
                                    }
                                }
                                String id=JOptionPane.showInputDialog("Enter Your Product ID : ");
                                if (id.isEmpty()){
                                    while (id.isEmpty()){
                                        id=JOptionPane.showInputDialog("ID is required ");
                                    }
                                }else{
                                    while (!Validation.isValid(id)){
                                        id=JOptionPane.showInputDialog("ID is invalid. Please Enter Only Numbers between 5 and 8");
                                    }
                                }
                                String description=JOptionPane.showInputDialog("Enter Your Product Description : ");
                                while (description.isEmpty()){
                                    description=JOptionPane.showInputDialog("Description is required ");
                                }
                                String price=JOptionPane.showInputDialog("Enter Your Product Price : ");
                                if (price.isEmpty()){
                                    while (price.isEmpty()){
                                        price=JOptionPane.showInputDialog("Price is required ");
                                    }
                                }else{
                                    while (!Validation.isValidQuantity(price)){
                                        price=JOptionPane.showInputDialog("Price is invalid. Please Enter Only Numbers");

                                    }
                                }
                                String quantity=JOptionPane.showInputDialog("Enter Your Product Quantity : ");
                                if (quantity.isEmpty()){
                                    while (quantity.isEmpty()){
                                        quantity=JOptionPane.showInputDialog("Quantity is required ");
                                    }
                                }else{
                                    while (!Validation.isValidQuantity(quantity)){
                                        quantity=JOptionPane.showInputDialog("Quantity is invalid. Please Enter Only Numbers");
                                    }
                                }
                                Product product=new Product(name,id.trim(),description,Double.parseDouble(price.trim()),Integer.parseInt(quantity.trim()));
                                worker.execute(orderFromSupplierCommand,product);
                            }else if(op.equals("End Order")){
                                break;
                            }
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"The data is wrong","The data is wrong",JOptionPane.ERROR_MESSAGE);

                }
            }else if(op.equals("Supplier")){
                String userName= JOptionPane.showInputDialog("Enter User Name");
                while (!Validation.validate(userName,namePattern)){
                    userName = JOptionPane.showInputDialog("Please Enter only letters");
                }
                String password= JOptionPane.showInputDialog("Enter Your Password");
                while (password.isEmpty()){
                    password= JOptionPane.showInputDialog("Password is required");
                }
                if (userName.equals(Data.supplierUserName)&&password.equals(Data.supplierPassword)){
                    op = JOptionPane.showInputDialog(null, "Select Operation",
                            "Select Operation", JOptionPane.QUESTION_MESSAGE, null, options[4], options[4][0]);
                    if (op.equals("Send the Order to the Inventory")){
                        SendOrderCommand sendOrderCommand=new SendOrderCommand();
                        worker.execute(sendOrderCommand);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"The data is wrong","The data is wrong",JOptionPane.ERROR_MESSAGE);
                }
            }else if(op.equals("Quit")){
                break;
            }
        }

    }
}
