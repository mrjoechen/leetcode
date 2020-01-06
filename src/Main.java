
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int i = 4;
        int j = -4;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(j));

        //判断两个数的符号是否相等  ^ 异或 相同 为 0
        System.out.println(((i >> 31) ^ (j >> 31)) == 0);

    }

}
