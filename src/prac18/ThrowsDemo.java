package prac18;

public class ThrowsDemo {
    public void getDetails(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
            System.out.println("Key: " + key);
        } catch (NullPointerException e) {
            System.out.println("Caught exception inside getDetails: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        demo.getDetails(null);
        demo.getDetails("validKey");
    }
}
