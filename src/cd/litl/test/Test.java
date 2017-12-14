package cd.litl.test;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }

        System.out.println(j);

        boolean test = true;
        System.out.println(test);
        test(test);
        System.out.println(test);

        StringBuffer str = new StringBuffer("hello");

        System.out.println(str.toString());
        test2(str);
        System.out.println(str.toString());

        String str3 = "hello";

        System.out.println(str3);
        test3(str3);
        System.out.println(str3);
    }

    public static void test(boolean test) {

        test = !test;
        System.out.println(test);
    }

    public static void test2(StringBuffer str) {

        str.append(" , world!");
        System.out.println(str.toString());
    }

    public static void test3(String str) {

        str = " , world!";
        System.out.println(str);
    }
}
