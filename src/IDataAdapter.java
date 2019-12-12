
public interface IDataAdapter {

    public static final int CONNECTION_OPEN_OK = 100;
    public static final int CONNECTION_OPEN_FAILED = 101;

    public static final int CONNECTION_CLOSE_OK = 200;
    public static final int CONNECTION_CLOSE_FAILED = 201;

    public static final int PRODUCT_SAVE_OK = 300;
    public static final int PRODUCT_SAVE_FAILED = 301;

    public static final int CUSTOMER_SAVE_OK = 400;
    public static final int CUSTOMER_SAVE_FAILED = 401;

    public static final int PURCHASE_SAVE_OK = 500;
    public static final int PURCHASE_SAVE_FAILED = 501;

    public static final int USER_SAVE_OK = 600;
    public static final int USER_SAVE_FAILED = 601;

    public int connect(String dbfile);
    public int disconnect();

    public ProductModel loadProduct(int id);
    public int saveProduct(ProductModel model);

    public CustomerModel loadCustomer(int id);
//    public int saveCustomer(CustomerModel model);
//
//    public int loadPurchase(int id);
    public int savePurchase(PurchaseModel model);

    public PurchaseHistoryModel loadPurchaseHistory(int customerID);

    public UserModel loadUser(String username);
    //public int saveUser(UserModel user);
}
