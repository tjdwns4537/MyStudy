public class Main {
    public static void main(String[] args) {
        Babylonian bl = new Babylonian();
        int num = 6;
        double b = bl.BL(num);
        String res = String.format("%.2f",b);
        System.out.println(res);
    }
}
