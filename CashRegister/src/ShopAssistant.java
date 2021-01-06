public class ShopAssistant {

    int id;
    String name;
    double hoursWorked, hourlyPay;
    Shop shop;

    //Constructor
    public ShopAssistant(int id, String name){
        if(id >0){
            this.id =id;
        }else{
            throw new IllegalArgumentException("Cannot set ID to negative number.");
        }

        if(name != null){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Cannot set name to null.");
        }
    }

    //Getter for id
    public int getid(){
        return id;
    }

    //Setter for name
    public void setName(String name){
        if(name != null){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Cannot set name to null");
        }
    }

    //Getter for name
    public String getName(){
        return name;
    }

    //Setter for hoursWorked
    public void setHoursWorked(double hoursWorked){
        if(hoursWorked>=0){
            this.hoursWorked = hoursWorked;
        }else{
            throw new IllegalArgumentException("Cannot set hours worked to be negative.");
        }
    }

    //Getter for hoursWorked
    public double getHoursWorked(){
        return hoursWorked;
    }

    //Setter for hourlyPay
    public void setHourlyPay(double hourlyPay){
        if(hourlyPay>=0){
            this.hourlyPay = hourlyPay;
        }else{
            throw new IllegalArgumentException("Cannot set hourly pay to be negative.");
        }
    }

    //Getter for hourlyPay
    public double getHourlyPay(){
        return hourlyPay;
    }

    //Set shop to work in
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    //Calculate pay
    public double calculatePay(){
        return getHourlyPay() * getHoursWorked();
    }

    //Serve method
    public void serve(Customer c){
        c.getShoppingList();  //gets customer's shopping list
        double bill = 0;  //creates a double to store the cost of their shopping

        //Go through shopping list and check if shop has each
        for(Product p : c.getShoppingList()){
            if(shop.hasProduct(p)){
                bill += p.getCost(p.getQuantity(), p.getT()); //add cost to bill
            }
            //Check if customer can pay the bill
            if(c.canPay(bill)){
                //remove quantity from shop
                for(int i=0;i<p.getQuantity();i++){
                    shop.soldProduct(p);
                }

                c.pay(bill);
                shop.setRegister(bill + shop.getRegister()); //adds to register
            }
        }
    }
}
