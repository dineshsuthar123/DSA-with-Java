package introduction;

public class Ifelse {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int salary = 10001;
        if (salary > 10000) {
            salary = salary + 3000;
        } else if (salary < 10000) {
            salary += 2000;
        } else
            salary += 1000;

        System.out.println(salary);
    }
}