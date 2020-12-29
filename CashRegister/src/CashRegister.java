//CashRegister class based on labs by Simon Caton UCD
//By Luke Boyle 29/12/2020

import java.util.ArrayList;

public class CashRegister {
    private double money;  //cash in the register
    public ArrayList<String> transactions = new ArrayList<String>(); //will hold the list of transactions that take place

    //Constructor for cash register with logic constraints
    public CashRegister(double money){
        if(money >= 0){
            this.money = money;
            transactions.add("Register was constructed with " + money + " euro starting.");
        }else{
            throw new IllegalArgumentException("Cannot set money value to negative");
        }
    }

    //Setter for money - logic constraints
    public void setMoney(double money){
        if(money >= 0){
            this.money = money;
        }else{
            throw new IllegalArgumentException("Cannot set money value to negative");
        }
    }

    //Getter for money
    public double getMoney(){
        return money;
    }

    //Override the toString method to get a sentence that is more useful to us
    @Override
    public String toString(){
        return "There is " + money + " euro in the register.";
    }

    //Add function for the cash register
    public void add(double d){
        if(d>=0){
            setMoney(getMoney()+d);
            transactions.add(d + " euro was added to the register. There is now "+ getMoney() + " euro in the register.");
        }else{
            throw new IllegalArgumentException("Cannot add a negative value");
        }
    }

    //Remove function for the cash register
    public void remove(double d) {
        if (d >= 0 && (getMoney() - d >= 0)) {
            setMoney(getMoney() - d);
            transactions.add(d + " euro was removed from the register. There is now "+ getMoney() + " euro in the register");
        } else if (getMoney() - d < 0) {
            throw new IllegalArgumentException("Not enough money in register to remove this amount.");
        }else{
            throw new IllegalArgumentException("Cannot subtract a negative value.");
        }
    }

    //Function to print the last number of transactions specified by user.  If the user wants more transactions than how many have taken place, method will just print all transactions.
    public void printLast(int n){
        int len = transactions.size();

        if(n > len){
            n = len;

            for(int i=0;i<n;i++){
                System.out.println(transactions.get(i));
            }
        }else{
            for(int i=len-n; i < len; i++){
                System.out.println(transactions.get(i));
            }
        }
    }


    //Examples
//    public static void main(String[] args){
//        CashRegister p = new CashRegister(50);
//        p.add(10);
//        p.remove(20);
//        p.add(100);
//        p.remove(30);
//
//        p.printLast(10);
//    }
}
