package clasinjava;

public class box1 extends box {
    double weight;

    public box1() {
        this.weight = -1;
    }

    static void greeting() {
        System.out.println("hey ,iam here;greetings");
    }

    box1(box1 other) {
        super(other);
        weight = other.weight;
    }

    box1(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    box1(double l, double w, double h, double weight) {
        super(l, h, w);
        this.weight = weight;
    }
}
