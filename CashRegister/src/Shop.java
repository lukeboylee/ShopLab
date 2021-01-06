public class Shop {

    private ShopAssistant sa;
    private CashRegister register;
    private Product bacon, biscuits, coffee, milk, newspaper;

    public Shop(int storageSize, double openCash, ShopAssistant sa){
        //Sets the products and fills them to max quantity
        bacon = new Product(Product.type.BACON, storageSize);
        biscuits = new Product(Product.type.BISCUITS, storageSize);
        coffee = new Product(Product.type.COFFEE, storageSize);
        milk = new Product(Product.type.MILK, storageSize);
        newspaper = new Product(Product.type.NEWSPAPER, storageSize);

        //Sets opening cash in register
        register = new CashRegister(openCash);

        //Sets sales assistant and hourly pay
        this.sa = sa;
        sa.setHourlyPay(12);
        sa.setShop(this);
    }

    //Method for having customer enter
    public void walkIn(Customer c){
        System.out.println("Serving " + c);
        sa.serve(c);
    }

    //Method for checking if shop has product in stock
    public boolean hasProduct(Product p){
        switch(p.getT()){
            case MILK:
                return milk.getQuantity() >= p.getQuantity();
            case BACON:
                return bacon.getQuantity() >= p.getQuantity();
            case COFFEE:
                return coffee.getQuantity() >= p.getQuantity();
            case BISCUITS:
                return biscuits.getQuantity() >= p.getQuantity();
            default:
                return newspaper.getQuantity() >= p.getQuantity();
        }
    }

    //Method for selling product
    public void soldProduct(Product p){
        switch(p.getT()){
            case BACON:
                bacon.setQuantity(bacon.getQuantity() - p.getQuantity());
                break;
            case MILK:
                milk.setQuantity(milk.getQuantity() - p.getQuantity());
                break;
            case COFFEE:
                coffee.setQuantity(coffee.getQuantity() - p.getQuantity());
                break;
            case BISCUITS:
                biscuits.setQuantity(biscuits.getQuantity() - p.getQuantity());
                break;
            default:
                newspaper.setQuantity(newspaper.getQuantity() - p.getQuantity());
        }
    }

    //Accessor method for cash register
    public void setRegister(double m){
        register.setMoney(m);
    }
    //Getter for cash register
    public double getRegister(){
        return register.getMoney();
    }

    //Shop close method - stock take
    public void close(){
        sa.setHoursWorked(5);
        register.remove(sa.calculatePay()); //pays assistant from register

        System.out.println("Today's transactions:");
        register.printLast(100);

        System.out.println("Current Product Numbers:");
        System.out.println(bacon);
        System.out.println(biscuits);
        System.out.println(coffee);
        System.out.println(milk);
        System.out.println(newspaper);
    }


    //Method to simulate life at the shop
    public static void main(String[] args){
        Shop shop = new Shop(250,200, new ShopAssistant(42, "Frank"));

        for(int i=0;i<50;i++){
            shop.walkIn(new Customer());
        }

        shop.close();
    }
}
