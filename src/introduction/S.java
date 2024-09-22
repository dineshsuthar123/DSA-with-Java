package introduction;

public class S {
    public static void main(String[] args) {
        String name = greet("dinesh suthar");
        System.out.println(name);
    }

    static String greet(String nam) {
        String dinesh = "hello " + nam;
        return dinesh;
    }
}
