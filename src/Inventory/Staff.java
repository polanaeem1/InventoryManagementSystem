package Inventory;

import Inventory.Inventory;

import javax.swing.*;

/**
 * This Class contains everything belongs to the Staff
 */
public class Staff {

    private String userName;
    private String password;

    public Staff(String userName,String password){
        this.userName=userName;
        this.password=password;
    }
    public Staff(){
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * This Method is responsible for adding a product to the Inventory
     *
     * @param product This is the product that will be sent to the Inventory
     */
   public void add(Product product){
        boolean flag=false;
        for (int i = 0; i< Inventory.container.size(); i++){
            Product p=(Product) Inventory.container.get(i);
            if (p.getID().equals(product.getID())){
                JOptionPane.showMessageDialog(null,"This ID is already used","This ID is already used",JOptionPane.WARNING_MESSAGE);
                flag=true;
                break;
            }
        }
        if (flag){

        }else{
            Inventory.container.add(product);
            JOptionPane.showMessageDialog(null,"Product added Successfully","Product added Successfully",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This Method deletes the product from Inventory
     *
     * @param id This is the id of the product that will be deleted form the Inventory
     */
    public void delete(String id){
        int counter=0;
        for (int i=0;i<Inventory.container.size();i++){
            Product p=(Product) Inventory.container.get(i);
            if (p.getID().equals(id)){

            }else{
                counter++;
            }
        }
        if (counter==Inventory.container.size()){
            JOptionPane.showMessageDialog(null,"The Product is not Found","The Product is not Found",JOptionPane.ERROR_MESSAGE);
        }else{
            if (Inventory.container.size()==0){
                JOptionPane.showMessageDialog(null,"The Inventory is Empty","The Inventory is Empty",JOptionPane.ERROR_MESSAGE);
            }else{
                for (int i=0;i<Inventory.container.size();i++){
                    Product product=(Product)Inventory.container.get(i);
                    if (product.getID().equals(id)){
                        Inventory.container.remove(product);
                        JOptionPane.showMessageDialog(null,"Product deleted Successfully","Product deleted Successfully",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }



    }

    /**
     * This Method finds the Product by its ID
     *
     * @param id this is the ID of a product
     * @return this returns ID's Product
     */
    public Product getById(String id){
        int counter=0;
        for (int i=0;i<Inventory.container.size();i++){
            Product p=(Product) Inventory.container.get(i);
            if (p.getID().equals(id)){

            }else{
                counter++;
            }
        }
        if (counter==Inventory.container.size()){

        }else{
            for (int i=0;i<Inventory.container.size();i++){
                Product product=(Product)Inventory.container.get(i);
                if (product.getID().equals(id)){
                    return product;
                }
            }
        }

        return null;
    }

    /**
     * This Method edits Product's details (Name , Description , Price )
     *
     * @param product The Product that will be updated
     * @param name The New Name of the product
     * @param description The New Description of the product
     * @param price The New Price of the product
     */
    public void edit(Product product, String name, String description, double price){
       if (product==null){
           JOptionPane.showMessageDialog(null,"This Product is not existed in Products' List","This Product is not existed in Products' List",JOptionPane.ERROR_MESSAGE);
       }else{
           if (Inventory.container.size()==0){
               JOptionPane.showMessageDialog(null,"The Inventory is Empty","The Inventory is Empty",JOptionPane.ERROR_MESSAGE);
           }else{
               int x=Inventory.container.indexOf(product);
               Product newProduct= new Product(name,product.getID(),description,price,product.getQuantity());
               newProduct.setName(name);
               newProduct.setDescription(description);
               newProduct.setID(product.getID());
               newProduct.setPrice(price);
               newProduct.setQuantity(product.getQuantity());
               Inventory.container.set(x,newProduct);
               JOptionPane.showMessageDialog(null,"Product updated Successfully","Product updated Successfully",JOptionPane.INFORMATION_MESSAGE);
           }
       }


    }

    /**
     * This Method prints all Products in the Inventory
     */
    public void listAll(){
        if (Inventory.container.size()==0){
            JOptionPane.showMessageDialog(null,"No Products Yet","No Products Yet",JOptionPane.ERROR_MESSAGE);
        }else{
            String res="";
            for (int i=0; i<Inventory.container.size();i++){
                Product product;
                product = (Product) Inventory.container.get(i);
                res+=product.toString()+" \n";
            }
            JOptionPane.showMessageDialog(null,res);
        }

    }


}
