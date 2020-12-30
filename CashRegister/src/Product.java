public class Product {
    public enum type{COFFEE, BISCUITS, MILK, BACON, NEWSPAPER};
    private type t;
    private int quantity;

    //Constructor
    public Product(type t, int quantity){
        this.t = t;

        if(quantity>0){
            this.quantity = quantity;
        }else{
            throw new IllegalArgumentException("Cannot set quantity to negative.");
        }
    }

    //Setter for quantity
    public void setQuantity(int quantity) {
        if(quantity>=0){
            this.quantity = quantity;
        }else{
            throw new IllegalArgumentException("Cannot set quantity to negative");
        }
    }

    //Getter for quantity
    public int getQuantity(){
        return quantity;
    }

    //Getter for type
    public type getT(){
        return t;
    }

    //Method to get the cost of a specific amount of products
    public double getCost(int num, type n){
        switch(t){
            case COFFEE:
                return num*4.99;
            case BISCUITS:
                return num*2.99;
            case MILK:
                return num*2;
            case BACON:
                return num*3.79;
            default:
                return num*1;
        }
    }

    //Override toString statement to give more useful information.
    @Override
    public String toString(){
        return quantity + " " + t;
    }
}
