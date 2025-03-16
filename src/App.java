public class App {
    public static void main(String[] args) throws Exception {
        Slice_o_Heaven pizza1 = new Slice_o_Heaven();

        pizza1.storeName = "Slice-o-Heaven";
        pizza1.storeAddress = "123 Pizza Street";
        pizza1.storeEmail = "contact@sliceoheaven.com";
        pizza1.storePhone = 1234567890L;

        pizza1.takeOrder();


        System.out.println(pizza1);
    }
}