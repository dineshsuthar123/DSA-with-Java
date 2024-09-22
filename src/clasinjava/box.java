package clasinjava;

public class box {
    double l;
    double w;
    double h;

    static void greeting() {
        System.out.println("iam in box");
    }

    box() {
        this.l = 1;
        this.w = 1;
        this.h = 1;
    }

    box(double side) {
        this.w = side;
        this.l = side;
        this.h = side;
    }

    box(double l, double w, double h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    box(box other) {
        this.h = other.h;
        this.l = other.l;
        this.w = other.w;
    }
}
