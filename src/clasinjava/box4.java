package clasinjava;

public class box4 extends box1 {
    double cost;

    box4() {
        super();
        this.cost = -1;
    }

    box4(box4 other) {
        super(other);
        this.cost = other.cost;
    }

    box4(double l, double w, double h, double weight, double cost) {
        super(l, h, w, weight);
        this.cost = cost;
    }

    box4(double side, double weight, double cost) {
        super(side, weight);
        this.cost = cost;
    }
}
