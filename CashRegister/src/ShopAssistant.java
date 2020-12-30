public class ShopAssistant {

    int id;
    String name;
    double hoursWorked, hourlyPay;

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

    //Setter for id
    public void setid(int id) {
        if(id>0){
            this.id = id;
        }else{
            throw new IllegalArgumentException("Cannot set ID to negative number.");
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
}
