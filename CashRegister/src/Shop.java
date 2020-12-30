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
}
