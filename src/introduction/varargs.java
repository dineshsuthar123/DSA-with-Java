package introduction;

import java.util.Arrays;

public class varargs {
    public static void main(String[] args) {
        fun(23, 234, 24, 42, 4, 31, 3113, 13, 3, 13, 13, 13, 31, 3, 1, 3, 113, 1);
    }

    static void fun(int... v) {
        System.out.println(Arrays.toString(v));
    }
}
