import java.util.ArrayList;

public class Customer{

    private ArrayList<Product> shoppingList;
    private double money;

    public Customer() {
        shoppingList = new ArrayList<Product>();

        int noProducts;

        //Loops over all values of the enum and fills them with between 0 and 2 products
        for (Product.type t : Product.type.values()) {
            //generate a random int between 0 and 2 (inclusive)
            noProducts = (int) Math.floor(Math.random() * 3);

            if (noProducts > 0) {
                shoppingList.add(new Product(t, noProducts));
            }
        }

        //If there is nothing on the shopping list, add one milk
        if (shoppingList.isEmpty()) {
            shoppingList.add(new Product(Product.type.MILK, 1));
        }

        //generate a random number between 15 and 30 (inclusive) for customer money
        money = Math.round(Math.random() * 15) + 15;
    }

    //Method to verify whether the customer can pay for the shopping or not
    public boolean canPay(double amount){
        return(money > amount);
    }

    //Method to simulate the payment
    public double pay(double amount){
        if(money>amount){
            money -= amount;
            return money;
        }else{
            throw new CustomerException("Customer cannot afford to pay bill.");
        }
    }

    //gets ShoppingList
    public ArrayList<Product> getShoppingList(){
        return shoppingList;
    }

    //Override toString
    @Override
    public String toString(){
        return shoppingList.toString();
    }

}

class CustomerException extends RuntimeException {
    public CustomerException(String s) {
        super(s);
    }
}