package cd.litl.artOfConcurrency.chapter6;

public class DoubleHashTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(doubleHash(Integer.parseInt("0001111", 2)) & doubleHash(15));
        System.out.println(doubleHash(Integer.parseInt("0011111", 2) & 15));
        System.out.println(doubleHash(Integer.parseInt("0111111", 2) & 15));
        System.out.println(doubleHash(Integer.parseInt("1111111", 2) & 15));
        
        
        
        System.out.println(Integer.parseInt("0001111", 2) & 15);
        System.out.println(Integer.parseInt("0011111", 2) & 15);
        System.out.println(Integer.parseInt("0111111", 2) & 15);
        System.out.println(Integer.parseInt("1111111", 2) & 15);
    }

    private static int doubleHash(int h) {
        h += (h << 15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h << 3);
        h ^= (h >>> 6);
        h += (h << 2) + (h << 14);
        return h ^ (h >>> 16);
    }

}
